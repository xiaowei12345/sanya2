package sanya.com.tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sanya.com.bean.Stay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class JsonStay {
    private static Stay stay;
    public static List<Stay> parse(String str) {
        List<Stay> list1 = new ArrayList<Stay>();
        try {
            JSONObject object =  new JSONObject(str);
           JSONArray array =  object.getJSONArray("Infolist");
            for(int i = 0;i <array.length();i++){
               JSONObject object1 =  array.getJSONObject(i);
               String name =  object1.optString("Title");
                String cover = object.optString("picUrl");
                String level = object1.optString("Level");
                String lecelDesc = object1.optString("LevelDesc");
                String Desc =object1.optString("Desc");
                 stay = new Stay(name,cover,level,lecelDesc,Desc);
                list1.add(stay);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list1;
    }
}
