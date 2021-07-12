package com.anz.tokoapps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anz.tokoapps.R;
import com.anz.tokoapps.rest.ApiClient;
import com.anz.tokoapps.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity2 extends AppCompatActivity {

    @BindView(R.id.edt_username)
    EditText etUsername;

    @BindView(R.id.edt_password)
    EditText etPassword;

    @BindView(R.id.edt_namalengkap)
    EditText etNama;

    @BindView(R.id.edt_email)
    EditText etEmail;

    @BindView(R.id.edt_alamat)
    EditText etAlamat;

    @BindView(R.id.edt_jk)
    EditText etJenisKelamin;

    @BindView(R.id.btn_create)
    Button btnCreate;

    @BindView(R.id.tvsigin)
    TextView tvsigin;

    ApiInterface apiService;
    ProgressDialog pd;

    private static final String TAG = RegisterActivity2.class.getSimpleName();


    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();

            }
        });

        tvsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity2.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }

    public void signup() {
        Log.d(TAG,"Menjalankan method Signup");
        pd = ProgressDialog.show(this,null,"Sedang mendaftarkan account",true,false);
        String strUsername = etUsername.getText().toString();
        String strPassword = etPassword.getText().toString();
        String strNamaLengkap = etNama.getText().toString();
        String strEmail = etEmail.getText().toString();
        String strAlamat = etAlamat.getText().toString();
        String strJenisKelamin = etJenisKelamin.getText().toString();

        Log.d(TAG,"mendapatkan data dari edit text");

        apiService.signup(strUsername,strPassword,strNamaLengkap,strEmail,strAlamat,strJenisKelamin).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"berhasil memanggil api");
                if (response.isSuccessful()){
                    pd.dismiss();
                    Log.d(TAG,"succes mendapatkan api");
                    Intent i = new Intent(RegisterActivity2.this,LoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                pd.dismiss();
                Log.e(TAG,t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(RegisterActivity2.this,LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }
}