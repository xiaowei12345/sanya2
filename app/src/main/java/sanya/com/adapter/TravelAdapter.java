package sanya.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class TravelAdapter extends BaseAdapter {
    private int[] image;

    public TravelAdapter(int[] image) {
        this.image = image;
    }

    @Override
    public int getCount() {
        return 5;
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
    public View getView(int position, View convertView, final ViewGroup viewGroup) {
       ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_travel, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else
            vh = (ViewHolder) convertView.getTag();
        vh.ivTravelPhoto.setImageResource(image[position]);

        vh.tvTravelTitle.setText("浮生半日闲");
        vh.tvTravelTime.setText("2017.5.10");
        vh.tvTravelAuthor.setText("作者：艾雪儿");
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'list_item_travel.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @BindView(R.id.iv_travel_photo)
        ImageView ivTravelPhoto;
        @BindView(R.id.tv_travel_title)
        TextView tvTravelTitle;
        @BindView(R.id.tv_travel_time)
        TextView tvTravelTime;
        @BindView(R.id.tv_travel_author)
        TextView tvTravelAuthor;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
