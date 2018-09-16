package com.example.mrrs.schoolhelper.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TitleCreator {
    static TitleCreator _titleCreater;
    List<TitleParent> _titleParents;

    public TitleCreator(Context context) {
        _titleParents = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            TitleParent titleParent = new TitleParent(String.format("Caller #%d",i));
            _titleParents.add(titleParent);
        }
    }

    public static TitleCreator get(Context context){
        if(_titleCreater == null)
         _titleCreater = new TitleCreator(context);
        return _titleCreater;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
