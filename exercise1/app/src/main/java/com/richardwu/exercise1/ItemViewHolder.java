package com.richardwu.exercise1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView itemText;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemText = itemView.findViewById(R.id.item);
    }
}
