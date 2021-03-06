package com.littlebluelabs.rewardchart;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


// IMPORTANT NOTE: I KNOW THIS FILE IS ABSOLUTE GARBAGE.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("RewardChart", MODE_PRIVATE);
        String points = Integer.toString(prefs.getInt("points1", 0));
        if (points != null) {
            ((TextView)findViewById(R.id.pointsView1)).setText(points);
        }

        String points2 = Integer.toString(prefs.getInt("points2", 0));
        if (points2 != null) {
            ((TextView)findViewById(R.id.pointsView2)).setText(points2);
        }

        String points3 = Integer.toString(prefs.getInt("points3", 0));
        if (points3 != null) {
            ((TextView)findViewById(R.id.pointsView3)).setText(points3);
        }

        String points4 = Integer.toString(prefs.getInt("points4", 0));
        if (points4 != null) {
            ((TextView)findViewById(R.id.pointsView4)).setText(points4);
        }
    }

    public void addPoint(View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.good);
        mp.start();
        String whichPoints;
        TextView pointsView;
        if (view.getId() == R.id.button1) {
            pointsView = ((TextView)findViewById(R.id.pointsView1));
            whichPoints = "points1";
        } else if (view.getId() == R.id.button3) {
            pointsView = ((TextView)findViewById(R.id.pointsView2));
            whichPoints = "points2";
        }  else if (view.getId() == R.id.button5) {
            pointsView = ((TextView)findViewById(R.id.pointsView3));
            whichPoints = "points3";
        } else {
            pointsView = ((TextView)findViewById(R.id.pointsView4));
            whichPoints = "points4";
        }

        int points = Integer.parseInt((String)pointsView.getText());
        points++;
        pointsView.setText(Integer.toString(points));
        SharedPreferences.Editor editor = getSharedPreferences("RewardChart", MODE_PRIVATE).edit();
        editor.putInt(whichPoints, points);
        editor.apply();
    }

    public void removePoint(View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.bad);
        mp.start();
        String whichPoints;
        TextView pointsView;
        if (view.getId() == R.id.button2) {
            pointsView = ((TextView)findViewById(R.id.pointsView1));
            whichPoints = "points1";
        } else if (view.getId() == R.id.button4) {
            pointsView = ((TextView)findViewById(R.id.pointsView2));
            whichPoints = "points2";
        }  else if (view.getId() == R.id.button6) {
            pointsView = ((TextView)findViewById(R.id.pointsView3));
            whichPoints = "points3";
        } else {
            pointsView = ((TextView)findViewById(R.id.pointsView4));
            whichPoints = "points4";
        }

        int points = Integer.parseInt((String)pointsView.getText());
        points--;
        pointsView.setText(Integer.toString(points));
        SharedPreferences.Editor editor = getSharedPreferences("RewardChart", MODE_PRIVATE).edit();
        editor.putInt(whichPoints, points);
        editor.apply();
    }
}
