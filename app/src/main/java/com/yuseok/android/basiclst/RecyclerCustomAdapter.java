package com.yuseok.android.basiclst;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YS on 2017-01-31.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder> {

    ArrayList<User> datas;
    // 리스트 각 행에서 사용되는 레이아웃 xml의 아이디
    int itemLayout;

    public RecyclerCustomAdapter(ArrayList<User> datas, int itemLayout) {
        this.datas = datas;
        this.itemLayout = itemLayout;
    }

    // View를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent, false);
        /*CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;*/

        return new CustomViewHolder(view);
    }

    // listView 에서의 getView() 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = datas.get(position);

        holder.txtid.setText(user.id + "");
        holder.txtname.setText(user.name);
        holder.txtage.setText(user.age + "");

    }

    /*
    // listView에서의 getView를 대체하는 함수
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    */

    // 데이터 총 갯수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    // Recycler 뷰에서 사용하는 뷰홀더
    // 이 뷰홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtname, txtage;

        public CustomViewHolder(View itemView) {
            super(itemView);
            txtid = (TextView) itemView.findViewById(R.id.txtId);
            txtname = (TextView) itemView.findViewById(R.id.txtName);
            txtage = (TextView) itemView.findViewById(R.id.txtAge);
        }
    }
}
