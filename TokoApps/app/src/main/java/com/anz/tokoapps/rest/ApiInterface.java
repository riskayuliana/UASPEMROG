package com.anz.tokoapps.rest;


import com.anz.tokoapps.response.ResponseBarang;
import com.anz.tokoapps.response.ResponseLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(
      @Field("username") String username,
      @Field("password") String password
    );

    @FormUrlEncoded
    @POST("signup.php")
    Call<ResponseBody> signup(
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama_lengkap") String namalengkap,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("jenis_kelamin") String jeniskelamin
    );

    @FormUrlEncoded
    @POST("entrybarang.php")
    Call<ResponseBarang> entry_barang(
            @Field("nama_barang") String namabarang,
            @Field("hargabeli_barang") String hargabelibarang,
            @Field("hargajual_barang") String hargajualbarang,
            @Field("jumlah") String jumlah,
            @Field("entry_by") String entryby
    );

    @GET("lihatbarang.php")
    Call<ResponseBarang> ardLihatBarang();
}
