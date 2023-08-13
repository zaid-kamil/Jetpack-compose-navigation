package com.example.navexample

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ExerciseType(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)

class DataSources {
    fun getExercises() = listOf<ExerciseType>(
        ExerciseType(R.string.exercise_type_1, R.drawable.exercise_1),
        ExerciseType(R.string.exercise_type_2, R.drawable.exercise_2),
        ExerciseType(R.string.exercise_type_3, R.drawable.exercise_3),
        ExerciseType(R.string.exercise_type_4, R.drawable.exercise_4),
        ExerciseType(R.string.exercise_type_5, R.drawable.exercise_5),
    )
}