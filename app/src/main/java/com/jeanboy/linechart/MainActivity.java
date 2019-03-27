package com.jeanboy.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private int[] dataArr = new int[]{230, 270, 280, 290, 280, 260, 220};
    private int[] dataArr2 = new int[]{250, 260, 270, 280, 270, 240, 210};

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
        //显示图表
        lineChartView.setShowTable( true );
        //显示曲线
        lineChartView.setBezierLine( true );
        //圆描点
        lineChartView.setCubePoint( false );
        lineChartView.setRulerYSpace( 21 );
        lineChartView.setStepSpace( 44 );

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
