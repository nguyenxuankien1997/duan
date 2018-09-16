package com.example.mrrs.schoolhelper.viewholders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.mrrs.schoolhelper.R;

public class TitleChildViewHolder extends ChildViewHolder{
    public TextView option1, option2, option3;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1 = (TextView) itemView.findViewById(R.id.option_1);
        option2 = (TextView) itemView.findViewById(R.id.option_2);
        option3 = (TextView) itemView.findViewById(R.id.option_3);
    }
}
