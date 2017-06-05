package sanya.com.view.pinnedlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanya.com.sanya.R;

import java.util.ArrayList;
import java.util.List;

public class ContactSeriesAdapter extends SectionedBaseAdapter {
    private List<String> list = new ArrayList<String>();
    private List<String> list2 = new ArrayList<String>();

//    private Context context;
//    private ArrayList<SortList> contactList;
//    private ListView listView;
//    private LayoutInflater layoutInflater;


    public ContactSeriesAdapter(List<String> list, List<String> list2) {
        this.list = list;
        this.list2 = list2;
    }

//    public ContactSeriesAdapter(Context context, ListView listView, ArrayList<SortList> contactList) {
//        this.context = context;
//        this.listView = listView;
//        this.contactList = contactList;
//
//        layoutInflater = LayoutInflater.from(context);
//    }

//    public void refreshData(ArrayList<SortList> contactList) {
//        this.contactList = contactList;
//        notifyDataSetChanged();
//    }

    @Override
    public Object getItem(int section, int position) {
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        return 0;
    }

    @Override
    public int getSectionCount() {
        return list.size();
    }

    @Override
    public int getCountForSection(int section) {
        return 1;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_road, null);
            viewHolder = new ViewHolder(convertView);
            //viewHolder.tv_contacts_list_sort = (TextView) convertView.findViewById(R.id.tv_contacts_list_sort);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //  viewHolder.tv_contacts_list_sort.setText(contactList.get(section).subLists.get(position).name);
        if (section == 0) {
            viewHolder.tvContent1.setText("上午在沙滩大海亲密接触。");
            viewHolder.tvContent2.setText("乘坐25路公交去热带天堂森林公园，重温非诚勿扰2的浪漫，看鸟巢过索道。");
            viewHolder.toScenery.setText("亚龙湾旅游度假区");
            viewHolder.photo1.setImageResource(R.mipmap.scenery2);
            viewHolder.toScenery2.setText("热带天堂森林公园");
            viewHolder.photo2.setImageResource(R.mipmap.scenery3);

        }
        if (section == 1) {
            viewHolder.tvContent1.setText("上午去蜈支洲岛体验各种海上运动，感受中国第一潜水宝地的魅力。");
            viewHolder.tvContent2.setText("下午去附近的南天温泉泡温泉，放松一下");
            viewHolder.toScenery.setText("蜈支洲岛");
            viewHolder.photo1.setImageResource(R.mipmap.scenery1);
            viewHolder.toScenery2.setText("南田温泉");
            viewHolder.photo2.setImageResource(R.mipmap.scenery10);
        }
        if (section == 3) {
            viewHolder.tvContent1.setText("上午拜访180米高的海上观音与南山寺里供奉的众多佛像。欣赏仿唐代风格的建筑。");
            viewHolder.tvContent2.setText("下午乘坐25路公交去天涯海角，欣赏海边巨石与海滩构成的美景。");
            viewHolder.toScenery.setText("南山寺景区");
            viewHolder.photo1.setImageResource(R.mipmap.scenery9);
            viewHolder.toScenery2.setText("天涯海角旅游景区");
            viewHolder.photo2.setImageResource(R.mipmap.scenery4);

        }
        if (section == 4) {
            viewHolder.tvContent1.setText("步行到第一市场买海鲜，乘坐7路车去春园海鲜广场加工，美美地吃一顿海鲜大餐。");
            viewHolder.tvContent2.setText("傍晚回椰梦长廊享受三亚湾美丽的晚霞，漫步椰林。最后乘坐6路公交去商品街饱餐一顿。");
            viewHolder.toScenery.setText("第一市场");
            viewHolder.photo1.setImageResource(R.mipmap.scenery12);
            viewHolder.toScenery2.setText("椰梦长廊");
            viewHolder.photo2.setImageResource(R.mipmap.scenery6);
        }

        return convertView;
    }


    static class ViewHolder {
        //        @Bind(R.id.time)
//        TextView time;
//        @Bind(R.id.layout_1)
//        RelativeLayout layout1;
        @BindView(R.id.tv_content1)
        TextView tvContent1;
        @BindView(R.id.tv_content2)
        TextView tvContent2;
        @BindView(R.id.to_scenery)
        TextView toScenery;
        @BindView(R.id.photo1)
        ImageView photo1;
        @BindView(R.id.photo2)
        ImageView photo2;
        @BindView(R.id.to_scenery2)
        TextView toScenery2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        Hold hold = null;
        if (convertView == null) {
            hold = new Hold();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_road_header, null);
            hold.time = (TextView) convertView.findViewById(R.id.time);
            hold.address = (TextView) convertView.findViewById(R.id.address);
            convertView.setTag(hold);
        } else {
            hold = (Hold) convertView.getTag();
        }
        hold.time.setText(list.get(section));
        hold.address.setText(list2.get(section));
        return convertView;
    }

    class Hold {
        TextView time;
        TextView address;
    }
}
