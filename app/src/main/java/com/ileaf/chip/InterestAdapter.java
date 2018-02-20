package com.ileaf.chip;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ileaf.chiprecyclerviewlibrary.ChipRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by e203 on 10/5/17.
 */

public class InterestAdapter extends ChipRecyclerView.Adapter<InterestAdapter.InterestViewHolder> {

    private Context mContext;
    private List<UserListData> listUserData;
    private boolean isMultiChoice;
    private int selectedPosition = -1;

    InterestAdapter(Context context, List<UserListData> listGuestUserData, boolean isMultiChoice) {
        this.listUserData = listGuestUserData;
        this.mContext = context;
        this.isMultiChoice = isMultiChoice;

    }


    @Override
    public InterestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new InterestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final InterestViewHolder holder, final int position) {
       if (isMultiChoice) {
           handleMultiChoiceSelection(holder,position,holder.tvName);
       }
       else {
          handleSingleChoiceSelection(holder,position,holder.tvName);
       }
    }

    @Override
    public int getItemCount() {
        return listUserData.size();
    }


    class InterestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        InterestViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private void handleMultiChoiceSelection(RecyclerView.ViewHolder holder, final int position, TextView textView) {
        if (listUserData.get(position).isSelected()) {
            textView.setBackgroundResource(R.drawable.user_data_bg_selected);
        } else {
            textView.setBackgroundResource(R.drawable.user_data_bg_unselected);
        }
        textView.setText(listUserData.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listUserData.get(position).isSelected()) {
                    listUserData.get(position).setSelected(false);
                } else {
                    listUserData.get(position).setSelected(true);
                }
                if (mContext instanceof MainActivity) {
                    ((MainActivity) mContext).selectGuestUserListData(listUserData);
                }
                notifyDataSetChanged();
            }
        });
    }

    private void handleSingleChoiceSelection(RecyclerView.ViewHolder holder, final int position, TextView textView) {
        if (selectedPosition == position) {
            textView.setBackgroundResource(R.drawable.user_data_bg_selected);
        } else {
            textView.setBackgroundResource(R.drawable.user_data_bg_unselected);
        }
        textView.setText(listUserData.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = position;
                if (mContext instanceof MainActivity) {
                    ((MainActivity) mContext).selectGuestUserListData(listUserData);
                }
                notifyDataSetChanged();
            }
        });
    }
}
