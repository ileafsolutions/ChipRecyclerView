package com.ileaf.chiprecyclerviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

/**
 * Created by e203 on 14/2/18.
 */

public class ChipRecyclerView extends RecyclerView{

    boolean isMultiChoice;

    public ChipRecyclerView(Context context) {
        super(context);
        setHorizontalRecyclerView();
    }

    public ChipRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ChipRecyclerView, 0, 0);
        try {
            isMultiChoice = ta.getBoolean(R.styleable.ChipRecyclerView_multiSelection, false);
        } finally {
            ta.recycle();
        }
        setHorizontalRecyclerView();
    }

    public ChipRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ChipRecyclerView, 0, 0);
        try {
            isMultiChoice = ta.getBoolean(R.styleable.ChipRecyclerView_multiSelection, false);
        } finally {
            ta.recycle();
        }
        setHorizontalRecyclerView();
    }

    public void setMultiChoiceMode(boolean isMultiChoice) {
        this.isMultiChoice = isMultiChoice;
    }

    public boolean isMultiChoiceMode() {
        return isMultiChoice;
    }

    private void setHorizontalRecyclerView() {
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        setLayoutManager(layoutManager);
    }
}
