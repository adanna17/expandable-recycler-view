package kr.ac.mashup.jungmin.samplekjm.model;


import android.os.Parcel;
import android.os.Parcelable;

public class ChildData implements Parcelable {

    private String debtorName;
    private int childPrice;
    private boolean isFavorite;

    public ChildData(String name, int price){
        this.debtorName = name;
        this.childPrice = price;
        this.isFavorite = false;
    }

    protected ChildData(Parcel in) {
        debtorName = in.readString();
        childPrice = in.readInt();
        isFavorite = in.readByte() != 0;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public int getChildPrice() {
        return childPrice;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public static final Creator<ChildData> CREATOR = new Creator<ChildData>() {
        @Override
        public ChildData createFromParcel(Parcel in) {
            return new ChildData(in);
        }

        @Override
        public ChildData[] newArray(int size) {
            return new ChildData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(debtorName);
        dest.writeInt(childPrice);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }
}
