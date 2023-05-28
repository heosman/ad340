/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
            Question(text = "Who developed the game LIMBO?",
                    answers = listOf("Playdead", "Blizzard Entertainment", "Electronic Arts", "Sega")),
            Question(text = "What player mode type is LIMBO?",
                    answers = listOf("Single-player video game", "Multiple-player video game", "Massively multiplayer online game", "None")),
            Question(text = "When was LIMBO released?",
                    answers = listOf("2010", "2019", "2006", "2023")),
            Question(text = "What is LIMBO about?",
                    answers = listOf("Uncertain of his sister's fate, a boy enters LIMBO.", "Delve into a dark adventure following the boy with a prosthetic face and a tragic past. Unravel the sinister mysteries of Sally's world to find the truth that lies hidden beneath the shadows.", "Hunted and alone, a boy finds himself drawn into the center of a dark project.", "None")),
            Question(text = "Which of the following is not a genre of LIMBO?",
                    answers = listOf("Fighting", "Adventure", "Action", "Indie")),
            Question(text = "In LIMBO, how many endings are there?",
                    answers = listOf("1", "2", "3", "4")),
            Question(text = "What is trying to kill the little boy?",
                    answers = listOf("A giant spider", "His sister", "Shadows", "A monster")),
            Question(text = "What is the name of the main character?",
                    answers = listOf("He is nameless.", "Kevin", "Adam", "Trina")),
            Question(text = "HOw many awards has the game LIMBO won?",
                    answers = listOf("More than 100", "9", "21", "60")),
            Question(text = "What other game(s) did the creators of LIMBO also create?",
                    answers = listOf("INSIDE", "Fran Bow", "Sally Face", "All of these"))
    )



    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController()
                            .navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().
                    navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
        }

        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}
