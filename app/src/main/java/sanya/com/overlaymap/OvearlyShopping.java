package sanya.com.overlaymap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiSearch;

import sanya.com.sanya.R;

/**
 * 购物
 * Created by WEN on 2015/12/2.
 */
public class OvearlyShopping extends Activity {
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
        LatLng [] poin = new LatLng[10];
        poin[0] = new LatLng(18.262894,109.509837);//  ����㳡  109.509837,18.262894
        poin[1] = new LatLng(18.255055,109.508794);//   ���·���н�  109.508794,18.255055
        poin[2] = new LatLng(18.23478,109.526646);//  ��˰�깺��  109.526646,18.23478
        poin[3] = new LatLng(18.243956,109.515338);//  ��һ�г� 109.515338,18.243956
        poin[4] = new LatLng(18.246772,109.513812);//  �����  109.513812,18.246772
        poin[5] = new LatLng(18.240248,109.512077);//   ���ˮ���г�  109.512077,18.240248
        poin[6] = new LatLng(18.242257,109.513767);//   �������� 109.513767,18.242257
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
//        mPoiSearch.searchInCity((new PoiCitySearchOption()).city("三亚").keyword("购物").pageNum(20));
//        mPoiSearch.destroy();
    }

}
