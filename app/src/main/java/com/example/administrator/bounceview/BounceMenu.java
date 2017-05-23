package com.example.administrator.bounceview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/**
 * Created by ShuWen on 2017/5/23.
 */

public class BounceMenu {
    private RecyclerView recyclerView;
    private BounceView bounceView;
    private ViewGroup parentVG;
    private View rootView;

    private BounceMenu(View view, int resId, final MyAdapter myAdapter) {
        parentVG = findParentVG(view);

        rootView = LayoutInflater.from(view.getContext()).inflate(resId,null,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        bounceView = (BounceView) rootView.findViewById(R.id.bounceview);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        bounceView.setAnimatorListener(new BounceView.BounceAnimatorListener() {
            @Override
            public void showContent() {
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.setAdapter(myAdapter);
                recyclerView.scheduleLayoutAnimation();
            }
        });
    }

    public static BounceMenu makeBounce(View view, int resId, final MyAdapter myAdapter){
        return new BounceMenu(view, resId, myAdapter);
    }

    public void show(){
        if (rootView != null){
            parentVG.removeView(rootView);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        parentVG.addView(rootView,layoutParams);
        bounceView.show();
    }

    private ViewGroup findParentVG(View view) {
        do {
            if (view instanceof FrameLayout){
                //找到decorview的根布局
                if (view.getId() == android.R.id.content){
                    return (ViewGroup) view;
                }
            }

            if (view != null){
                ViewParent viewParent = view.getParent();
                view = viewParent instanceof View? (View) viewParent :null;
            }
        }while (view!= null);
        return null;
    }
}
