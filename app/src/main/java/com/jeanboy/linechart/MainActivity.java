package com.jeanboy.linechart;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_ruler_y;
    SeekBar sb_ruler_space;

    TextView tv_step_space;
    SeekBar sb_step_space;


    LineChartView lineChartView;

    private int[] dataArr = new int[]{230};
    private int[] dataArr2 = new int[]{250};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        lineChartView = (LineChartView) findViewById( R.id.line_chart_view );
        sb_ruler_space = (SeekBar) findViewById( R.id.sb_ruler_space );
        tv_ruler_y = (TextView) findViewById( R.id.tv_ruler_y );
        sb_step_space = (SeekBar) findViewById( R.id.sb_step_space );
        tv_step_space = (TextView) findViewById( R.id.tv_step_space );

        List<LineChartView.Data> datas = new ArrayList<>();
        for (int value : dataArr) {
            LineChartView.Data data = new LineChartView.Data( value );
            datas.add( data );
        }
        lineChartView.setData( datas );
        List<LineChartView.Data> datas2 = new ArrayList<>();
        for (int value : dataArr2) {
            LineChartView.Data data = new LineChartView.Data( value );
            datas2.add( data );
        }
        lineChartView.setData2( datas2 );
        //获取屏幕宽度
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics( dm );
        int widthPixels = dm.widthPixels;
        float density = dm.density;

        lineChartView.setStepSpace( (int) (widthPixels / density / 7) );
        List<String> list = new ArrayList<>();
        list.add( "3月2日" );
        list.add( "3月3日" );
        list.add( "3月4日" );
        list.add( "3月2日" );
        list.add( "3月5日" );
        list.add( "3月7日" );
        list.add( "3月10日" );


        // lineChartView.setTextData( list );
//        sb_ruler_space.setMax(70);
//        sb_ruler_space.setProgress(20);
//        if (lineChartView != null) {
//            lineChartView.setRulerYSpace(20);
//            tv_ruler_y.setText(String.valueOf(20));
//        }
//        sb_ruler_space.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (lineChartView != null) {
//                    lineChartView.setRulerYSpace(progress);
//                    tv_ruler_y.setText(String.valueOf(progress));
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        sb_step_space.setMax(70);
//        sb_step_space.setProgress(15);
//        if (lineChartView != null) {
//            lineChartView.setStepSpace(15);
//            tv_step_space.setText(String.valueOf(15));
//        }
//        sb_step_space.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (lineChartView != null) {
//                    lineChartView.setStepSpace(progress);
//                    tv_step_space.setText(String.valueOf(progress));
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

    }

    private boolean isShowTable = false;

    public void tableToggle(View view) {
        if (lineChartView != null) {
            isShowTable = !isShowTable;
            //显示图表
            lineChartView.setShowTable( true );
        }
    }

    private boolean isBezier = false;

    public void bezierModelToggle(View view) {
        if (lineChartView != null) {
            isBezier = !isBezier;
            lineChartView.setBezierLine( isBezier );
        }
    }

    private boolean isCube = false;

    public void pointModelToggle(View view) {
        if (lineChartView != null) {
            isCube = !isCube;
            lineChartView.setCubePoint( isCube );
        }
    }

    public void doAnimation(View view) {
        if (lineChartView != null) {
            lineChartView.playAnim();
        }
    }
}
