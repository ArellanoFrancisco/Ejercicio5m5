package com.example.ejercicio5m5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ejercicio5m5.databinding.WordItemListBinding;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    private List<String> mwordlist;

    public WordAdapter(List<String> mwordlist){
        this.mwordlist= mwordlist;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding mBinding= WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String element= mwordlist.get(position);
        holder.textView.setText(element);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra= holder.textView.getText().toString();
                holder.textView.setText("Clicked! "+ palabra);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mwordlist.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WordViewHolder(@NonNull  WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;


        }
    }
}
