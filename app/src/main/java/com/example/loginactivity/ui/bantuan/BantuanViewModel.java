package com.example.loginactivity.ui.bantuan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BantuanViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BantuanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Bantuan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
