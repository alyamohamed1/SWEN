public class Question {
    private String prompt;
    private String[] options;
    private char correctAnswer;

    public Question(String prompt, String[] options, char correctAnswer) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswer = Character.toUpperCase(correctAnswer);
    }

    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
