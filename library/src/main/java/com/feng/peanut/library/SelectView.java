package com.feng.peanut.library;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


/**
 * Created by bingnanfeng02 on 2017/8/19.
 */
public class SelectView extends PopupWindow {
    private Context context;
    private SelectPositionListener selectPositionListener;
    private String[] texts;
    private WindowManager.LayoutParams lp;
    private SelectViewAdapter selectAdapter;
    private RelativeLayout cancel;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public  void setListener(SelectPositionListener selectPositionListener){
        this.selectPositionListener = selectPositionListener;
    }
    public SelectView(Context context, String[] texts){
        this.context=context;
        this.texts=texts;
        lp = ((Activity)context).getWindow().getAttributes();
    }
    public void setView(){
        final View view1= LayoutInflater.from(context).inflate(R.layout.view_select, null);
        cancel=(RelativeLayout)view1.findViewById(R.id.cancel) ;
        recyclerView=(RecyclerView)view1.findViewById(R.id.rv);
        linearLayoutManager=new LinearLayoutManager(context);
        selectAdapter=new SelectViewAdapter(context,texts);
        selectAdapter.setSelectPositionListener(selectPositionListener);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(selectAdapter);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = view1.findViewById(R.id.rv).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        this.setContentView(view1);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        this.setAnimationStyle(R.style.mypopwindow_anim_style);
        setTransparency(false);
    }
    private void setTransparency(boolean isDismiss){
        if (!isDismiss){
            lp.alpha = 0.5f;
        }else {
            lp.alpha = 1;
        }
        ((Activity)context).getWindow().setAttributes(lp);
    }
    public void dismiss() {
        super.dismiss();
        setTransparency(true);
        selectPositionListener.positionSelected(-1);
    }
}
