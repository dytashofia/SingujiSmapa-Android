package com.example.loginactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link jadwal#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class jadwal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jadwal.
     */
    // TODO: Rename and change types and number of parameters
    public static jadwal newInstance(String param1, String param2) {
        jadwal fragment = new jadwal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public jadwal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    View v ;
    private RecyclerView myrecyclerview ;
    private List<JadwalItem> lstjadwal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_jadwal, container, false);
        // Inflate the layout for this fragment
        lstjadwal = new ArrayList<>();
        addJadwal();
        myrecyclerview = (RecyclerView) v.findViewById(R.id.jadwal_rcl);
        RecyclerViewAdapter_jadwal recyclerViewAdapter_jadwal = new RecyclerViewAdapter_jadwal(getContext(),lstjadwal);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter_jadwal);
        return v ;

    }
    //data yan ditampilkan masih manual belum ambil dari JSON

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void addJadwal(){
        lstjadwal.add(new JadwalItem("MATEMATIKA","Admin","Dinda Ayu Nafisyah",
                "Senin,8 Juni 2020 08.00 WIB","QUIZ","40","120",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("BAHASA INGGRIS","Guru","Dyta Sofia Amelia",
                "Selasa,9 Juni 2020 08.30 WIB","UTS","30","90",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("BIOLOGI","Guru","Ummalatul Kamila",
                "Rabu,10 Juni 2020 09.00 WIB","UAS","40","120",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("EKONOMI","Guru","Bagus Ihsan Taufiqurrahman",
                "Jumat,12 Juni 2020 09.30 WIB","UAS","20","60",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("MATEMATIKA","Guru","Dinda Ayu Nafisyah",
                "Senin,8 Juni 2020 08.00 WIB","QUIZ","40","120",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("BAHASA INGGRIS","Guru","Dyta Sofia Amelia",
                "Selasa,9 Juni 2020 08.30 WIB","UTS","30","90",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("BIOLOGI","Guru","Ummalatul Kamila",
                "Rabu,10 Juni 2020 09.00 WIB","UAS","40","120",R.drawable.jadwal_image));
        lstjadwal.add(new JadwalItem("EKONOMI","Guru","Ahmad Daifullah",
                "Jumat,12 Juni 2020 09.30 WIB","UAS","20","60",R.drawable.jadwal_image));
    }
}
