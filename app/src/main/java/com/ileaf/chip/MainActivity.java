package com.ileaf.chip;

import android.app.Activity;
import android.os.Bundle;

import com.ileaf.chiprecyclerviewlibrary.ChipRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.rv_interest_single)
    ChipRecyclerView rvInterestSingle;
    @BindView(R.id.rv_interest_multi)
    ChipRecyclerView rvInterestMulti;

    private ArrayList<String> interestList = new ArrayList<>();
    private String interestString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setInterestAdapterSingle();
        setInterestAdapterMulti();
    }

    public void setInterestAdapterSingle() {
        List<UserListData> userListData = new ArrayList<>();
        String[] interestArray = getResources().getStringArray(R.array.interest_array);
        for (int i = 0; i < interestArray.length; i++) {
            UserListData guestUserListData = new UserListData();
            guestUserListData.setName(interestArray[i]);
            guestUserListData.setSelected(false);
            userListData.add(guestUserListData);
        }
        InterestAdapter interestAdapterSingle = new InterestAdapter(this,
                userListData, rvInterestSingle.isMultiChoiceMode());
        rvInterestSingle.setAdapter(interestAdapterSingle);
    }

    public void setInterestAdapterMulti() {
        List<UserListData> userListData = new ArrayList<>();
        String[] interestArray = getResources().getStringArray(R.array.interest_array);
        for (int i = 0; i < interestArray.length; i++) {
            UserListData guestUserListData = new UserListData();
            guestUserListData.setName(interestArray[i]);
            guestUserListData.setSelected(false);
            userListData.add(guestUserListData);
        }
        InterestAdapter interestAdapterMulti = new InterestAdapter(this,
                userListData, rvInterestMulti.isMultiChoiceMode());
        rvInterestMulti.setAdapter(interestAdapterMulti);
    }

    public void selectGuestUserListData(List<UserListData> modifiedListUserData) {
        interestList = new ArrayList<>();
        for (int i = 0; i < modifiedListUserData.size(); i++) {
            if (modifiedListUserData.get(i).isSelected()) {
                interestList.add(modifiedListUserData.get(i).getName());
            }

        }
        interestString = interestList.toString().replaceAll("[\\[.\\].\\s+]", "");
    }

}
