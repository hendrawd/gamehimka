package himka.gamehimka.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import himka.gamehimka.R;
import himka.gamehimka.util.PreferenceHelper;

public class SubLevelSelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Memasang layout activity_level_selection.XML ke Activity ini
        setContentView(R.layout.activity_sub_level_selection);

        //Mendapatkan referensi view dari activity_sub_level_selection.XML
        ImageView imageLevel = (ImageView) findViewById(R.id.level);
        ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        ImageView buttonHome = (ImageView) findViewById(R.id.button_home);
        ImageView buttonEasy = (ImageView) findViewById(R.id.button_easy);
        ImageView buttonHard = (ImageView) findViewById(R.id.button_hard);

        //Mendapatkan variable yang dipassing dari LevelActivity
        final String level = getIntent().getStringExtra("level");
        switch (level) {
            case "beginner":
                //Set gambar dengan ic_menu_level_beginner
                imageLevel.setImageResource(R.drawable.ic_menu_level_beginner);
                break;
            case "teenager":
                //Set gambar dengan ic_menu_level_teenager
                imageLevel.setImageResource(R.drawable.ic_menu_level_teenager);
                break;
            case "moderate":
                //Set gambar dengan ic_menu_level_moderate
                imageLevel.setImageResource(R.drawable.ic_menu_level_moderate);
                break;
            case "master":
                //Set gambar dengan ic_menu_level_master
                imageLevel.setImageResource(R.drawable.ic_menu_level_master);
                break;
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLevelSelectionActivity = new Intent(SubLevelSelectionActivity.this, LevelSelectionActivity.class);
                startActivity(goToLevelSelectionActivity);
                finish();
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeActivity = new Intent(SubLevelSelectionActivity.this, HomeActivity.class);
                startActivity(goToHomeActivity);
                finish();
            }
        });

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEasyQuestionActivity = new Intent(SubLevelSelectionActivity.this, EasyQuestionActivity.class);
                goToEasyQuestionActivity.putExtra("level", level);
                startActivity(goToEasyQuestionActivity);
                finish();
            }
        });

        int savedLevel = PreferenceHelper.getLevel(this);

        //menentukan state dari button, kalau belum memenuhi level, maka warna akan menjadi Gray
        //beginner threshold 1
        //teenager 3
        //moderate 5
        //master 7
        switch (level) {
            case "beginner":
                if (savedLevel < 1) {
                    buttonHard.setColorFilter(Color.GRAY);
                } else {
                    setButtonHardClick(buttonHard, level);
                }
                break;
            case "teenager":
                if (savedLevel < 3) {
                    buttonHard.setColorFilter(Color.GRAY);
                } else {
                    setButtonHardClick(buttonHard, level);
                }
                break;
            case "moderate":
                if (savedLevel < 5) {
                    buttonHard.setColorFilter(Color.GRAY);
                } else {
                    setButtonHardClick(buttonHard, level);
                }
                break;
            case "master":
                if (savedLevel < 7) {
                    buttonHard.setColorFilter(Color.GRAY);
                } else {
                    setButtonHardClick(buttonHard, level);
                }
                break;
        }
    }

    private void setButtonHardClick(ImageView buttonHard, final String level) {
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHardQuestionActivity = new Intent(SubLevelSelectionActivity.this, HardQuestionActivity.class);
                goToHardQuestionActivity.putExtra("level", level);
                startActivity(goToHardQuestionActivity);
                finish();
            }
        });
    }

}
