package sanya.com.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by 他的猫 on 2017/1/7.
 */
@DatabaseTable(tableName = "Life_UserInfo")
public class Life_UserInfo implements Serializable {
    /**
     * 主键ID
     */
    @DatabaseField(id = true)
    protected String id;
    private static final long serialVersionUID = 6337104618534280060L;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DatabaseField
    private String account;
    @DatabaseField
    private String password;


}
