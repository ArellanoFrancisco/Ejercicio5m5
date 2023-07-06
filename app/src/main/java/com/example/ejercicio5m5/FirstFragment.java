package com.example.ejercicio5m5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ejercicio5m5.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WordAdapter adapter= new WordAdapter(Listauto());
        binding.RecyclerView.setAdapter(adapter);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.RecyclerView.setHasFixedSize(true);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add("+ Palabra "+dataList.size());
                binding.RecyclerView.getAdapter().notifyItemInserted(dataList.size());
                binding.RecyclerView.smoothScrollToPosition(dataList.size());

            }
        });
    }

    private List<String> Listauto() {
        for (int i = 0; i < 100; i++) {
            dataList.add("Palabra " + i);
        }
        return dataList;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}