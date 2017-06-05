package sanya.com.overlaymap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import sanya.com.sanya.R;

/**
 * 美食
 * Created by WEN on 2015/12/2.
 */
public class OvearlyCate extends Activity {
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private PoiSearch mPoiSearch;
    //覆盖物图标
    private BitmapDescriptor mMarker;
    private static final String TAG = "OvearlyHotel";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.fragment_nearby);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //设置中心 定位在 109.509307,18.2605
        LatLng point = new LatLng(18.2605, 109.509307);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(point);
        mBaiduMap.setMapStatus(mapStatusUpdate);//
        //设置缩放级
        MapStatusUpdate zoom = MapStatusUpdateFactory.zoomTo(12);
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
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }

        initFindHotel();

        //覆盖物相关
        initMarker();
        //地图点击
        initMarkerClick();
    }

    private void initMarkerClick() {
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Bundle bundle = marker.getExtraInfo();
                InfoCate infoCate = (InfoCate) bundle.getSerializable("infoCate");
                InfoWindow infoWindow;
                TextView tv = new TextView(getApplicationContext());
                tv.setBackgroundResource(R.mipmap.ic_launcher);
                tv.setPadding(30, 20, 30, 20);
                tv.setTextColor(Color.WHITE);
                tv.setText(infoCate.getName());

                final LatLng latLng = marker.getPosition();
                Point point = mBaiduMap.getProjection().toScreenLocation(latLng);
                point.y -= 47;
                LatLng ll = mBaiduMap.getProjection().fromScreenLocation(point);
//                infoWindow = new
//                infoWindow = new InfoWindow(tv, ll,new InfoWindow.OnInfoWindowClickListener(){});
//
//                 mBaiduMap.showInfoWindow(infoWindow);
                return false;
            }
        });
    }

    private void initMarker() {
        mMarker = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_orange);
    }

    //添加覆盖物
    private void addOverlays(List<InfoCate> infoCates) {
        mBaiduMap.clear();
        LatLng latLng = null;
        Marker marker = null;
        OverlayOptions options;
        for (InfoCate infoCate : infoCates) {
            //经纬度
            latLng = new LatLng(infoCate.getLatitude(), infoCate.getLongitude());
            //
            options = new MarkerOptions().position(latLng);
            marker = (Marker) mBaiduMap.addOverlay(options);
            Bundle bundle = new Bundle();
            bundle.putSerializable("infoCate", infoCate);
            marker.setExtraInfo(bundle);
        }
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.setMapStatus(msu);
    }

    private void initFindHotel() {
        final LatLng[] poin = new LatLng[10];
        //    List<LatLng> latLngs = new ArrayList<LatLng>();
        poin[0] = new LatLng(18.298313, 109.401938);//��ɽ��ի  109.401938,18.298313
        poin[1] = new LatLng(18.24478, 109.516007);//��԰�����г�109.516007,18.24478
        poin[2] = new LatLng(18.271363, 109.501882);//����·�¸�ְ�����ʹ㳡 109.501882,18.271363
        poin[3] = new LatLng(18.256755, 109.506775);//ʰζ�� 109.506775,18.256755
        poin[4] = new LatLng(18.248042, 109.510615);//������Ѽһ����  109.510615,18.248042
        poin[5] = new LatLng(18.255192, 109.50731);//һƷ��  109.50731,18.255192
        poin[6] = new LatLng(18.258334, 109.522908);//���ǲ��� 109.522908,18.258334
        poin[7] = new LatLng(18.246489, 109.513455);//���Ǵ��ŵ� 109.513455,18.246489
        poin[8] = new LatLng(18.243956, 109.515338);//  ��һ�г� 109.515338,18.243956
        poin[9] = new LatLng(18.243347, 109.569948);// ��ɴ��ͷ���� 109.569948,18.243347
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

        InfoWindow infoWindow;
        TextView tv = new TextView(getApplication());
        tv.setBackgroundResource(R.mipmap.site_map);
        tv.setPadding(30, 20, 30, 20);
        tv.setText("aaaa");

//        final LatLng latLng = m

//        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
//            //    double lat = LatLng.
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Button button = new Button(getApplicationContext());
//                button.setBackgroundResource(R.mipmap.ic_launcher);
//                LatLng[] p = new LatLng[10];
//                p[0] = new LatLng(18.298313, 109.401938);
//                p[1] = new LatLng(18.271363, 109.501882);
//                p[2] = new LatLng(18.243956, 109.515338);
//                p[3] = new LatLng(18.255192, 109.50731);
//                p[4] = new LatLng(18.248042, 109.510615);
//                InfoWindow[] info = new InfoWindow[10];
//                switch (p.length) {
//                    case 0:
//                        info[0] = new InfoWindow(button, p[0], -47);
//                        mBaiduMap.showInfoWindow(info[0]);
//                        break;
//                    case 1:
//                        info[1] = new InfoWindow(button, p[1], -47);
//                        mBaiduMap.showInfoWindow(info[1]);
//                        break;
//                    case 2:
//                        info[2] = new InfoWindow(button, p[2], -47);
//                        mBaiduMap.showInfoWindow(info[2]);
//
//                        break;
//                    case 3:
//                        info[3] = new InfoWindow(button, p[3], -47);
//                        mBaiduMap.showInfoWindow(info[3]);
//                        break;
//                    case 4:
//                        info[4] = new InfoWindow(button, p[4], -47);
//                        mBaiduMap.showInfoWindow(info[4]);
//                        break;
//                }
//                return true;
//            }
//        });

    }
}

