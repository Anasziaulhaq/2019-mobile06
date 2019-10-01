package id.ac.polinema.idealbodyweight.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.polinema.idealbodyweight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AbaoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AbaoutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    private static final String ARG_NAME = "name";


    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    private String name;

    public  AbaoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AbaoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AbaoutFragment newInstance(String name) {
        AbaoutFragment fragment = new AbaoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME,name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_abaout, container, false);
        TextView nameText = view.findViewById(R.id.text_name);
        nameText.setText(name);
        return view;
    }

}
