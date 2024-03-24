package Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.example.careerquick.R;

public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private int[] imageIds = {
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
            R.drawable.img_14
    };
    private int currentIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        viewFlipper = rootView.findViewById(R.id.viewFlipper);

        // Add images to ViewFlipper dynamically
        for (int imageId : imageIds) {
            ImageView imageView = new ImageView(requireContext());
            imageView.setImageResource(imageId);
            viewFlipper.addView(imageView);
        }

        // Set animation for the ViewFlipper
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(requireContext(), android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(requireContext(), android.R.anim.slide_out_right));

        // Set auto flipping interval
        viewFlipper.setFlipInterval(3000); // 3 seconds

        // Start flipping
        viewFlipper.startFlipping();

        return rootView;
    }
}
