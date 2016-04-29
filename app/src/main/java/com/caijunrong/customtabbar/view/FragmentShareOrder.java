package com.caijunrong.customtabbar.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caijunrong.customtabbar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentShareOrder.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentShareOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShareOrder extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_share_order, container, false);
    }

}
