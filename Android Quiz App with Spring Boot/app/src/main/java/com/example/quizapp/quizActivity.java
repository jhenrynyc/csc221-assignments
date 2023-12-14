package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizapp.databinding.QuizActivityLayoutBinding;

public class quizActivity extends AppCompatActivity {

    private int categoryId;
    private final String[] fruitQuestions = {
            "Which fruit is known as the 'King of Fruits'?",
            "What color is the inside of a kiwifruit?",
            "Which fruit is the main ingredient in traditional guacamole?",
            "What type of fruit is a Fuji?",
            "Which fruit is famous for having its seeds on the outside?"
    };

    private final String[][] fruitChoices = {
            {"Mango", "Apple", "Banana", "Durian"},
            {"Green", "Red", "Yellow", "Orange"},
            {"Tomato", "Lemon", "Avocado", "Pineapple"},
            {"Apple", "Orange", "Pear", "Cherry"},
            {"Strawberry", "Grape", "Blueberry", "Raspberry"}
    };

    private final String[] fruitCorrectAnswers = {
            "Mango",
            "Green",
            "Avocado",
            "Apple",
            "Strawberry"
    };

    private final String[] sportsQuestions = {
            "Which country won the 2018 FIFA World Cup?",
            "What is the highest score in bowling?",
            "How many players are on a basketball team?",
            "What sport is played at Wimbledon?",
            "In which sport might you perform a slam dunk?"
    };

    private final String[][] sportsChoices = {
            {"France", "Brazil", "Germany", "Spain"},
            {"200", "250", "300", "350"},
            {"5", "7", "9", "11"},
            {"Cricket", "Tennis", "Golf", "Soccer"},
            {"Volleyball", "Basketball", "Football", "Tennis"}
    };

    private final String[] sportsCorrectAnswers = {
            "France",
            "300",
            "5",
            "Tennis",
            "Basketball"
    };


    private final String[] Catquestions = {
            "What is the average lifespan of a domestic cat?",
            "Which of these is not a breed of cat?",
            "How many whiskers does a cat typically have?",
            "What is the process of a cat shedding its fur called?",
            "What part of a cat's body is unique to each individual cat, much like human fingerprints?"
    };

    private final String[][] Catchoices = {
            {"10-15 years", "3-5 years", "20-25 years", "30-35 years"},
            {"Siamese", "Bengal", "Persian", "Dragon"},
            {"12", "24", "36", "48"},
            {"Molting", "Shedding", "Sloughing", "Peeling"},
            {"Nose", "Tail", "Paw", "Ear"}
    };

    private final String[] CatcorrectAnswers = {
            "10-15 years",
            "Dragon",
            "24",
            "Shedding",
            "Nose"
    };

    private final String[] mathQuestions = {
            "What is the value of Pi to two decimal places?",
            "What is 7 multiplied by 6?",
            "What is the square root of 81?",
            "What is 15% of 200?",
            "What comes after a million, billion, and trillion?"
    };

    private final String[][] mathChoices = {
            {"3.14", "3.15", "3.16", "3.17"},
            {"42", "48", "54", "60"},
            {"8", "9", "10", "11"},
            {"30", "40", "50", "60"},
            {"Quadrillion", "Quintillion", "Sextillion", "Septillion"}
    };

    private final String[] mathCorrectAnswers = {
            "3.14",
            "42",
            "9",
            "30",
            "Quadrillion"
    };

    private int score = 0;
    private int currentIndex = 0;
    private QuizActivityLayoutBinding quizbinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizbinding = QuizActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(quizbinding.getRoot());

        categoryId = getIntent().getIntExtra("CATEGORY_ID", -1);

        showQuestionChoices();
    }

    private void showQuestionChoices() {
        if (currentIndex < 5) {
            String question = "";
            String[] choices = new String[4];
            String correctAnswer = "";
            switch (categoryId) {
                case 0:
                    question = Catquestions[currentIndex];
                    choices = Catchoices[currentIndex];
                    correctAnswer = CatcorrectAnswers[currentIndex];
                    break;
                case 1:
                    question = sportsQuestions[currentIndex];
                    choices = sportsChoices[currentIndex];
                    correctAnswer = sportsCorrectAnswers[currentIndex];
                    break;
                case 2:
                    question = fruitQuestions[currentIndex];
                    choices = fruitChoices[currentIndex];
                    correctAnswer = fruitCorrectAnswers[currentIndex];
                    break;
                case 3:
                    question = mathQuestions[currentIndex];
                    choices = mathChoices[currentIndex];
                    correctAnswer = mathCorrectAnswers[currentIndex];
                    break;
            }
            quizbinding.question.setText(question);
            quizbinding.button.setText(choices[0]);
            quizbinding.button2.setText(choices[1]);
            quizbinding.button3.setText(choices[2]);
            quizbinding.button4.setText(choices[3]);

            String finalanswer = correctAnswer;
            quizbinding.button.setOnClickListener(v -> checkAnswer(quizbinding.button.getText().toString(), finalanswer));
            quizbinding.button2.setOnClickListener(v -> checkAnswer(quizbinding.button2.getText().toString(), finalanswer));
            quizbinding.button3.setOnClickListener(v -> checkAnswer(quizbinding.button3.getText().toString(), finalanswer));
            quizbinding.button4.setOnClickListener(v -> checkAnswer(quizbinding.button4.getText().toString(), finalanswer));
        } else {
            quizbinding.question.setText("You scored " + score + " out of 5");

            quizbinding.button.setVisibility(View.GONE);
            quizbinding.button2.setVisibility(View.GONE);
            quizbinding.button3.setVisibility(View.GONE);
            quizbinding.button4.setVisibility(View.GONE);

            quizbinding.resetBtn.setVisibility(View.VISIBLE);
            quizbinding.resetBtn.setOnClickListener(v -> resetBtn());
        }
    }

    private void resetBtn() {
        currentIndex = 0;
        score = 0;
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void checkAnswer(String selectedAnswer, String correctAnswer) {
        if (selectedAnswer.equals(correctAnswer)) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

        currentIndex++;
        showQuestionChoices();
    }
}
