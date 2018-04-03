package com.example.a501_03.baseadapterexample2_0314;

import android.content.Context;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 501-03 on 2018-03-14.
 */

public class MyAdapter extends BaseAdapter {

    /*
    * arrayLst : 자료를 저장하고 있는 arrayList
    * LayoutInflater : 항목을 표현하기 위해 활용하는 객체
    * context : MainActivity의 정보
    * item_Layout_id : 항목 Layout 파일의 아이디
    * */
    int temp;
    ArrayList<MyItemFormat> arrayList;
    Context context;
    LayoutInflater layoutInflater;
    int item_layout_id;

    // Adapter의 생성자 만들기
    public MyAdapter(Context context, ArrayList<MyItemFormat> arrayList,  int item_layout_id) {
        this.arrayList = arrayList;
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.item_layout_id = item_layout_id;
    }

    // arrayList의 저장된 항목의 개수를 알려주는 getCount()함수 수정
    @Override
    public int getCount() {
        return arrayList.size();
    }

    //arrayList에 저장된 항목 객체를 알려주는 getItem()항목 수정정
   @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    //arrayList의 인덱스를 알려주는 getItemId()함수를 수정
    @Override
    public long getItemId(int i) {
        return i;
    }

    //arrayList에 저장한 정보를 항목 레이아웃에 표현하는 getView()함수를 수정
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //항목 레이아웃을 리스트뷰에 추가해주는 부분
        temp=i;
        if(view==null){
            view=layoutInflater.inflate(item_layout_id,viewGroup,false);
        }
        ImageView product_img_left=(ImageView)view.findViewById(R.id.imageView_left_product);
        ImageView product_img_right=(ImageView)view.findViewById(R.id.imageView_right_product);
        TextView product_tvname_left=(TextView)view.findViewById(R.id.textView_left_name);
        TextView product_tvname_right=(TextView)view.findViewById(R.id.textView_right_name);
        TextView product_tvprice_left=(TextView)view.findViewById(R.id.textView_left_price);
        TextView product_tvprice_right=(TextView)view.findViewById(R.id.textView_right_price);
        TextView product_tvscore_left=(TextView)view.findViewById(R.id.textView_left_score);
        TextView product_tvscore_right=(TextView)view.findViewById(R.id.textView_right_score);
        RatingBar product_ratingbar_left=(RatingBar)view.findViewById(R.id.ratingBar_left);
        RatingBar product_ratingbar_right=(RatingBar)view.findViewById(R.id.ratingBar_right);
        ConstraintLayout constraintLayout_left_box=
                (ConstraintLayout)view.findViewById(R.id.constraintLayout_left);
        ConstraintLayout constraintLayout_right_box=
                (ConstraintLayout)view.findViewById(R.id.constraintLayout_right);
        // 컴포넌트 객체에 데이터 추가
        product_img_left.setImageResource(arrayList.get(i).product_img_left);
        product_img_right.setImageResource(arrayList.get(i).product_img_right);
        product_tvname_left.setText(arrayList.get(i).product_name_left);
        product_tvname_right.setText(arrayList.get(i).product_name_right);
        product_tvprice_left.setText(arrayList.get(i).product_price_left);
        product_tvprice_right.setText(arrayList.get(i).product_price_right);
        product_tvscore_left.setText(String.valueOf(arrayList.get(i).product_score_left));
        product_tvscore_right.setText(String.valueOf(arrayList.get(i).product_score_right));
        product_ratingbar_left.setRating((float)arrayList.get(i).product_score_left);
        product_ratingbar_right.setRating((float)arrayList.get(i).product_score_right);

        //컴포넌트에 리스너 등록
        /*constraintLayout_left_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp2=temp;
                Toast.makeText(context,temp2+"왼쪽 박스가 선택됨",Toast.LENGTH_LONG).show();
            }
        });*/

        constraintLayout_left_box.setOnClickListener(new ConstraintLayoutClickListener(i));

        constraintLayout_right_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"오른쪽 박스가 선택됨",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    class ConstraintLayoutClickListener implements View.OnClickListener{
        int aa;
        public ConstraintLayoutClickListener(int aa) {
            this.aa=aa;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,aa+"왼쪽 박스가 선택됨",Toast.LENGTH_LONG).show();
        }
    }
}
