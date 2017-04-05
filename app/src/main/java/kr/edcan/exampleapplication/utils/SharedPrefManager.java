package kr.edcan.exampleapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sunrin on 2017-04-03.
 */

public class SharedPrefManager {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static SharedPrefManager getInstance(Context context) {
        return new SharedPrefManager(context);
    }

    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("example", 0);
        editor = sharedPreferences.edit();
    }

    public String getSelectedClass() {
        return ((sharedPreferences.getInt("class", -1) != -1) ? "3학년 " + sharedPreferences.getInt("class", -1) + "반" : "저장된 반이 없습니다");
    }

    public void saveSelectedClass(int classNumber) {
        editor.putInt("class", classNumber);
        editor.apply();
    }

    public String getId() {
        return (sharedPreferences.getString("id", ""));
    }

    public void saveId(String idValue) {
        editor.putString("id", idValue);
        editor.apply();
    }
    public void destroy(){
        editor.remove("class");
        editor.apply();
    }
}
