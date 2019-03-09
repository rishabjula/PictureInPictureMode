package c.tripod.pictureinpicturemode;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 Button pip;
 TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pip = findViewById(R.id.PiPButton);
        txt = findViewById(R.id.hellotxt);

        pip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterPictureInPictureMode();
            }
        });
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        if(isInPictureInPictureMode)
        {
            getSupportActionBar().hide();
            pip.setVisibility(View.INVISIBLE);
            txt.setText("yuhuu! PiP mode is on!");


        }
        else {
            pip.setVisibility(View.VISIBLE);
            txt.setText("Hello World!");
            getSupportActionBar().show();
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        //home button pressed
        enterPictureInPictureMode();
    }
 
}
