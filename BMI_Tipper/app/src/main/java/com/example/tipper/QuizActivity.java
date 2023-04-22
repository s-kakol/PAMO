package com.example.tipper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tipper.quiz.Quiz;

public class QuizActivity extends AppCompatActivity {
    private TextView questionContent;
    private int questionIndex;
    private int quizQuestion;
    private ProgressBar progressBar;
    private TextView stats;
    private int userScore;

    private final Quiz[] quiz = new Quiz[]{
            new Quiz(R.string.quiz_question_1, true),
            new Quiz(R.string.quiz_question_2, true),
            new Quiz(R.string.quiz_question_3, false),
            new Quiz(R.string.quiz_question_4, false),
            new Quiz(R.string.quiz_question_5, true),
            new Quiz(R.string.quiz_question_6, false),
    };

    int quizProgress = (int) Math.ceil(100.0 / quiz.length);

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_quiz);

        questionContent = findViewById(R.id.quizQuestionContent);
        Button positiveAnswerButton = findViewById(R.id.quizPositiveAnswerButton);
        Button negativeAnswerButton = findViewById(R.id.quizNegativeAnswerButton);
        progressBar = findViewById(R.id.quizProgressBar);
        stats = findViewById(R.id.quizStats);

        Quiz currentQuestion = quiz[questionIndex];
        quizQuestion = currentQuestion.getQuestion();
        questionContent.setText(quizQuestion);

        positiveAnswerButton.setOnClickListener(v -> {
            checkAnswer(true);
            changeQuestion();
        });

        negativeAnswerButton.setOnClickListener(v -> {
            checkAnswer(false);
            changeQuestion();
        });
    }

    private void checkAnswer(boolean answerFromUserInput) {
        boolean actualQuestionAnswer = quiz[questionIndex].getAnswer();
        if (actualQuestionAnswer == answerFromUserInput) userScore += 1;
    }

    @SuppressLint("SetTextI18n")
    private void changeQuestion() {
        questionIndex = (questionIndex + 1) % quiz.length;

        if (questionIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setTitle("Quiz Finished");
            alert.setMessage("Your total score: " + userScore + "/" + quiz.length);
            alert.setPositiveButton("Return", (dialogInterface, i) -> finish());
            alert.show();
        }

        quizQuestion = quiz[questionIndex].getQuestion();
        questionContent.setText(quizQuestion);
        progressBar.incrementProgressBy(quizProgress);
        stats.setText(userScore + "/" + quiz.length);
    }
}
