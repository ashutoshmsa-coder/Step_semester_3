package week_8.class_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Question {
    String questionText;
    int marks;

    Question(String questionText, int marks) {
        this.questionText = questionText;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correctAnswer;

    MultipleChoiceQuestion(String questionText, int marks,
                           String correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {
    boolean correctAnswer;

    TrueFalseQuestion(String questionText, int marks,
                      boolean correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class ShortAnswerQuestion extends Question {
    String correctAnswer;

    ShortAnswerQuestion(String questionText, int marks,
                        String correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class Answer {
    Question question;
    String answer;

    Answer(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {
    String name;
    List<Question> questions = new ArrayList<>();

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    Student student;
    Examination examination;
    List<Answer> answers = new ArrayList<>();
    boolean submitted = false;

    Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    void recordAnswer(Question question, String answer) {

        if (submitted) {
            System.out.println(
                "Cannot change answers for a submitted examination."
            );
            return;
        }

        answers.add(new Answer(question, answer));

        System.out.println(
            "Answer recorded for: " + question.questionText
        );
    }

    void submit() {

        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;

        System.out.println(
            examination.name + " submitted by " + student.name
        );

        calculateResult();
    }

    void calculateResult() {

        int totalScore = 0;
        int totalMarks = 0;

        for (Question question : examination.questions) {
            totalMarks += question.marks;
        }

        for (Answer answer : answers) {

            if (answer.question.evaluate(answer.answer)) {

                totalScore += answer.question.marks;

                System.out.println(
                    "Question: " +
                    answer.question.questionText +
                    " - Correct (" +
                    answer.question.marks +
                    " points)"
                );

            } else {

                System.out.println(
                    "Question: " +
                    answer.question.questionText +
                    " - Incorrect (0 points)"
                );
            }
        }

        System.out.println(
            "Total score: " +
            totalScore +
            "/" +
            totalMarks
        );
    }
}

public class OnlineExaminationSystem {

    public static void main(String[] args) {

        Student student = new Student("Student 1");

        Examination exam = new Examination("Exam A");

        Question q1 = new MultipleChoiceQuestion(
            "Question 1 (MCQ)",
            5,
            "C"
        );

        Question q2 = new TrueFalseQuestion(
            "Question 2 (True/False)",
            5,
            false
        );

        exam.addQuestion(q1);
        exam.addQuestion(q2);

        Attempt attempt = new Attempt(student, exam);

        System.out.println(
            exam.name + " started by " + student.name
        );

        attempt.recordAnswer(q1, "C");

        attempt.recordAnswer(q2, "True");

        attempt.submit();

        // Attempt to change answer after submission
        attempt.recordAnswer(q1, "A");
    }
}