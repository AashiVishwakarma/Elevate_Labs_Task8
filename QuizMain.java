import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOptionIndex;
    }
}

public class QuizMain {
    public static void main(String[] args) {
        List<Question> questions=new ArrayList<>();
        questions.add(new Question("Which symbol is used to end a statement in Java?",
                new String[]{".", ";", ":", ","},
                1
        ));
        questions.add(new Question("Which of the following is NOT a primitive data type in Java?",
                new String[]{"int", "boolean", "String", "char"},
                2
        ));
        questions.add(new Question(
                "Which data structure works on the Last In, First Out (LIFO) principle?",
                new String[]{"Queue", "Stack", "Array", "Linked List"},
                1
        ));
        questions.add(new Question(
                "Which sorting algorithm is the fastest on average for large datasets?",
                new String[]{"Bubble Sort", "Insertion Sort", "Selection Sort", "Merge Sort"},
                3
        ));
        questions.add(new Question(
                "Which loop is guaranteed to run at least once?",
                new String[]{"for", "while", "do-while", "foreach"},
                2
        ));
        questions.add(new Question(
                "Which of these is an immutable class in Java?",
                new String[]{"String " ,"StringBuilder" , "StringBuffer" , "char[]"},
                0
        ));

        Scanner sc = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt() - 1;

            if (q.isCorrect(userAnswer)) {
                score++;
            }
        }

        System.out.println("Your final score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent! You got all correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job! But you can do better.");
        } else {
            System.out.println("Keep practicing!");
        }

    }

}