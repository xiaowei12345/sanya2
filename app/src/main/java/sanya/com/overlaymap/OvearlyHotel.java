package sanya.com.overlaymap;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Text;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import sanya.com.sanya.R;

/**
 * 住宿
 * Created by WEN on 2015/12/2.
 */
public class OvearlyHotel extends Activity {
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private PoiSearch mPoiSearch;
    private static final String  TAG = "OvearlyHotel";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.fragment_nearby);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //设置中心 定位在 109.509307,18.2605
        LatLng point =new LatLng(18.2605,109.509307);
        MapStatusUpdate mapStatusUpdate= MapStatusUpdateFactory.newLatLng(point);
        mBaiduMap.setMapStatus(mapStatusUpdate);//
        //设置缩放级
        MapStatusUpdate zoom =MapStatusUpdateFactory.zoomTo(12);
        mBaiduMap.setMapStatus(zoom);
        // 取消logo
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)){
            child.setVisibility(View.INVISIBLE);
        }

        initFindHotel();
        initLatListener();

    }

    private void initLatListener() {
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
            //    Text text = new Text(getApplication());
                return false;
            }
        });
    }

    private void initFindHotel() {
        LatLng [] poin = new LatLng[15];
        poin[0] = new LatLng(18.292166,109.463749);// ���������ȼپƵ깫Ԣ 109.463749,18.292166
        poin[1] = new LatLng(18.296388,109.208867);// �����߲ʼ��������ͥ�ù� 109.496665,18.274727
        poin[2] = new LatLng(18.251544,109.511898);// ����ʢ��Դ��Ƶ�   109.511898,18.251544
        poin[3] = new LatLng(18.259347,109.510941);// ����ݾƵ�  109.510941,18.259347
        poin[4] = new LatLng(18.24915,109.527628);//  ��������ɽˮ�Ƶ�  109.527628,18.24915
        poin[5] = new LatLng(18.229715,109.535178);//  ����Զ����һ�㾫Ʒ��ջ  109.535178,18.229715
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
//         mPoiSearch = PoiSearch.newInstance();
//        OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener() {
//            @Override
//            public void onGetPoiResult(PoiResult poiResult) {
//                List<LatLng> latlngs = new ArrayList<LatLng>();
//                for (int i = 0;i<latlngs.size();i++){
//                    Log.i(TAG,"latlngs:"+i);
//                }
//            }
//
//            @Override
//            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
//
//            }
//        };
//        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);
//        mPoiSearch.searchInCity((new PoiCitySearchOption()).city("三亚").keyword("宾馆").pageNum(20));
//        mPoiSearch.destroy();
    }

}
