package com.aimanbaharum.recyclerviewception.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aimanbaharum.recyclerviewception.R;
import com.aimanbaharum.recyclerviewception.adapter.ParentAdapter;
import com.aimanbaharum.recyclerviewception.model.Child;
import com.aimanbaharum.recyclerviewception.model.Parent;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ParentFragment extends Fragment {

    private static final String TAG = ParentFragment.class.getSimpleName();

    @Bind(R.id.rv_parent)
    RecyclerView recyclerViewParent;

    ArrayList<Parent> parentObj;
    ArrayList<Child> childObj;

    static final int PARENT_MAX = 5;
    static final int CHILD_MAX = 3;

    public ParentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_parent, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewParent.setLayoutManager(manager);
        recyclerViewParent.setHasFixedSize(true);

        ParentAdapter parentAdapter = new ParentAdapter(getActivity(), getParentData(), getChildData());
        recyclerViewParent.setAdapter(parentAdapter);
    }

    private ArrayList<Child> getChildData() {

        childObj = new ArrayList<>();

        for (int i = 0; i < CHILD_MAX; i++) {
            Child c = new Child();
            c.setChild_name("Child " + i);
            childObj.add(c);
        }

        return childObj;
    }

    private ArrayList<Parent> getParentData() {
        parentObj = new ArrayList<>();

        for (int i = 0; i < PARENT_MAX; i++) {
            Parent p = new Parent();
            p.setParent_header("Header " + i);
            parentObj.add(p);
        }

        return parentObj;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
