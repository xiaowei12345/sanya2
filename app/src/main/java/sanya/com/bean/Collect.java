package sanya.com.bean;

/**
 * Created by 星蓝 on 2015/12/2.
 */
public class Collect {
    private int image;
    private String name;
    private long id;
    private boolean flag;
    private boolean fg;
    private String type;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isFg() {return fg;}

    public void setFg(boolean fg) {this.fg = fg;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", flag=" + flag +
                '}';
    }
}
