package com.anz.tokoapps.ui.laporanbarang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LaporanBarangViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LaporanBarangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}