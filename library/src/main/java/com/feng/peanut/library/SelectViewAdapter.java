package com.feng.peanut.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by bingnanfeng02 on 2017/8/19.
 */
public class SelectViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private String[] texts;
    private SelectPositionListener selectPositionListener;
    public SelectViewAdapter(Context context, String[] texts){
        this.context=context;
        this.texts = texts;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select,parent,false);
        final Select select=new Select(view);
        select.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=select.getAdapterPosition();
                selectPositionListener.positionSelected(i);
            }
        });
        return select;
        }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Select){
            ((Select)holder).textView.setText(texts[position]);
        }
    }
    @Override
    public int getItemCount() {
        return texts.length;
    }
    public void setSelectPositionListener(SelectPositionListener selectPositionListener){
        this.selectPositionListener = selectPositionListener;
    }
    class Select extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        TextView textView;
        public Select(View itemView) {
            super(itemView);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.done_rl);
            textView=(TextView)itemView.findViewById(R.id.selecttext);
        }
    }
}


