package sanya.com.Utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import sanya.com.adapter.CollectAdapter;
import sanya.com.bean.Collect;
import sanya.com.bean.SceneryInfo;
import sanya.com.sanya.R;
import sanya.com.tools.FileUtils;
import sanya.com.tools.JsonSceneryInfo;

/**
 * Created by 星蓝 on 2015/12/4.
 */
public class SaveUtils_food {
    private DbUtils dbUtils;
    private Context context;
    private TextView tv_edit;
    private CollectAdapter adapter;
    private boolean flag;
    private ImageView ivCollect;
    private List<Collect>list = new ArrayList<>();
    private InputStream is;
    private SceneryInfo sceneryInfo;
    public SaveUtils_food(Context context, boolean flag, ImageView ivCollect, InputStream is, SceneryInfo sceneryInfo){
        this.context = context;
        //this.tv_edit = tv_edit;
        this.flag = flag;
        this.ivCollect = ivCollect;
        this.is = is;
        this.sceneryInfo = sceneryInfo;
    }

    //Fragment_Collect fc = new Fragment_Collect();

    public void Save(){
        dbUtils = DbUtils.create(context, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(),"Collect2");
        //Collect collect = new Collect();
        adapter = new CollectAdapter(list,context,null);
        try {
            list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", sceneryInfo.getName()).orderBy("name",true));
            sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
            Log.i("favorite",""+list);
            if (list.size()!= 0){
                adapter.list = list;
                adapter.notifyDataSetChanged();
                flag = false;
                ivCollect.setImageResource(R.mipmap.btn_favorited);
            }else {
                flag = true;
                ivCollect.setImageResource(R.mipmap.btn_favorite);
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
