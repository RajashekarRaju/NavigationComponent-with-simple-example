package com.developersbreach.navigator;

import android.os.Parcel;
import android.os.Parcelable;

public class Navigator implements Parcelable {

    private int mNavigatorIcon;
    private String mNavigatorName;

    public Navigator(int navigatorIcon, String navigatorName) {
        this.mNavigatorIcon = navigatorIcon;
        this.mNavigatorName = navigatorName;
    }

    public int getNavigatorIcon() {
        return mNavigatorIcon;
    }

    public String getNavigatorName() {
        return mNavigatorName;
    }

    private Navigator(Parcel in) {
        mNavigatorIcon = in.readInt();
        mNavigatorName = in.readString();
    }

    public static final Creator<Navigator> CREATOR = new Creator<Navigator>() {
        @Override
        public Navigator createFromParcel(Parcel in) {
            return new Navigator(in);
        }

        @Override
        public Navigator[] newArray(int size) {
            return new Navigator[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mNavigatorIcon);
        parcel.writeString(mNavigatorName);
    }
}
