package sanya.com.tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sanya.com.bean.SceneryInfo;
import sanya.com.bean.ScenerySubInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class JsonSceneryInfo {

    private static SceneryInfo sceneryInfo;

    public static SceneryInfo parse(String str) {
        List<ScenerySubInfo> list1 = new ArrayList<ScenerySubInfo>();
        JSONObject object = null;
        try {
            object = new JSONObject(str);
            String name = object.getString("Name");
            // String cover = object.getString("Cover");
            JSONObject object1 = object.getJSONObject("Location");
            String lat = object1.getString("lat");
            String lng = object1.getString("lng");
            String level = object.getString("Level");
            String levelDesc = object.getString("LevelDesc");
            String introduce = object.getString("Introduce");
            JSONArray array = object.getJSONArray("ExtraInfos");

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj1 = array.getJSONObject(i);
                String title = obj1.getString("Title");
                String contents = obj1.getString("Contents");

                String price = contents.substring(2,contents.length()-2);
                ScenerySubInfo scenerySubInfo = new ScenerySubInfo(title,price);
                list1.add(scenerySubInfo);
            }
            sceneryInfo = new SceneryInfo(name, lat, lng, level, levelDesc, introduce, list1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sceneryInfo;
    }
}
