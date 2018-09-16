package com.example.mrrs.schoolhelper.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.mrrs.schoolhelper.R;

public class TitleParentViewHolder extends ParentViewHolder {
    public TextView _textview;
    public ImageView _imvButton;
    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _textview = (TextView) itemView.findViewById(R.id.titleParent);
        _imvButton = (ImageView) itemView.findViewById(R.id.expandArrow);
    }
}
