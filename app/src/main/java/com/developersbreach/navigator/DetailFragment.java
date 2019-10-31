package com.developersbreach.navigator;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView directionsImageView = view.findViewById(R.id.detail_directions_icon_image_view);
        TextView directionsTextView = view.findViewById(R.id.detail_directions_name_text_view);

        Navigator navigator = DetailFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getDetailFragmentArguments();

        directionsImageView.setImageResource(navigator.getNavigatorIcon());
        directionsTextView.setText(navigator.getNavigatorName());

        return view;
    }
}
