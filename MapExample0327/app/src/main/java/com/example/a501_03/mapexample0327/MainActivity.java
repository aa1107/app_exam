package com.example.a501_03.mapexample0327;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentManager 객체를 로드함
       FragmentManager fragmentManager=getFragmentManager();
        MapFragment mapFragment=(MapFragment)fragmentManager.findFragmentById(R.id.mapView_main);
        mapFragment.getMapAsync(this);
    }

    @Override
    // 지도 정보를 다 읽어온 후에 실행하는 onMapReady()함수
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<LatLng> loc_list=new ArrayList<LatLng>();
        loc_list.add(new LatLng(37.56,126.97));
        loc_list.add(new LatLng(36.6283032,127.4561313));

        for(int i=0;i<loc_list.size();i++){
            MarkerOptions marker=new MarkerOptions();
            marker.position(loc_list.get(i));
            googleMap.addMarker(marker);
        }




        LatLng seoul=new LatLng(37.56,126.97);

        // 지도 위에 위치를 표시하는 마커를 생성하는 MarkerOptions 객체 생성
        MarkerOptions markerOptions = new MarkerOptions();
        // 위치 표시
        markerOptions.position(seoul);
        // 위치의 이름 표시
        markerOptions.title("서울");
        // 추가설명
        markerOptions.snippet("수도입니다");
        // 마커를 지도에 표시
        googleMap.addMarker(markerOptions);

        //특정 좌표가 지도 가운데로 이동하도록 처리
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        // 지도의 배율을 조절 숫자가 클수록 상세히 보임
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));

    }
}
