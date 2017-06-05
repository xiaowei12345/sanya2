package sanya.com.bean;

/**
 * Created by Sep
 */
public class Stay {
    private String name;
    private String cover;
    private String level;
    private String levelDesc;
    private String introduce;

    public Stay(String name, String cover, String level, String levelDesc, String introduce) {
        this.name = name;
        this.introduce = introduce;
        this.cover = cover;
        this.level = level;
        this.levelDesc = levelDesc;
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

    @Override
    public String toString() {
        return "Stay{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", level='" + level + '\'' +
                ", levelDesc='" + levelDesc + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
