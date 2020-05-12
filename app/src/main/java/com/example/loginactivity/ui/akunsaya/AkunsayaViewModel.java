package com.example.loginactivity.ui.akunsaya;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AkunsayaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AkunsayaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Akun saya fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
