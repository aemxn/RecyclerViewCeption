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
import com.aimanbaharum.recyclerviewception.model.ParentChild;

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

    ArrayList<ParentChild> parentChildObj;


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

        ParentAdapter parentAdapter = new ParentAdapter(getActivity(), getParentChildData());
        recyclerViewParent.setAdapter(parentAdapter);
    }

    private ArrayList<ParentChild> getParentChildData() {
        parentChildObj = new ArrayList<>();
        ArrayList<Child> c1List = new ArrayList<>();
        ArrayList<Child> c2List = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Child c1 = new Child();
            c1.setChild_name("Child 1." + (i + 1));
            c1List.add(c1);
        }

        for (int i = 0; i < 5; i++) {
            Child c2 = new Child();
            c2.setChild_name("Child 2." + (i + 1));
            c2List.add(c2);
        }

        ParentChild pc1 = new ParentChild();
        pc1.setHeader("Header 1");
        pc1.setChild(c1List);
        parentChildObj.add(pc1);

        ParentChild pc2 = new ParentChild();
        pc2.setHeader("Header 2");
        pc2.setChild(c2List);
        parentChildObj.add(pc2);


        return parentChildObj;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
