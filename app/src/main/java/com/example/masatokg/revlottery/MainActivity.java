package com.example.masatokg.revlottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    // フィールド
    private SeekBar seek_param;
    private SeekBar seek_win;
    private TextView txtParam;
    private TextView txtWin;
    private int num_param;
    private int num_win;
    private Button btnLott;
    private ImageView imgResult;
    private TextView lblResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        seek_param = (SeekBar)findViewById(R.id.seek_param);
        seek_win = (SeekBar)findViewById(R.id.seek_win);
        txtParam = (TextView)findViewById(R.id.txt_Param);
        txtWin = (TextView)findViewById(R.id.txt_win);
        btnLott = (Button) findViewById(R.id.btn_lott);
        imgResult = (ImageView)findViewById(R.id.img_result);
        lblResult = (TextView)findViewById(R.id.lbl_result);


        num_param = seek_param.getProgress();
        num_win = seek_win.getProgress();

        txtParam.setText(num_param + " " +"人中");
        txtWin.setText(num_win + " " +"人が当選");

        // 抽選の母数のシークバー
        seek_param.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                num_param = progress;
                txtParam.setText(String.valueOf(num_param) + " " +"人中");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        // 抽選の当選者数のシークバー
        seek_win.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                num_win = progress;
                txtWin.setText(String.valueOf(num_win) + " " +"人が当選");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        // ボタンのリスナー
        btnLott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rnd = new Random().nextInt(num_param);
                if(rnd<num_win){
                    // 当選
                    imgResult.setImageResource(R.drawable.happy);
                    lblResult.setText("あたり！！");

                }
                else{
                    imgResult.setImageResource(R.drawable.sorry);
                    lblResult.setText("はずれ！！");
                }
            }
        });

    }
}
