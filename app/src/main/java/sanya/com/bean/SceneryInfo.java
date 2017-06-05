package sanya.com.bean;

import java.util.List;

/**
 * Created by Sep
 */
public class SceneryInfo {
    private String name;
    private String cover;
    private String lat;
    private String lng;
    private String level;
    private String levelDesc;
    private String introduce;
    private List<ScenerySubInfo> list;
    public SceneryInfo( String name, String lat, String lng, String level, String levelDesc, String introduce,List<ScenerySubInfo> list) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.level = level;
        this.levelDesc = levelDesc;
        this.introduce = introduce;
        this.list = list;
    }

    public List<ScenerySubInfo> getList() {
        return list;
    }

    public void setList(List<ScenerySubInfo> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


}
