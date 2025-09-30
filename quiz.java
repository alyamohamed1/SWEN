import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    // Add sample questions
    private void loadQuestions() {
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
            'B'
        ));

        questions.add(new Question(
            "Who was the first person to walk on the Moon?",
            new String[]{"A) Yuri Gagarin", "B) Buzz Aldrin", "C) Neil Armstrong", "D) Michael Collins"},
            'C'
        ));

        questions.add(new Question(
            "What does NASA stand for?",
            new String[]{
                "A) National Aeronautics and Space Administration",
                "B) National Aerospace and Science Agency",
                "C) North American Space Association",
                "D) New Age Space Authority"},
            'A'
        ));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int qNumber = 1;
        for (Question q : questions) {
            System.out.println("\nQ" + qNumber++ + ". " + q.getPrompt());
        }

        for (Question q : questions) {
            System.out.println("\n" + q.getPrompt());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your answer (A, B, C, D): ");
            char answer = scanner.next().toUpperCase().charAt(0);

            if (answer == q.getCorrectAnswer()) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.getCorrectAnswer());
            }
        }

        showResults();
        scanner.close();
    }

    private void showResults() {
        int total = questions.size();
        double percentage = ((double) score / total) * 100;

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Score: " + score + "/" + total);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage == 100) {
            System.out.println("🌌 Amazing! You’re a true Space Explorer!");
        } else if (percentage >= 70) {
            System.out.println("🚀 Great job! You’re a Space Cadet!");
        } else {
            System.out.println("✨ Keep studying the stars, future astronaut!");
        }
    }
}