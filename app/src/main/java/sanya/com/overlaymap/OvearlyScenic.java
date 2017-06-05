package sanya.com.overlaymap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiSearch;

import sanya.com.sanya.R;

/**
 * 景点
 * Created by WEN on 2015/12/2.
 */
public class OvearlyScenic extends Activity{
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

    }

    private void initFindHotel() {
        LatLng [] poin = new LatLng[12];
        poin[0] = new LatLng(18.307148,109.186963);// 大小洞天景区 109.186963,18.307148
        poin[1] = new LatLng(18.296388,109.208867);// 南山寺景区 109.208867,18.296388
        poin[2] = new LatLng(18.271363,109.501882);// 天涯海角旅游景区  109.357866,18.2994
        poin[3] = new LatLng(18.292286,109.452508);// 三亚湾旅游度假区  109.452508,18.292286
        poin[4] = new LatLng(18.292286,109.452508);// 亚热带天堂森林公园  109.660588,18.257768
        poin[5] = new LatLng(18.244506,109.377778);//  西岛   109.377778,18.244506
        poin[6] = new LatLng(18.255192,109.50731);//  鹿回头景区  109.509337,18.231647
        poin[7] = new LatLng(18.258334,109.522908);//   大东湾旅游度假区  109.532944,18.227358
        poin[8] = new LatLng(18.236153,109.654556);//  亚龙湾旅游度假区   109.654556,18.236153
        poin[9] = new LatLng(18.243956,109.515338);//  蜈支洲岛   109.770938,18.319925
        poin[10] = new LatLng(18.243347,109.569948);//   南田温泉  109.735893,18.414563
        poin[11] = new LatLng(18.243347,109.569948);//   雅诺达雨林景区  109.678811,18.453838
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.nearby_map_img_marker_red);
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
    }
}
