package himka.gamehimka.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import himka.gamehimka.R;
import himka.gamehimka.util.PreferenceHelper;

public class LevelSelectionActivity extends Activity implements View.OnClickListener {

    /**
     * Method yang dipanggil ketika Activity dibuat
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Memasang layout activity_level_selection.XML ke Activity ini
        setContentView(R.layout.activity_level_selection);

        //Mendapatkan referensi view dari activity_level_selection.XML
        ImageView buttonBeginner = (ImageView) findViewById(R.id.button_beginner);
        ImageView buttonTeenager = (ImageView) findViewById(R.id.button_teenager);
        ImageView buttonModerate = (ImageView) findViewById(R.id.button_moderate);
        ImageView buttonMaster = (ImageView) findViewById(R.id.button_master);

        int level = PreferenceHelper.getLevel(this);

        //Memasang click listener ke kelas ini sendiri yang akan di tangani oleh method onClick(View view)
        buttonBeginner.setOnClickListener(this);
        if (level < 2) {
            buttonTeenager.setColorFilter(Color.GRAY);
        } else {
            buttonTeenager.setOnClickListener(this);
        }
        if (level < 4) {
            buttonModerate.setColorFilter(Color.GRAY);
        } else {
            buttonModerate.setOnClickListener(this);
        }
        if (level < 6) {
            buttonMaster.setColorFilter(Color.GRAY);
        } else {
            buttonMaster.setOnClickListener(this);
        }
    }

    /**
     * Menangkap event click dari view
     *
     * @param view view dimana event click terjadi
     */
    @Override
    public void onClick(View view) {
        Intent goToSubLevelActivity = new Intent(this, SubLevelSelectionActivity.class);
        switch (view.getId()) {
            case R.id.button_beginner:
                //Memasang variable yang akan dipassing ke SubLevelActivity
                goToSubLevelActivity.putExtra("level", "beginner");
                break;
            case R.id.button_teenager:
                //Memasang variable yang akan dipassing ke SubLevelActivity
                goToSubLevelActivity.putExtra("level", "teenager");
                break;
            case R.id.button_moderate:
                //Memasang variable yang akan dipassing ke SubLevelActivity
                goToSubLevelActivity.putExtra("level", "moderate");
                break;
            case R.id.button_master:
                //Memasang variable yang akan dipassing ke SubLevelActivity
                goToSubLevelActivity.putExtra("level", "master");
                break;
        }
        startActivity(goToSubLevelActivity);
        finish();
    }
}
