package sanya.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanya.com.bean.Stay;
import sanya.com.sanya.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class StayAdapter extends BaseAdapter {
    private List<Stay> list = new ArrayList<>();
    private int[]image;

    public StayAdapter(List<Stay> list,int[] image) {
        this.list = list;
        this.image= image;
    }
    public void addAll(List<Stay> data){
        list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_stay, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
       Stay stay =  list.get(position);
        float star = Float.parseFloat(stay.getLevel());
        vh.toScenery.setText(stay.getName());
        vh.ivScenery.setImageResource(image[position]);
        vh.tvKeywords.setText(stay.getLevelDesc());
        vh.tvDetail.setText(stay.getIntroduce());
        vh.rbarItem.setRating(5*star/5);
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'list_item_stay.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @BindView(R.id.to_scenery)
        TextView toScenery;
        @BindView(R.id.rbar_item)
        RatingBar rbarItem;
        @BindView(R.id.tv_keywords)
        TextView tvKeywords;
        @BindView(R.id.tv_detail)
        TextView tvDetail;
        @BindView(R.id.iv_scenery)
        ImageView ivScenery;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
