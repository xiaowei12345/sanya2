package sanya.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class SceneryAdapter extends BaseAdapter{
    private int[] image;
    private String[] name;
    private String[] levelDesc;
    private String[] introduce;
    private int[] rBar;

    public SceneryAdapter(int[] image, String[] name, String[] levelDesc, String[] introduce,int[] rBar) {
        this.image = image;
        this.name = name;
        this.levelDesc = levelDesc;
        this.introduce = introduce;
        this.rBar = rBar;
    }

    @Override
    public int getCount() {
        return image.length;
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
        ViewHolder vh=null;
        if(convertView == null){
            vh = new ViewHolder();
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.list_item_scenery, null);
            vh.to_scenery = (TextView) convertView.findViewById(R.id.to_scenery);
            vh.tv_keywords = (TextView) convertView.findViewById(R.id.tv_keywords);
            vh.tv_detail = (TextView) convertView
                    .findViewById(R.id.tv_detail);
            vh.iv_scenery = (ImageView) convertView.findViewById(R.id.iv_scenery);
            vh.ratingBar = (RatingBar) convertView.findViewById(R.id.rbar_item);

            convertView.setTag(vh);
        }else{
           vh = (ViewHolder) convertView.getTag();
        }
        vh.iv_scenery.setImageResource(image[position]);
        vh.to_scenery.setText(name[position]);
        vh.tv_keywords.setText(levelDesc[position]);
        vh.tv_detail.setText(introduce[position]);
        vh.ratingBar.setRating(5*rBar[position]/5);

        return convertView;
    }
    class ViewHolder{
        TextView to_scenery;
        TextView tv_keywords;
        TextView tv_detail;
        ImageView iv_scenery;
        RatingBar ratingBar;
    }
}
