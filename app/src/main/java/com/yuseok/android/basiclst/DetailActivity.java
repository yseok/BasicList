package com.yuseok.android.basiclst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

// 리스트에서 한번 더 클릭했을 경우, 선택한 아이템의 정보를 보여주는 Activity

public class DetailActivity extends AppCompatActivity {

    // activity_detail.xml에 있는 위젯을 적용할 함수(?) 선언
    TextView txtNo, txtDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 위젯의 아이디를 각 타입에 맞게 TextView로 캐스팅해서 위에 전역변수로 선언한 값에 넣는다.
        txtNo = (TextView) findViewById(R.id.txtNo);
        txtDay = (TextView) findViewById(R.id.txtDay);

        // 1. 리스트에서 넘어온 인텐트를 꺼낸다.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 2. 넘어온 인텐트에서 특정 값을 타입에 맞춰서 꺼낸다.
        int no = bundle.getInt("no");

        String day = bundle.getString("day");
        // 3. 꺼낸 값을 위젯에 셋팅한다.
        txtNo.setText(no + "");
        txtDay.setText(day);
    }
}
