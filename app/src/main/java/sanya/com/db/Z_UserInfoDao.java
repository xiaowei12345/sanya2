package sanya.com.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.util.List;

import sanya.com.bean.Life_UserInfo;


/**
 * Created by luoliwen on 16/4/28.
 * 完成对数据库的CRUD的操作
 */
public class Z_UserInfoDao {
    private Context context;
    private Dao<Life_UserInfo, Integer> userDao;
    private Z_DataBaseHelper helper;

    public Z_UserInfoDao(Context context) {
        this.context = context;
        helper = Z_DataBaseHelper.getInstance(context);
        try {
            userDao = helper.getDao(Life_UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addUser(String account, String password
    ) {
        try {
            Life_UserInfo user = new Life_UserInfo();
            user.setAccount(account);
            user.setPassword(password);
            userDao.create(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public boolean shifoucunzai(String account) {
        try {
            List<Life_UserInfo> account1 = userDao.queryBuilder().where().eq("account", account).query();
            if (account1.size() >0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getpassword(String account) {
        try {
            Life_UserInfo account1 = userDao.queryBuilder().where().eq("account", account).query().get(0);
            return account1.getPassword();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
