package com.pjatk.bmi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.pjatk.bmi.R;
import com.pjatk.bmi.model.Question;

import java.util.ArrayList;

public class QuizFragment extends Fragment {

    private TextView mQuestionTextView;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private Button mNextButton;

    private ArrayList<Question> questionList;
    private int mCurrentIndex;
    private int mScore;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quiz, container, false);

        mQuestionTextView = view.findViewById(R.id.question_text_view);
        mRadioGroup = view.findViewById(R.id.answer_radio_group);
        mRadioButton1 = view.findViewById(R.id.choice_a_button);
        mRadioButton2 = view.findViewById(R.id.choice_b_button);
        mRadioButton3 = view.findViewById(R.id.choice_c_button);
        mNextButton = view.findViewById(R.id.submit_button);

        initiateQuestions();

        mCurrentIndex = 0;
        mScore = 0;
        setQuestion();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(v);
                mCurrentIndex++;
                if (mCurrentIndex < questionList.size()) {
                    setQuestion();
                } else {
                    endQuiz();
                }
            }
        });

        return view;
    }


    private void setQuestion() {
        // Set the question text
        mQuestionTextView.setText(questionList.get(mCurrentIndex).getQuestion());

        // Set the answer choices
        mRadioButton1.setText(questionList.get(mCurrentIndex).getAnswers()[0]);
        mRadioButton2.setText(questionList.get(mCurrentIndex).getAnswers()[1]);
        mRadioButton3.setText(questionList.get(mCurrentIndex).getAnswers()[2]);

        // Clear the radio button selection
        mRadioGroup.clearCheck();
    }

    private void checkAnswer(View v) {
        // Get the index of the correct answer
        int correctAnswerIndex = questionList.get(mCurrentIndex).getCorrectAnswerIndex();

        // Check if the selected answer is correct
        int selectedAnswerIndex = mRadioGroup.getCheckedRadioButtonId();
        if (selectedAnswerIndex != -1) {
            RadioButton selectedAnswer = view.findViewById(selectedAnswerIndex);
           int selectedAnswerValue = mRadioGroup.indexOfChild(selectedAnswer);
            if (selectedAnswerValue == correctAnswerIndex) {
                mScore++;
            }
        }
    }

    private void endQuiz() {
        // Show the final score and reset the quiz
        String text = "Your score is " + mScore + " out of " + questionList.size();
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
        mCurrentIndex = 0;
        mScore = 0;
        setQuestion();
    }

    private void initiateQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question(getResources().getString(R.string.question_1), new String[]{getResources().getString(R.string.q1_answer_a), getResources().getString(R.string.q1_answer_b), getResources().getString(R.string.q1_answer_c)},  Integer.parseInt(getResources().getString(R.string.q1_answer_correct_index))));
        questionList.add(new Question(getResources().getString(R.string.question_2), new String[]{getResources().getString(R.string.q2_answer_a), getResources().getString(R.string.q2_answer_b), getResources().getString(R.string.q2_answer_c)},  Integer.parseInt(getResources().getString(R.string.q2_answer_correct_index))));
        questionList.add(new Question(getResources().getString(R.string.question_3), new String[]{getResources().getString(R.string.q3_answer_a), getResources().getString(R.string.q3_answer_b), getResources().getString(R.string.q3_answer_c)},  Integer.parseInt(getResources().getString(R.string.q3_answer_correct_index))));
        questionList.add(new Question(getResources().getString(R.string.question_4), new String[]{getResources().getString(R.string.q4_answer_a), getResources().getString(R.string.q4_answer_b), getResources().getString(R.string.q4_answer_c)},  Integer.parseInt(getResources().getString(R.string.q4_answer_correct_index))));
        questionList.add(new Question(getResources().getString(R.string.question_5), new String[]{getResources().getString(R.string.q5_answer_a), getResources().getString(R.string.q5_answer_b), getResources().getString(R.string.q5_answer_c)},  Integer.parseInt(getResources().getString(R.string.q5_answer_correct_index))));
        questionList.add(new Question(getResources().getString(R.string.question_6), new String[]{getResources().getString(R.string.q6_answer_a), getResources().getString(R.string.q6_answer_b), getResources().getString(R.string.q6_answer_c)},  Integer.parseInt(getResources().getString(R.string.q6_answer_correct_index))));
        }
}
