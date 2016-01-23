package com.aimanbaharum.recyclerviewception.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aimanbaharum.recyclerviewception.R;
import com.aimanbaharum.recyclerviewception.model.Child;
import com.aimanbaharum.recyclerviewception.model.ParentChild;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cliqers on 23/1/2016.
 */
public class ParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//    ArrayList<Parent> parentData;
//    ArrayList<Child> childData;
    ArrayList<ParentChild> parentChildData;

    Context ctx;

    public ParentAdapter(Context ctx, ArrayList<ParentChild> parentChildData) {
        this.ctx = ctx;
//        this.parentData = parentData;
//        this.childData= childData;
        this.parentChildData = parentChildData;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_header)
        TextView tv_header;
        @Bind(R.id.rv_child)
        RecyclerView rv_child;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parent, parent, false);

        ParentAdapter.ViewHolder pavh = new ParentAdapter.ViewHolder(itemLayoutView);

        return pavh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder vh = (ViewHolder) holder;


        ParentChild p = parentChildData.get(position);
        vh.tv_header.setText(p.getHeader());

        initChildLayoutManager(vh.rv_child, p.getChild());
    }

    private void initChildLayoutManager(RecyclerView rv_child, ArrayList<Child> childData) {
        LinearLayoutManager manager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_child.setLayoutManager(manager);
        rv_child.setHasFixedSize(true);
        rv_child.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        ChildAdapter childAdapter = new ChildAdapter(childData);
        rv_child.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return parentChildData.size();
    }
}
