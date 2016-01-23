package com.aimanbaharum.recyclerviewception.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aimanbaharum.recyclerviewception.R;
import com.aimanbaharum.recyclerviewception.model.Child;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cliqers on 23/1/2016.
 */
public class ChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Child> childData;

    public ChildAdapter(ArrayList<Child> childData) {
        this.childData = childData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_child)
        TextView tv_child;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child, parent, false);

        ChildAdapter.ViewHolder cavh = new ChildAdapter.ViewHolder(itemLayoutView);

        return cavh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        Child c = childData.get(position);
        vh.tv_child.setText(c.getChild_name());
    }

    @Override
    public int getItemCount() {
        return childData.size();
    }
}
