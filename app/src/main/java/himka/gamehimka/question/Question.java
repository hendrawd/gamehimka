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

    private int[] questionImageResources;

    private int[] answerImageResources;

    private boolean useSound;

    private int time;

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

    public int[] getQuestionImageResources() {
        return questionImageResources;
    }

    public void setQuestionImageResources(int[] questionImageResources) {
        this.questionImageResources = questionImageResources;
    }

    public int[] getAnswerImageResources() {
        return answerImageResources;
    }

    public void setAnswerImageResources(int[] answerImageResources) {
        this.answerImageResources = answerImageResources;
    }

    public boolean isUseSound() {
        return useSound;
    }

    public void setUseSound(boolean useSound) {
        this.useSound = useSound;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
