package com.feng.peanut.selectview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.feng.peanut.library.SelectPositionListener;
import com.feng.peanut.library.SelectView;

public class MainActivity extends AppCompatActivity implements SelectPositionListener {
    private Button button;
    private SelectView selectView;
    private static final String[] Texts ={"拍照","相册"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectView=new SelectView(MainActivity.this, Texts);
                selectView.setListener(MainActivity.this);
                selectView.setView();
                selectView.showAtLocation(findViewById(R.id.rl), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });

    }

    @Override
    public void positionSelected(int position) {
        if(selectView.isShowing()){
            selectView.dismiss();
        }
        switch (position){
            case 0:
                //takePhoto();
                break;
            case 1:
                //openAlbum();
        }
    }
}
