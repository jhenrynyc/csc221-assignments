package com.example.quizapp.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import com.example.quizapp.model.Quiz;

import java.util.List;

public interface QuizApi {
    @GET("quizzes")
    static Call<List<Quiz>> getAllQuizzes() {
        return null;
    }

    @GET("quizzes/{id}")
    Call<Quiz> getQuiz(@Path("id") Long id);

    @POST("quizzes/{id}/submit")
    Call<String> submitQuiz(@Path("id") Long id, @Body List<Integer> answers);
}
