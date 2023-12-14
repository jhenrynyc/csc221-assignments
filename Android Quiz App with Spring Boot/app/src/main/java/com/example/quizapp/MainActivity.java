package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.api.QuizApi;
import com.example.quizapp.databinding.MainActivityLayoutBinding;
import com.example.quizapp.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MainActivityLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.catbtn.setOnClickListener(this::BtnChoice);
        binding.sports.setOnClickListener(this::BtnChoice);
        binding.fruits.setOnClickListener(this::BtnChoice);
        binding.math.setOnClickListener(this::BtnChoice);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://<my-ip>/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        QuizApi quizApi = retrofit.create(QuizApi.class);

    }

    public void BtnChoice(View view) {
        Intent intent = new Intent(this, quizActivity.class);
        int categoryId = -1;

        int id = view.getId();
        if (id == R.id.catbtn) {
            categoryId = 0;
        } else if (id == R.id.sports) {
            categoryId = 1;
        } else if (id == R.id.fruits) {
            categoryId = 2;
        } else if (id == R.id.math) {
            categoryId = 3;
        }

        intent.putExtra("CATEGORY_ID", categoryId);
        startActivity(intent);
    }

    private void fetchQuizzes() {
        QuizApi.getAllQuizzes().enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                if (response.isSuccessful()) {
                    List<Quiz> quizzes = response.body();
                } else {
                }
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
            }
        });
    }

}
