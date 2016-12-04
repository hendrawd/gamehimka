package himka.gamehimka.question.beginner;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class BeginnerEasyQuestionListProvider implements QuestionListProvider{

    private ArrayList<Question> questionList = new ArrayList<>();

    public BeginnerEasyQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());

    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Mira pergi ke pasar untuk berbelanja bersama ibunya. Mira membawakan tas belanja(gambar1) yang berbentuk (jawaban1). Mereka berjalan kaki menuju pasar. Sesampainya di pasar, Mira melihat berbagai macam makanan dengan banyak bentuk, ada jeruk(gambar2) yang berbentuk (jawaban2), ada roti(gambar3) yang berbentuk (jawaban3). Selain Makanan di sanapun ada layangan(gambar4), yang seperti namanya, bentuknya pun bernama (jawaban4). Mira pun pulang dengan membawa banyak makanan dan mainan ke rumah. Isi jawaban di kotak bawah dengan pemisah koma");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_bag,
                R.drawable.ic_orange,
                R.drawable.ic_bread,
                R.drawable.ic_kites,
        });
        questionInput.setAnswer("persegi,lingkaran,persegi panjang,layang-layang");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionDragAndDrop = new Question();
        questionDragAndDrop.setQuestion("4. Letakkanlah segitiga di kotak nomor 2, sementara trapesium di kotak setelahnya dan belah ketupat di kotak nomor 1");
        questionDragAndDrop.setQuestionImageResources(new int[]{
                R.drawable.ic_blue_triangle,//first half items will be the items that dragged
                R.drawable.ic_yellow_rhombus,
                R.drawable.ic_brown_trapesium,

                R.drawable.ic_rectangle,//second half items will be the item that listen the drag
                R.drawable.ic_rectangle,
                R.drawable.ic_rectangle,
        });
        questionDragAndDrop.setAnswer(new int[]{
                R.drawable.ic_yellow_rhombus,
                R.drawable.ic_blue_triangle,
                R.drawable.ic_brown_trapesium
        });
        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
        questionDragAndDrop.setUseSound(true);
        return questionDragAndDrop;
    }

    private Question createQuestion3() {
        Question questionDragAndDrop = new Question();
        questionDragAndDrop.setQuestion("3. Drag dan drop benda di bawah sesuai dengan bentuknya");
        questionDragAndDrop.setQuestionImageResources(new int[]{
                R.drawable.ic_paint,//first half items will be the items that dragged
                R.drawable.ic_ball,
                R.drawable.ic_sandwich,

                R.drawable.ic_circle,//second half items will be the item that listen the drag
                R.drawable.ic_triangle,
                R.drawable.ic_rectangle,
        });
        questionDragAndDrop.setAnswer(new int[]{
                R.drawable.ic_ball,
                R.drawable.ic_sandwich,
                R.drawable.ic_paint
        });
        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
        return questionDragAndDrop;
    }

    private Question createQuestion2() {
        Question questionInput = new Question();
        questionInput.setQuestion("2. Siapakan aku");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_red_circle,
        });
        questionInput.setAnswer("Lingkaran");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion1() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("1. Manakah yang bukan merupakan bangun ruang segi empat?");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_purple_rectangular,
                R.drawable.ic_blue_triangle,
                R.drawable.ic_yellow_square,
                R.drawable.ic_yellow_rhombus,
        });
        questionMultipleSelection.setAnswer(1);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        return questionMultipleSelection;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

}
