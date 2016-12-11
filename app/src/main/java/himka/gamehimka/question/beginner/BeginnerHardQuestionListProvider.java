package himka.gamehimka.question.beginner;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class BeginnerHardQuestionListProvider implements QuestionListProvider {

    private ArrayList<Question> questionList = new ArrayList<>();

    public BeginnerHardQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());

    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Sebuah drum berbentuk tabung dengan jari - jari 35 cm dan tingginya 150 cm. Jika drum tersebut akan diisi air hingga penuh, banyak air yang dibutuhkan adalah ... liter.");
        questionInput.setAnswer("577.5");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionInput = new Question();
        questionInput.setQuestion("4. V = p x l x t(panjang x lebar x tinggi) adalah rumus untuk mencari volume bangun ruang");
        questionInput.setAnswer("balok");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion3() {
        Question questionDragAndDrop = new Question();
        questionDragAndDrop.setQuestion("3. Drag dan drop bangun ruang berikut dengan jaring - jaringnya");
        questionDragAndDrop.setQuestionImageResources(new int[]{
                R.drawable.ic_brown_cube,//first half items will be the items that dragged
                R.drawable.ic_blue_tube,
                R.drawable.ic_blue_cuboid,

                R.drawable.ic_skeleton_cube,//second half items will be the item that listen the drag
                R.drawable.ic_skeleton_cuboid,
                R.drawable.ic_skeleton_tube,
        });
        questionDragAndDrop.setAnswer(new int[]{
                R.drawable.ic_brown_cube,
                R.drawable.ic_blue_cuboid,
                R.drawable.ic_blue_tube
        });
        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
        return questionDragAndDrop;
    }

    private Question createQuestion2() {
        Question questionInput = new Question();
        questionInput.setQuestion("2. Apakah nama bangun ruang ini?");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_brown_cube,
        });
        questionInput.setAnswer("kubus");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion1() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("1. Manakah yang merupakan bangun ruang tabung?");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_blue_tube,
                R.drawable.ic_blue_cuboid,
                R.drawable.ic_brown_cube,
                R.drawable.ic_maroon_circle,
        });
        questionMultipleSelection.setAnswer(0);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        return questionMultipleSelection;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

}
