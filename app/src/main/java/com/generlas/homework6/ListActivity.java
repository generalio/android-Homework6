package com.generlas.homework6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements OnItemClikListener{

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recicleViews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(getSampleData(),this);
        recyclerView.setAdapter(adapter);
    }

    private List<Things> getSampleData() {
        List<Things> data = new ArrayList<>();
        data.add(new Things("1","abcdefg"));
        data.add(new Things("2","3G"));
        data.add(new Things("3","6G"));
        return data;
    }

    @Override
    public void OnItemClick(int position) {
        adapter.notifyItemChanged(position,"success changed!");
    }
}