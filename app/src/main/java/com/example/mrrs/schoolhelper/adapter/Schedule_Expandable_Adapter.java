package com.example.mrrs.schoolhelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.mrrs.schoolhelper.R;
import com.example.mrrs.schoolhelper.models.TitleChild;
import com.example.mrrs.schoolhelper.models.TitleParent;
import com.example.mrrs.schoolhelper.viewholders.TitleChildViewHolder;
import com.example.mrrs.schoolhelper.viewholders.TitleParentViewHolder;

import java.util.List;

public class Schedule_Expandable_Adapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;

    public Schedule_Expandable_Adapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.list_schedule_expandable_recyview,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.list_schedule_expandable_child,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent = (TitleParent)o;
        titleParentViewHolder._textview.setText(titleParent.getTitle());
    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild titleChild = (TitleChild)o;
        titleChildViewHolder.option1.setText(titleChild.getOption1());
        titleChildViewHolder.option2.setText(titleChild.getOption2());
        titleChildViewHolder.option3.setText(titleChild.getOption3());
    }
}
