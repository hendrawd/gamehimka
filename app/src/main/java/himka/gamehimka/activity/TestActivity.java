package himka.gamehimka.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import himka.gamehimka.R;

/**
 * @author hendrawd on 12/2/16
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        createDragTrigger();

        handleDrag();
    }

    private void createDragTrigger() {
        final ImageView imageView1 = (ImageView) findViewById(R.id.left1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.left2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.left3);

        imageView1.setImageResource(R.drawable.ic_paint);
        imageView2.setImageResource(R.drawable.ic_ball);
        imageView3.setImageResource(R.drawable.ic_sandwich);

        imageView1.setTag(R.drawable.ic_paint);
        imageView2.setTag(R.drawable.ic_ball);
        imageView3.setTag(R.drawable.ic_sandwich);

        View.OnLongClickListener dragTrigger = new View.OnLongClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item = new ClipData.Item(view.getTag() + "");
                ClipData dragData = new ClipData(view.getTag() + "", new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                View.DragShadowBuilder viewShadow = new View.DragShadowBuilder(view);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(dragData, viewShadow, null, 0);
                } else {
                    view.startDrag(dragData, viewShadow, null, 0);
                }
                return false;
            }
        };

        imageView1.setOnLongClickListener(dragTrigger);
        imageView2.setOnLongClickListener(dragTrigger);
        imageView3.setOnLongClickListener(dragTrigger);
    }

    private void handleDrag() {
        final ImageView ivRight1 = (ImageView) findViewById(R.id.right1);
        final ImageView ivRight2 = (ImageView) findViewById(R.id.right2);
        final ImageView ivRight3 = (ImageView) findViewById(R.id.right3);

        ivRight1.setBackgroundResource(R.drawable.ic_rectangle);
        ivRight2.setBackgroundResource(R.drawable.ic_circle);
        ivRight3.setBackgroundResource(R.drawable.ic_triangle);

        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                ImageView currentImageView = (ImageView) view;

                final int dragEventAction = dragEvent.getAction();

                switch (dragEventAction) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                            currentImageView.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                            return true;
                        }
                        return false;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        currentImageView.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                        return true;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        return true;

                    case DragEvent.ACTION_DRAG_EXITED:
                        currentImageView.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                        return true;

                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        String dragData = item.getText().toString();
                        Toast.makeText(TestActivity.this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();
                        currentImageView.clearColorFilter();
                        currentImageView.setImageResource(Integer.valueOf(dragData));
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        currentImageView.getBackground().clearColorFilter();

                        if (dragEvent.getResult()) {
                            Toast.makeText(TestActivity.this, "The drop was handled.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(TestActivity.this, "The drop didn't work.", Toast.LENGTH_LONG).show();
                        }
                        return true;

                    default:
                        Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                        break;
                }
                return false;
            }
        };

        ivRight1.setOnDragListener(dragListener);
        ivRight2.setOnDragListener(dragListener);
        ivRight3.setOnDragListener(dragListener);
    }
}
