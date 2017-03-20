package com.example.wab.gmarket.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.wab.gmarket.MainActivity;
import com.example.wab.gmarket.R;
import java.util.ArrayList;
import java.util.List;
import me.yuqirong.cardswipelayout.CardConfig;
import me.yuqirong.cardswipelayout.CardItemTouchHelperCallback;
import me.yuqirong.cardswipelayout.CardLayoutManager;
import me.yuqirong.cardswipelayout.OnSwipeListener;

/**
 * Created by wab on 17-3-19.
 */

public class GuideActivity extends AppCompatActivity {

    private Context mContext;

    private List<Integer> list = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mContext = this;
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        list.add(R.mipmap.shengcai1);
        list.add(R.mipmap.yuanshengcai2);
        list.add(R.mipmap.youcai2);
    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_guide);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new GuideAdapter());
        CardItemTouchHelperCallback cardCallback =
                new CardItemTouchHelperCallback(recyclerView.getAdapter(), list);
        cardCallback.setOnSwipedListener(new OnSwipeListener<Integer>() {

            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                GuideViewHolder myHolder = (GuideViewHolder) viewHolder;
                //viewHolder.itemView.setAlpha(1 - Math.abs(ratio) * 0.2f);
                if (direction == CardConfig.SWIPING_LEFT) {
                    //myHolder.dislikeImageView.setAlpha(Math.abs(ratio));
                } else if (direction == CardConfig.SWIPING_RIGHT) {
                    //myHolder.likeImageView.setAlpha(Math.abs(ratio));
                } else {
                    //myHolder.dislikeImageView.setAlpha(0f);
                    //myHolder.likeImageView.setAlpha(0f);
                }
            }

            @Override public void onSwiped(RecyclerView.ViewHolder viewHolder, Integer integer,
                    int direction) {
                GuideViewHolder myHolder = (GuideViewHolder) viewHolder;
                viewHolder.itemView.setAlpha(1f);
                //myHolder.dislikeImageView.setAlpha(0f);
                //myHolder.likeImageView.setAlpha(0f);
                //Toast.makeText(GuideActivity.this,
                //        direction == CardConfig.SWIPED_LEFT ? "swiped left" : "swiped right",
                //        Toast.LENGTH_SHORT).show();
            }

            @Override public void onSwipedClear() {
                toMain();
            }
        });

        final ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        final CardLayoutManager cardLayoutManager =
                new CardLayoutManager(recyclerView, touchHelper);
        recyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void toMain() {
        startActivity(new Intent(GuideActivity.this, MainActivity.class));
        finish();
    }

    class GuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_guide, parent, false);
            return new GuideViewHolder(view);
        }

        @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            GuideViewHolder guideHolder = (GuideViewHolder) holder;
            guideHolder.ivMain.setImageResource(list.get(position));
        }

        @Override public int getItemCount() {
            return list.size();
        }
    }

    class GuideViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_guide_main) ImageView ivMain;
        @BindView(R.id.tv_top) TextView tvtop;

        public GuideViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @OnClick(R.id.ft_to_main) public void onClick(View view) {
        toMain();
    }
}
