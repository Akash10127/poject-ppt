import java.util.Scanner;


class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    
    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (String option : options) {
            System.out.println(option);
        }
    }

    
    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }
}


class QuizManager {
    private Question[] questions;
    private int score;

    
    public QuizManager() {
        score = 0;

        questions = new Question[5];

        questions[0] = new Question(
                "Q1. What is Java?",
                new String[]{
                        "a) Programming Language",
                        "b) Operating System",
                        "c) Database",
                        "d) Browser"
                },
                "a"
        );

        questions[1] = new Question(
                "Q2. OOP stands for?",
                new String[]{
                        "a) Open Operating Platform",
                        "b) Object Oriented Programming",
                        "c) Output Operation Process",
                        "d) None"
                },
                "b"
        );

        questions[2] = new Question(
                "Q3. Which class is used for user input in Java?",
                new String[]{
                        "a) Scanner",
                        "b) String",
                        "c) System",
                        "d) Math"
                },
                "a"
        );

        questions[3] = new Question(
                "Q4. Which operator is used to compare Strings?",
                new String[]{
                        "a) ==",
                        "b) !=",
                        "c) equals()",
                        "d) =="
                },
                "c"
        );

        questions[4] = new Question(
                "Q5. Which concept hides data?",
                new String[]{
                        "a) Inheritance",
                        "b) Polymorphism",
                        "c) Encapsulation",
                        "d) Abstraction"
                },
                "c"
        );
    }

    
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("     ONLINE QUIZ APPLICATION");
        System.out.println("==================================");

        for (Question q : questions) {
            q.displayQuestion();

            System.out.print("Enter your answer: ");
            String answer = sc.next();

            if (q.checkAnswer(answer)) {
                System.out.println("Correct Answer!\n");
                score++;
            } else {
                System.out.println("Wrong Answer!\n");
            }
        }

        displayResult();

        sc.close();
    }

    
    private void displayResult() {
        System.out.println("==================================");
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 80)
            System.out.println("Grade: Excellent");
        else if (percentage >= 60)
            System.out.println("Grade: Good");
        else if (percentage >= 40)
            System.out.println("Grade: Average");
        else
            System.out.println("Grade: Needs Improvement");

        System.out.println("==================================");
    }
}

public class Main {
    public static void main(String[] args) {
        QuizManager quiz = new QuizManager();
        quiz.startQuiz();
    }
}