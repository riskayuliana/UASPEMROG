package com.anz.tokoapps.response;


import com.anz.tokoapps.model.Entry_barang;
import com.anz.tokoapps.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseBarang {

    private String status, message;
    private List<Entry_barang> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Entry_barang> getData() {
        return data;
    }

    public void setData(List<Entry_barang> data) {
        this.data = data;
    }

}
