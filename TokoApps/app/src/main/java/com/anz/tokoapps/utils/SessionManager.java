package com.anz.tokoapps.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.anz.tokoapps.model.Entry_barang;
import com.anz.tokoapps.model.User;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context _context;

    public static final String IS_LOGGED_IN = "isLogginIn";
    public static final String ID_USER = "idUser";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NAMA_LENGKAP = "namaLengkap";
    public static final String EMAIL = "email";
    public static final String ALAMAT = "alamat";
    public static final String JENIS_KELAMIN = "jenisKelamin";

//    public static final String ID_BARANG = "idBarang";
//    public static final String NAMA_BARANG = "namaBarang";
//    public static final String HARGABELI_BARANG = "hargaBelibarang";
//    public static final String HARGAJUAL_BARANG = "hargaJualbarang";
//    public static final String JUMLAH = "jumlah";
//    public static final String ENTRY_BY = "entryBy";

    public Context get_context() {
        return _context;
    }

    //constructor
    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(User user)
    {
        editor.putBoolean(IS_LOGGED_IN,true);
        editor.putString(ID_USER,user.getIdUser());
        editor.putString(USERNAME,user.getUsername());
        editor.putString(PASSWORD,user.getPassword());
        editor.putString(NAMA_LENGKAP,user.getNamaLengkap());
        editor.putString(EMAIL,user.getEmail());
        editor.putString(ALAMAT,user.getAlamat());
        editor.putString(JENIS_KELAMIN,user.getJenisKelamin());
        editor.commit();
    }

//    public void createLoginSession(Entry_barang entry_barang)
//    {
//        editor.putBoolean(IS_LOGGED_IN,true);
//        editor.putString(ID_BARANG,entry_barang.getIdBarang());
//        editor.putString(NAMA_BARANG,entry_barang.getNamaBarang());
//        editor.putString(HARGABELI_BARANG,entry_barang.getHargaBelibarang());
//        editor.putString(HARGAJUAL_BARANG,entry_barang.getHargaJualbarang());
//        editor.putString(JUMLAH,entry_barang.getJumlah());
//        editor.putString(ENTRY_BY,entry_barang.getEntryby());
//        editor.commit();
//    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID_USER,sharedPreferences.getString(ID_USER,null));
        user.put(USERNAME,sharedPreferences.getString(USERNAME,null));
        user.put(PASSWORD,sharedPreferences.getString(PASSWORD,null));
        user.put(NAMA_LENGKAP,sharedPreferences.getString(NAMA_LENGKAP,null));
        user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
        user.put(ALAMAT,sharedPreferences.getString(ALAMAT,null));
        user.put(JENIS_KELAMIN,sharedPreferences.getString(JENIS_KELAMIN,null));
        return  user;

    }

//    public HashMap<String, String> geEntryBarangDetail(){
//        HashMap<String, String> entry_barang = new HashMap<>();
//        entry_barang.put(ID_BARANG,sharedPreferences.getString(ID_BARANG,null));
//        entry_barang.put(NAMA_BARANG,sharedPreferences.getString(NAMA_BARANG,null));
//        entry_barang.put(HARGABELI_BARANG,sharedPreferences.getString(HARGABELI_BARANG,null));
//        entry_barang.put(HARGAJUAL_BARANG,sharedPreferences.getString(HARGAJUAL_BARANG,null));
//        entry_barang.put(JUMLAH,sharedPreferences.getString(JUMLAH,null));
//        entry_barang.put(ENTRY_BY,sharedPreferences.getString(ENTRY_BY,null));
//        return  entry_barang;
//
//    }

    public void logoutUser(){
        //clearing all data from shared Preferences
        editor.clear();
        editor.commit();
    }

    public boolean isLogginIN(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }

}
