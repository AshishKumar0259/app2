package my.fishdetection.model;

public class recycleviewModel{
     int image;
     String textview1;
     String textview2;
     String textview3;

    public int getImage() {
        return image;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public recycleviewModel(int image, String textview1, String textview2, String textview3)
    {
        this.image=image;
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
    }
}
