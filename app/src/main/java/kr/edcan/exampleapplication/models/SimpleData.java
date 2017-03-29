package kr.edcan.exampleapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sunrin on 2017-03-29.
 */

public class SimpleData implements Parcelable{
    int number;
    String data;
    public SimpleData(int number, String data){
        this.number = number;
        this.data = data;
    }
    public SimpleData(Parcel src){
        this.number = src.readInt();
        this.data = src.readString();
    }
    public static final Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Object createFromParcel(Parcel source) {
            return new SimpleData(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new SimpleData[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(data);
    }

    public int getNumber() {
        return number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
