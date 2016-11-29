package himka.gamehimka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
