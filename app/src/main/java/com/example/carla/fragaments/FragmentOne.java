package com.example.carla.fragaments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FragmentOne extends Fragment {
    private EditText textViewFragmentOne;
    private ImageView indicator;
    private int colorId = android.R.color.black;
    private Button colorOne;
    private Button colorTwo;
    private Button colorThree;
    private Button colorFour;
    private Button buttonFragmentOne;
    private OnFragmentInteractionListener mListener;
    public FragmentOne() {
        // Required empty public constructor
    }

    private void changeColor() {
        indicator.setColorFilter(ContextCompat.getColor(getContext(), colorId));
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        textViewFragmentOne = rootView.findViewById(R.id.textViewFragmentOne);
        buttonFragmentOne = rootView.findViewById(R.id.buttonFragmentOne);
        indicator = rootView.findViewById(R.id.indicator);
        buttonFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(colorId);
            }
        });
        Button colorOne = rootView.findViewById(R.id.colorOne);
        Button colorTwo = rootView.findViewById(R.id.colorTwo);
        Button colorThree = rootView.findViewById(R.id.colorThree);
        Button colorFour = rootView.findViewById(R.id.colorFour);
        colorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_blue_dark;
                changeColor();
            }
        });
        colorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_green_dark;
                changeColor();
            }
        });
        colorThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_orange_dark;
                changeColor();
            }
        });
        colorFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_red_dark;
                changeColor();
            }
        });
        return rootView;
    }

    private void onButtonPressed(int colorId) {
        if (mListener != null) {
            mListener.onFragmentInteraction(textViewFragmentOne.getText().toString(), colorId);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text, int colorId);
    }
}