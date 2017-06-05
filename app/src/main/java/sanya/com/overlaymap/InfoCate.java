package sanya.com.overlaymap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WEN on 2015/12/5.
 */
public class InfoCate implements Serializable{

    private double latitude;  //经度
    private double longitude;//纬度
//    private int imageId;
    private String name;//搜索的名称

    public static List<InfoCate> infoCates = new ArrayList<InfoCate>();
    static  {
        infoCates.add(new InfoCate(18.298313, 109.401938,"aa"));
        infoCates.add(new InfoCate(18.24478, 109.516007,"aa"));
        infoCates.add(new InfoCate(18.271363, 109.501882,"aa"));
        infoCates.add(new InfoCate(18.256755, 109.506775,"aa"));
        infoCates.add(new InfoCate(18.248042, 109.510615,"aa"));
        infoCates.add(new InfoCate(18.255192, 109.50731,"aa"));
        infoCates.add(new InfoCate(18.258334, 109.522908,"aa"));
        infoCates.add(new InfoCate(18.246489, 109.513455,"aa"));
        infoCates.add(new InfoCate(18.243956, 109.515338,"aa"));
        infoCates.add(new InfoCate(18.243347, 109.569948,"aa"));
    }

    public InfoCate(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

//    public int getImageId() {
//        return imageId;
//    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }
}
