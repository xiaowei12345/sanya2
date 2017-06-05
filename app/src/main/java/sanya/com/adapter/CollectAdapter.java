package sanya.com.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

import sanya.com.bean.Collect;
import sanya.com.sanya.R;


/**
 * Created by 星蓝 on 2015/12/2.
 */
public class CollectAdapter extends BaseAdapter {
    public List<Collect> list;
    private Context context;
    //private ListView lv;
    private DbUtils dbUtils;
    private TextView tv_edit;

    public CollectAdapter(List<Collect> list ,Context context ,TextView tv_edit) {
        this.list = list;
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.context = context;
        //this.dbUtils = dbUtils;
        this.tv_edit = tv_edit;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        dbUtils = DbUtils.create(context, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(),"Collect2");
        if (convertView == null)
        {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_collect_item, parent,false);
            vh.list_iv = (ImageView) convertView.findViewById(R.id.list_iv);
            vh.list_tv = (TextView) convertView.findViewById(R.id.list_tv);
            vh.tv_delete = (TextView) convertView.findViewById(R.id.tv_delete);
            vh.iv_forword = (ImageView) convertView.findViewById(R.id.iv_forword);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        final Collect collect=list.get(position);
        Log.i("test",""+collect);
        if (!collect.isFlag())
        {
            vh.iv_forword.setVisibility(View.INVISIBLE);
            vh.tv_delete.setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.tv_delete).setFocusable(true);
            //lv.setFocusable(false);
        }else {
            vh.tv_delete.setVisibility(View.INVISIBLE);
            vh.iv_forword.setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.tv_delete).setFocusable(false);
            //lv.setFocusable(true);
        }
        vh.list_iv.setImageResource(collect.getImage());
        vh.list_tv.setText(collect.getName());
        //convertView.findViewById(R.id.tv_delete).setFocusable(true);
        convertView.findViewById(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("出发三亚")
                        .setMessage("确定要删除此项?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    dbUtils.deleteById(Collect.class, collect.getId());
                                    list=dbUtils.findAll(Collect.class);
                                    if (list.size() == 0){
                                        tv_edit.setVisibility(View.GONE);
                                    }else {
                                        tv_edit.setVisibility(View.VISIBLE);
                                    }
                                    notifyDataSetChanged();
                                } catch (DbException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setNegativeButton("取消",null).show();
            }
        });
        return convertView;
    }

}
class ViewHolder{
    ImageView list_iv;
    TextView list_tv;
    TextView tv_delete;
    ImageView iv_forword;
}