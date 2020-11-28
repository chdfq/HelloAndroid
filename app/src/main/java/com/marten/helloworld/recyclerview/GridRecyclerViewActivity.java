package com.marten.helloworld.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marten.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,  3));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "click " + pos, Toast.LENGTH_SHORT).show();
            }
        }, new GridAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "longclick " + pos, Toast.LENGTH_SHORT).show();
            }
        }));

        mRvGrid.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividHeight),getResources().getDimensionPixelOffset(R.dimen.dividHeight));
            }
        });
    }
}