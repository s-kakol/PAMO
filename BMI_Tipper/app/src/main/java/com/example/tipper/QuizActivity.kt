package com.example.tipper

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.quiz.Quiz
import kotlin.math.ceil

class QuizActivity : AppCompatActivity() {
    private var questionContent: TextView? = null
    private var questionIndex = 0
    private var quizQuestion = 0
    private var progressBar: ProgressBar? = null
    private var stats: TextView? = null
    private var userScore = 0

    private val quiz = arrayOf(
            Quiz(R.string.quiz_question_1, true),
            Quiz(R.string.quiz_question_2, true),
            Quiz(R.string.quiz_question_3, false),
            Quiz(R.string.quiz_question_4, false),
            Quiz(R.string.quiz_question_5, true),
            Quiz(R.string.quiz_question_6, false))
    private var quizProgress = ceil(100.0 / quiz.size).toInt()
    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_quiz)

        questionContent = findViewById(R.id.quizQuestionContent)

        val positiveAnswerButton = findViewById<Button>(R.id.quizPositiveAnswerButton)
        val negativeAnswerButton = findViewById<Button>(R.id.quizNegativeAnswerButton)

        progressBar = findViewById(R.id.quizProgressBar)
        stats = findViewById(R.id.quizStats)

        val currentQuestion = quiz[questionIndex]

        quizQuestion = currentQuestion.question
        questionContent?.setText(quizQuestion)

        positiveAnswerButton.setOnClickListener {
            checkAnswer(true)
            changeQuestion()
        }
        negativeAnswerButton.setOnClickListener {
            checkAnswer(false)
            changeQuestion()
        }
    }

    private fun checkAnswer(answerFromUserInput: Boolean) {
        val actualQuestionAnswer = quiz[questionIndex].answer
        if (actualQuestionAnswer == answerFromUserInput) userScore += 1
    }

    @SuppressLint("SetTextI18n")
    private fun changeQuestion() {
        questionIndex = (questionIndex + 1) % quiz.size
        if (questionIndex == 0) {
            val alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle("Quiz Finished")
            alert.setMessage("Your total score: " + userScore + "/" + quiz.size)
            alert.setPositiveButton("Return") { _: DialogInterface?, _: Int -> finish() }
            alert.show()
        }
        quizQuestion = quiz[questionIndex].question
        questionContent!!.setText(quizQuestion)
        progressBar!!.incrementProgressBy(quizProgress)
        stats!!.text = userScore.toString() + "/" + quiz.size
    }
}