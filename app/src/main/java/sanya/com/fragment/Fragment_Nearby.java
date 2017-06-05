package sanya.com.fragment;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import sanya.com.adapter.GroupAdapter;
import sanya.com.overlaymap.InfoCate;
import sanya.com.sanya.R;
/**
 * Created by Sep
 */
public class Fragment_Nearby  extends Fragment {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private PopupWindow popupWindow;
    private ListView lv_group;
    private View view;
    private TextView tvtitle;
    private List<String> groups;
    private RelativeLayout rll;
    private ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SDKInitializer.initialize(getContext().getApplicationContext());
        View view = View.inflate(getContext(), R.layout.fragment_nearby, null);

        mMapView = (MapView)view.findViewById(R.id.bmapView);
        tvtitle = (TextView) view.findViewById(R.id.tvtitle);
        rll = (RelativeLayout) view.findViewById(R.id.rll);
        iv = (ImageView) view.findViewById(R.id.iv);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //设置中心 定位在 109.509307,18.2605
        LatLng point =new LatLng(18.2605,109.509307);
        MapStatusUpdate mapStatusUpdate= MapStatusUpdateFactory.newLatLng(point);
        mBaiduMap.setMapStatus(mapStatusUpdate);//
        //设置缩放级
        MapStatusUpdate zoom =MapStatusUpdateFactory.zoomTo(12);
        mBaiduMap.setMapStatus(zoom);
        // 隐藏系统的缩放控件
        int count = mMapView.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mMapView.getChildAt(i);
            if (child instanceof ZoomControls) {
                child.setVisibility(View.INVISIBLE);
            }
        }
        // 取消logo
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)){
            child.setVisibility(View.INVISIBLE);
        }
        tvtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow(v);
            }
        });
        return view;
    }
    /**
     * 景点坐标
     */
    private void initFindScenic() {
        final LatLng [] poin = new LatLng[12];
        final Bundle [] poin2 = new Bundle[12];
        poin[0] = new LatLng(18.307148,109.186963);// ��С���쾰�� 109.186963,18.307148
        poin[1] = new LatLng(18.296388,109.208867);// ��ɽ�¾��� 109.208867,18.296388
        poin[2] = new LatLng(18.271363,109.501882);// ���ĺ������ξ���  109.357866,18.2994
        poin[3] = new LatLng(18.292286,109.452508);// ���������ζȼ���  109.452508,18.292286
        poin[4] = new LatLng(18.292286,109.452508);// ���ȴ�����ɭ�ֹ�԰  109.660588,18.257768
        poin[5] = new LatLng(18.244506,109.377778);//  ����   109.377778,18.244506
        poin[6] = new LatLng(18.255192,109.50731);//  ¹��ͷ����  109.509337,18.231647
        poin[7] = new LatLng(18.258334,109.522908);//   �������ζȼ���  109.532944,18.227358
        poin[8] = new LatLng(18.236153,109.654556);//  ���������ζȼ���   109.654556,18.236153
        poin[9] = new LatLng(18.243956,109.515338);//  ��֧�޵�   109.770938,18.319925
        poin[10] = new LatLng(18.243347,109.569948);//   ������Ȫ  109.735893,18.414563
        poin[11] = new LatLng(18.243347,109.569948);//   ��ŵ�����־���  109.678811,18.453838

        Bundle bundle = new Bundle();
        InfoCate i = new InfoCate(18.307148,109.186963,"亚热带天堂森林公园");
        bundle.putSerializable("info",i);

        Bundle bundle2 = new Bundle();
        InfoCate i2 = new InfoCate(18.296388,109.208867,"亚龙湾旅游度假区");
        bundle2.putSerializable("info",i2);

        Bundle bundle3 = new Bundle();
        InfoCate i3 = new InfoCate(18.271363,109.501882,"蜈支洲岛");
        bundle3.putSerializable("info",i3);

        Bundle bundle4 = new Bundle();
        InfoCate i4 = new InfoCate(18.292286,109.452508,"南田温泉");
        bundle4.putSerializable("info",i4);

        Bundle bundle5 = new Bundle();
        InfoCate i5 = new InfoCate(18.292286,109.452508,"大东海旅游度假区");
        bundle5.putSerializable("info",i5);

        Bundle bundle6 = new Bundle();
        InfoCate i6 = new InfoCate(18.244506,109.377778,"三亚湾旅游度假区");
        bundle6.putSerializable("info",i6);

        Bundle bundle7 = new Bundle();
        InfoCate i7 = new InfoCate(18.255192,109.5074531,"大小洞天景区");
        bundle7.putSerializable("info",i7);

        Bundle bundle8 = new Bundle();
        InfoCate i8 = new InfoCate(18.258334,109.522908,"天涯海角旅游景区");
        bundle8.putSerializable("info",i8);

        Bundle bundle9 = new Bundle();
        InfoCate i9 = new InfoCate(18.236153,109.654556,"呀诺达雨林景区");
        bundle9.putSerializable("info",i9);

        Bundle bundle10 = new Bundle();


        InfoCate i10 = new InfoCate(18.243956,109.515338,"南山寺景区");
        bundle10.putSerializable("info",i10);

        Bundle bundle11 = new Bundle();
        InfoCate i11 = new InfoCate(18.243347,109.569948,"鹿回头景区");
        bundle11.putSerializable("info",i11);

        Bundle bundle12 = new Bundle();
        InfoCate i12 = new InfoCate(18.243347,109.569948,"西岛（西玳瑁洲）景区");
        bundle12.putSerializable("info",i12);

        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_red);
        OverlayOptions options1 = new MarkerOptions().position(poin[0]).icon(bitmapDescriptor).extraInfo(bundle);
        OverlayOptions options2 = new MarkerOptions().position(poin[1]).icon(bitmapDescriptor).extraInfo(bundle2);
        OverlayOptions options3 = new MarkerOptions().position(poin[2]).icon(bitmapDescriptor).extraInfo(bundle3);
        OverlayOptions options4 = new MarkerOptions().position(poin[3]).icon(bitmapDescriptor).extraInfo(bundle4);
        OverlayOptions options5 = new MarkerOptions().position(poin[4]).icon(bitmapDescriptor).extraInfo(bundle5);
        OverlayOptions options6 = new MarkerOptions().position(poin[5]).icon(bitmapDescriptor).extraInfo(bundle6);
        OverlayOptions options7 = new MarkerOptions().position(poin[6]).icon(bitmapDescriptor).extraInfo(bundle7);
        OverlayOptions options8 = new MarkerOptions().position(poin[7]).icon(bitmapDescriptor).extraInfo(bundle8);
        OverlayOptions options9 = new MarkerOptions().position(poin[8]).icon(bitmapDescriptor).extraInfo(bundle9);
        OverlayOptions options10 = new MarkerOptions().position(poin[9]).icon(bitmapDescriptor).extraInfo(bundle10);
        OverlayOptions options11 = new MarkerOptions().position(poin[10]).icon(bitmapDescriptor).extraInfo(bundle11);
        OverlayOptions options12 = new MarkerOptions().position(poin[11]).icon(bitmapDescriptor).extraInfo(bundle12);

        mBaiduMap.addOverlay(options1);
        mBaiduMap.addOverlay(options2);
        mBaiduMap.addOverlay(options3);
        mBaiduMap.addOverlay(options4);
        mBaiduMap.addOverlay(options5);
        mBaiduMap.addOverlay(options6);
        mBaiduMap.addOverlay(options7);
        mBaiduMap.addOverlay(options8);
        mBaiduMap.addOverlay(options9);
        mBaiduMap.addOverlay(options10);
        mBaiduMap.addOverlay(options11);
        mBaiduMap.addOverlay(options12);
        initMarkerCate();
        //        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
        //            @Override
        //            public boolean onMarkerClick(Marker marker) {
        //                final Button button = new Button(getActivity());
        //                InfoWindow infoWindow;
        //                button.setBackgroundResource(R.mipmap.favorites_img_empty);
        //                button.setText("大小洞天");
        //                button.setTextColor(Color.WHITE);
        //                button.setTextSize(25);
        //               // BitmapDescriptor descriptor = BitmapDescriptorFactory.fromView(button);
        //                final  LatLng ll = marker.getPosition();
        //                Point p = mBaiduMap.getProjection().toScreenLocation(ll);
        //                p.y -= 47;
        //                LatLng infoCate = mBaiduMap.getProjection().fromScreenLocation(p);
        //                infoWindow = new InfoWindow(button,infoCate,new InfoWindow.OnInfoWindowClickListener(){
        //
        //                    public void onInfoWindowClick(){
        //
        //                    }
        //                });
        ////
        ////                //在地图上显示InfoWindow对象
        ////              //  mBaiduMap.showInfoWindow(infoWindow);
        ////                return false;
        ////            }
        ////        });
    }

    private void initMarkerCate() {
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // 获得marker中的数据
                InfoCate info = (InfoCate) marker.getExtraInfo().get("info");

                InfoWindow mInfoWindow;
                // 生成一个TextView用户在地图中显示InfoWindow
                TextView location = new TextView(getActivity());
                location.setBackgroundResource(R.mipmap.ic_launcher);
                location.setPadding(30, 20, 30, 50);
                location.setText(info.getName());
                // 将marker所在的经纬度的信息转化成屏幕上的坐标
                final LatLng ll = marker.getPosition();
                Point p = mBaiduMap.getProjection().toScreenLocation(ll);
                p.y -= 47;
                LatLng llInfo = mBaiduMap.getProjection().fromScreenLocation(p);
                // 为弹出的InfoWindow添加点击事件
                //                BitmapDescriptor bb = null;
                //                try {
                //                    bb = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene5.jpg")));
                //                }catch(Exception e){}

                mInfoWindow = new InfoWindow(location, llInfo,10);
                //                 显示InfoWindow
                mBaiduMap.showInfoWindow(mInfoWindow);
                //                 设置详细信息布局为可见
                //                                mMarkerInfoLy.setVisibility(View.VISIBLE);
                //                                // 根据商家信息为详细信息布局设置信息
                //                                popupInfo(mMarkerInfoLy, info);
                return true;
            }

        });
    }

    /**
     * 美食坐标
     */
    private void initFindCate() {
        LatLng [] poin = new LatLng[10];
        List<LatLng> latLngs = new ArrayList<LatLng>();
        latLngs.add( poin[0] = new LatLng(18.298313,109.401938));
        poin[1] = new LatLng(18.24478,109.516007);
        poin[2] = new LatLng(18.271363,109.501882);
        poin[3] = new LatLng(18.256755,109.506775);//ʰζ�� 109.506775,18.256755
        poin[4] = new LatLng(18.248042,109.510615);//������Ѽһ����  109.510615,18.248042
        poin[5] = new LatLng(18.255192,109.50731);//һƷ��  109.50731,18.255192
        poin[6] = new LatLng(18.258334,109.522908);//���ǲ��� 109.522908,18.258334
        poin[7] = new LatLng(18.246489,109.513455);//���Ǵ��ŵ� 109.513455,18.246489
        poin[8] = new LatLng(18.243956,109.515338);//  ��һ�г� 109.515338,18.243956
        poin[9] = new LatLng(18.243347,109.569948);// ��ɴ��ͷ���� 109.569948,18.243347
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_orange);
        OverlayOptions options1 = new MarkerOptions().position(poin[0]).icon(bitmapDescriptor);
        OverlayOptions options2 = new MarkerOptions().position(poin[1]).icon(bitmapDescriptor);
        OverlayOptions options3 = new MarkerOptions().position(poin[2]).icon(bitmapDescriptor);
        OverlayOptions options4 = new MarkerOptions().position(poin[3]).icon(bitmapDescriptor);
        OverlayOptions options5 = new MarkerOptions().position(poin[4]).icon(bitmapDescriptor);
        OverlayOptions options6 = new MarkerOptions().position(poin[5]).icon(bitmapDescriptor);
        OverlayOptions options7 = new MarkerOptions().position(poin[6]).icon(bitmapDescriptor);
        OverlayOptions options8 = new MarkerOptions().position(poin[7]).icon(bitmapDescriptor);
        OverlayOptions options9 = new MarkerOptions().position(poin[8]).icon(bitmapDescriptor);
        OverlayOptions options10 = new MarkerOptions().position(poin[9]).icon(bitmapDescriptor);
        mBaiduMap.addOverlay(options1);
        mBaiduMap.addOverlay(options2);
        mBaiduMap.addOverlay(options3);
        mBaiduMap.addOverlay(options4);
        mBaiduMap.addOverlay(options5);
        mBaiduMap.addOverlay(options6);
        mBaiduMap.addOverlay(options7);
        mBaiduMap.addOverlay(options8);
        mBaiduMap.addOverlay(options9);
        mBaiduMap.addOverlay(options10);
        //        BaiduMap.OnMyLocationClickListener listener = new BaiduMap.OnMyLocationClickListener() {
        //            /**
        //             * ��ͼ��λͼ�����¼���������
        //             */
        //            public boolean onMyLocationClick(){
        //
        //                return false;
        //            }
        //        };


    }

    /**
     * 住宿标点
     */
    private void initFindHotel(){
        LatLng [] poin = new LatLng[15];
        poin[0] = new LatLng(18.292166,109.463749);
        poin[1] = new LatLng(18.296388,109.208867);
        poin[2] = new LatLng(18.251544,109.511898);
        poin[3] = new LatLng(18.259347,109.510941);
        poin[4] = new LatLng(18.24915,109.527628);
        poin[5] = new LatLng(18.229715,109.535178);
        poin[6] = new LatLng(18.228384,109.528468);//  �������������������   109.528468,18.228384
        poin[7] = new LatLng(18.237167,109.507258);//  ������;¿�ѹ�����������   109.507258,18.237167
        poin[8] = new LatLng(18.215876,109.494369);// ������������߶���Ƶ�  109.494369,18.215876
        poin[9] = new LatLng(18.243956,109.515338);//   �������˼�����-�񳲶ȼٴ�  109.631641,18.255493
        poin[10] = new LatLng(18.23363,109.639588);//   ����ϲ���ǶȼپƵ�  109.639588,18.23363
        poin[11] = new LatLng(18.238062,109.65641);//   ����鵶ȼپƵ�  109.65641,18.238062
        poin[12] = new LatLng(18.243347,109.569948);//   ά�����ʶȼپƵ�   109.643618,18.236723
        poin[13] = new LatLng(18.242531,109.661076);//   ���ǿ��������ƶȼپƵ�  109.661076,18.242531
        poin[14] = new LatLng(18.33922,109.741852);// ������Ǻ�����ϣ�������ֶȼپƵ�  109.741852,18.33922
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_green);
        OverlayOptions options1 = new MarkerOptions().position(poin[0]).icon(bitmapDescriptor);
        OverlayOptions options2 = new MarkerOptions().position(poin[1]).icon(bitmapDescriptor);
        OverlayOptions options3 = new MarkerOptions().position(poin[2]).icon(bitmapDescriptor);
        OverlayOptions options4 = new MarkerOptions().position(poin[3]).icon(bitmapDescriptor);
        OverlayOptions options5 = new MarkerOptions().position(poin[4]).icon(bitmapDescriptor);
        OverlayOptions options6 = new MarkerOptions().position(poin[5]).icon(bitmapDescriptor);
        OverlayOptions options7 = new MarkerOptions().position(poin[6]).icon(bitmapDescriptor);
        OverlayOptions options8 = new MarkerOptions().position(poin[7]).icon(bitmapDescriptor);
        OverlayOptions options9 = new MarkerOptions().position(poin[8]).icon(bitmapDescriptor);
        OverlayOptions options10 = new MarkerOptions().position(poin[9]).icon(bitmapDescriptor);
        OverlayOptions options11 = new MarkerOptions().position(poin[10]).icon(bitmapDescriptor);
        OverlayOptions options12 = new MarkerOptions().position(poin[11]).icon(bitmapDescriptor);
        OverlayOptions options13 = new MarkerOptions().position(poin[12]).icon(bitmapDescriptor);
        OverlayOptions options14 = new MarkerOptions().position(poin[13]).icon(bitmapDescriptor);
        OverlayOptions options15 = new MarkerOptions().position(poin[14]).icon(bitmapDescriptor);
        mBaiduMap.addOverlay(options1);
        mBaiduMap.addOverlay(options2);
        mBaiduMap.addOverlay(options3);
        mBaiduMap.addOverlay(options4);
        mBaiduMap.addOverlay(options5);
        mBaiduMap.addOverlay(options6);
        mBaiduMap.addOverlay(options7);
        mBaiduMap.addOverlay(options8);
        mBaiduMap.addOverlay(options9);
        mBaiduMap.addOverlay(options10);
        mBaiduMap.addOverlay(options11);
        mBaiduMap.addOverlay(options12);
        mBaiduMap.addOverlay(options13);
        mBaiduMap.addOverlay(options14);
        mBaiduMap.addOverlay(options15);
    }
    /**
     * 购物标点
     */
    private void initFindShopping(){
        LatLng [] poin = new LatLng[10];
        poin[0] = new LatLng(18.262894,109.509837);
        poin[1] = new LatLng(18.255055,109.508794);
        poin[2] = new LatLng(18.23478,109.526646);
        poin[3] = new LatLng(18.243956,109.515338);
        poin[4] = new LatLng(18.246772,109.513812);
        poin[5] = new LatLng(18.240248,109.512077);
        poin[6] = new LatLng(18.242257,109.513767);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_blue);
        OverlayOptions options1 = new MarkerOptions().position(poin[0]).icon(bitmapDescriptor);
        OverlayOptions options2 = new MarkerOptions().position(poin[1]).icon(bitmapDescriptor);
        OverlayOptions options3 = new MarkerOptions().position(poin[2]).icon(bitmapDescriptor);
        OverlayOptions options4 = new MarkerOptions().position(poin[3]).icon(bitmapDescriptor);
        OverlayOptions options5 = new MarkerOptions().position(poin[4]).icon(bitmapDescriptor);
        OverlayOptions options6 = new MarkerOptions().position(poin[5]).icon(bitmapDescriptor);
        OverlayOptions options7 = new MarkerOptions().position(poin[6]).icon(bitmapDescriptor);
        mBaiduMap.addOverlay(options1);
        mBaiduMap.addOverlay(options2);
        mBaiduMap.addOverlay(options3);
        mBaiduMap.addOverlay(options4);
        mBaiduMap.addOverlay(options5);
        mBaiduMap.addOverlay(options6);
        mBaiduMap.addOverlay(options7);
    }

    private void showWindow(View parent) {
        iv.setImageResource(R.mipmap.favorites_img_drop_down_selected);
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null);
            lv_group = (ListView) view.findViewById(R.id.lvGroup);
            // ��������
            groups = new ArrayList<String>();
            groups.add("全部");
            groups.add("景点");
            groups.add("住宿");
            groups.add("美食");
            groups.add("购物");

            GroupAdapter groupAdapter = new GroupAdapter(getActivity(), groups);
            lv_group.setAdapter(groupAdapter);
            // 显示弹窗，设置弹窗大小
            popupWindow = new PopupWindow(view, 400, 370);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    iv.setImageResource(R.mipmap.favorites_img_drop_down_normal);

                }
            });
        }
        //
        popupWindow.setFocusable(true);
        // 点击外部可隐藏弹窗
        popupWindow.setOutsideTouchable(true);
        //
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                - popupWindow.getWidth() / 2;
        Log.i("coder", "windowManager.getDefaultDisplay().getWidth()/2:"
                + windowManager.getDefaultDisplay().getWidth() / 2);
        Log.i("coder", "popupWindow.getWidth()/2:" + popupWindow.getWidth() / 2);
        popupWindow.showAsDropDown(rll, xPos, 0);
        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (groups.get(position)) {
                    case "全部":
                        initFindScenic();
                        initFindHotel();
                        initFindCate();
                        initFindShopping();
                        break;
                    case "景点":
                        tvtitle.setText("景点");
                        mBaiduMap.clear();
                        initFindScenic();
                        break;
                    case "住宿":
                        tvtitle.setText("住宿");
                        mBaiduMap.clear();
                        initFindHotel();
                        break;
                    case "美食":
                        tvtitle.setText("美食");
                        mBaiduMap.clear();
                        initFindCate();
                        break;
                    case "购物":
                        tvtitle.setText("购物");
                        mBaiduMap.clear();
                        initFindShopping();
                        break;
                    default:
                        break;
                }
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }
}
