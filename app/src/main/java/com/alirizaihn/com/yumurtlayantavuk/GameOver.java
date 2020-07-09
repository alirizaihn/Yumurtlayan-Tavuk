package com.alirizaihn.com.yumurtlayantavuk;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView tvScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        int scoreSP = pref.getInt("scoreSP",0);
        SharedPreferences.Editor editor = pref.edit();
        if(score > scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
        }
        tvScore = findViewById(R.id.tvScore);
        tvScore.setText(""+score);


    }

    public void restart(View view){
        AppConstants.healt=3;
        AppConstants.score=0;
        AppConstants.level=1;
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){

        finish();
        System.exit(0);
    }
}