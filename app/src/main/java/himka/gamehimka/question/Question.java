package himka.gamehimka.question;

/**
 * @author hendrawd on 11/29/16
 */

public class Question {

    public static final String TYPE_INPUT = "INPUT";
    public static final String TYPE_MULTIPLE_SELECTION = "MULTIPLE_SELECTION";
    public static final String TYPE_DRAG_AND_DROP = "DRAG_AND_DROP";

    private String type;
    private String question;

    //this should be multiple object type
    private Object answer;

    private int[] selection;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public int[] getSelection() {
        return selection;
    }

    public void setSelection(int[] selection) {
        this.selection = selection;
    }
}
