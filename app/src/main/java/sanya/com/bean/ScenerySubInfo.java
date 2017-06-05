package sanya.com.bean;

/**
 * Created by Sep
 */
public class ScenerySubInfo {
    private String title;
    private String contents;

    public ScenerySubInfo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public ScenerySubInfo(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
