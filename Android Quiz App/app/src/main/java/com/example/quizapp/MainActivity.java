package com.example.quizapp;

import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.QuizActivityLayoutBinding;

public class MainActivity extends AppCompatActivity {

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
    QuizActivityLayoutBinding binding;

    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = QuizActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showQuestionChoices();
    }

    private void showQuestionChoices() {
        if (currentIndex < 5) {
            binding.question.setText(fruitQuestions[currentIndex]);
            binding.button.setText(fruitChoices[currentIndex][0]);
            binding.button2.setText(fruitChoices[currentIndex][1]);
            binding.button3.setText(fruitChoices[currentIndex][2]);
            binding.button4.setText(fruitChoices[currentIndex][3]);

            String finalanswer = fruitCorrectAnswers[currentIndex];
            binding.button.setOnClickListener(v -> checkAnswer(binding.button.getText().toString(), finalanswer));
            binding.button2.setOnClickListener(v -> checkAnswer(binding.button2.getText().toString(), finalanswer));
            binding.button3.setOnClickListener(v -> checkAnswer(binding.button3.getText().toString(), finalanswer));
            binding.button4.setOnClickListener(v -> checkAnswer(binding.button4.getText().toString(), finalanswer));

        }else {
            binding.question.setText("You scored " + score + " out of 5");

            binding.button.setVisibility(View.GONE);
            binding.button2.setVisibility(View.GONE);
            binding.button3.setVisibility(View.GONE);
            binding.button4.setVisibility(View.GONE);
        }
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