package com.marin.saul.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NumericPadFragment extends Fragment {

    public interface DigitPressed{
        public void onDigitPressed(String digit);
    }

    private DigitPressed listener;

    @BindView(R.id.activity_main_number0)Button number0;
    @BindView(R.id.activity_main_number1)Button number1;
    @BindView(R.id.activity_main_number2)Button number2;
    @BindView(R.id.activity_main_number3)Button number3;
    @BindView(R.id.activity_main_number4)Button number4;
    @BindView(R.id.activity_main_number5)Button number5;
    @BindView(R.id.activity_main_number6)Button number6;
    @BindView(R.id.activity_main_number7)Button number7;
    @BindView(R.id.activity_main_number8)Button number8;
    @BindView(R.id.activity_main_number9)Button number9;
    @BindView(R.id.activity_main_dot)Button buttonDot;

    public NumericPadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeric_pad, container, false);

        ButterKnife.bind(this, view);

        Button[] numbers = {
                number0,
                number1,
                number2,
                number3,
                number4,
                number5,
                number6,
                number7,
                number8,
                number9,
                buttonDot
        };
        for (final Button number: numbers) {
            number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ( listener != null){
                            listener.onDigitPressed("" + number.getText());
                        }
                }
            });
        }


        return view;
    }

    public DigitPressed getOnDigitPressedListener() {
        return listener;
    }

    public void setOnDigitPressedListener(DigitPressed listener) {
        this.listener = listener;
    }
}
