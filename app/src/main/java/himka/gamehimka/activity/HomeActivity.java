package himka.gamehimka.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import himka.gamehimka.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //to unlock all the levels
        //PreferenceHelper.setLevel(this, 99);

        ImageView ivPlay = (ImageView) findViewById(R.id.iv_play);
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLevelSelectionActivity = new Intent(HomeActivity.this, LevelSelectionActivity.class);
                startActivity(goToLevelSelectionActivity);
                finish();
            }
        });
    }
}
