package com.isolpro.library.rearranginggridlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class RearrangingGridLayout extends GridLayout {
  private final List<View> views = new ArrayList<>();

  public RearrangingGridLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public RearrangingGridLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RearrangingGridLayout(Context context) {
    this(context, null);
  }

  private void arrangeElements() {
    removeAllViews();

    for (int i = 0; i < views.size(); i++) {
      if (views.get(i).getVisibility() != GONE)
        addView(views.get(i));
    }
  }

  public void saveViews() {
    for (int i = 0; i < getChildCount(); i++) {
      views.add(getChildAt(i));
    }
  }

  public void hideViewAtIndex(int index) {
    if (index >= 0 && index < views.size()) {
      views.get(index).setVisibility(GONE);
      arrangeElements();
    }
  }

  public void showViewAtIndex(int index) {
    if (index >= 0 && index < views.size()) {
      views.get(index).setVisibility(VISIBLE);
      arrangeElements();
    }
  }
}
