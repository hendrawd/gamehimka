package himka.gamehimka.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import himka.gamehimka.util.Logger;
import himka.gamehimka.view.CustomToast;

/**
 * @author hendrawd on 12/3/16
 * Ketika di test masih belum berhasil, jadinya untuk sementara tidak dipakai di model soal Moderate no. 2
 */

public class SpeechToTextExampleActivity extends Activity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this.getApplicationContext());
        speechRecognizer.setRecognitionListener(new MyRecognitionListener());

        Button button = new Button(this);
        button.setText("Click to listen");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SpeechRecognizer.isRecognitionAvailable(SpeechToTextExampleActivity.this)) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    //intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "himka.gamehimka");
                    speechRecognizer.startListening(intent);
                } else {
                    CustomToast.show(SpeechToTextExampleActivity.this, "Sorry, voice recognition is not available on your device!");
                }
            }
        });

        linearLayout.addView(button);

        setContentView(linearLayout);
    }

    class MyRecognitionListener implements RecognitionListener {
        @Override
        public void onReadyForSpeech(Bundle bundle) {
            Logger.d("SpeechRecognizer", "ready");
        }

        @Override
        public void onBeginningOfSpeech() {
            Logger.d("SpeechRecognizer", "beginning of speech");
        }

        @Override
        public void onRmsChanged(float v) {
        }

        @Override
        public void onBufferReceived(byte[] bytes) {
        }

        @Override
        public void onEndOfSpeech() {
            Logger.d("SpeechRecognizer", "end of speech");
        }

        @Override
        public void onError(int i) {
            Logger.e("SpeechRecognizer", "error occured, code = " + i);
        }

        @Override
        public void onResults(Bundle bundle) {
            String str = "";
            ArrayList data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            for (int i = 0; i < data.size(); i++) {
                str += data.get(i);
            }
            TextView textView = new TextView(SpeechToTextExampleActivity.this);
            textView.setText(str);
            linearLayout.addView(textView);
        }

        @Override
        public void onPartialResults(Bundle bundle) {

        }

        @Override
        public void onEvent(int i, Bundle bundle) {

        }
    }
}
