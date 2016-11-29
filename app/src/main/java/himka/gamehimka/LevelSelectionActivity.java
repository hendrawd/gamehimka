package himka.gamehimka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class LevelSelectionActivity extends AppCompatActivity implements View.OnClickListener {

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

        //Memasang click listener ke kelas ini sendiri yang akan di tangani oleh method onClick(View view)
        buttonBeginner.setOnClickListener(this);
        buttonTeenager.setOnClickListener(this);
        buttonModerate.setOnClickListener(this);
        buttonMaster.setOnClickListener(this);
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
