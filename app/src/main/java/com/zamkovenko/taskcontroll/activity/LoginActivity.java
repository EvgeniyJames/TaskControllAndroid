package com.zamkovenko.taskcontroll.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.manager.AccountManager;
import com.zamkovenko.taskcontroll.model.Account;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class LoginActivity extends Activity {

    @BindView(R.id.edit_text_login)
    EditText editTextLogin;

    @BindView(R.id.edit_text_password)
    EditText editTextPassword;

    @BindView(R.id.txt_error)
    TextView textViewErrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void login(View w){
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

//        AccountManager.GetInstance().SetAccount(new Account(login, password));
        new LoginAsyncTask().execute();
    }

    class LoginAsyncTask extends AsyncTask<Void, Void, Void> {

        String login;
        String password;

        String error;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            login = editTextLogin.getText().toString();
            password = editTextPassword.getText().toString();

            error = "";

            textViewErrors.setVisibility(View.GONE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            HttpAuthentication authHeader = new HttpBasicAuthentication(login, password);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAuthorization(authHeader);
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            try{
                String url = "http://192.168.176.53:8080/";
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), String.class);
                AccountManager.GetInstance().SetToken(requestHeaders.get("Authorization").get(0));
                return null;

            }catch (HttpClientErrorException | ResourceAccessException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
                error = e.getLocalizedMessage();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (!error.equals("")) {
                textViewErrors.setText(error);
                textViewErrors.setVisibility(View.VISIBLE);
            } else {
                AccountManager.GetInstance().SetAccount(new Account(login, password));
                startActivity(new Intent(LoginActivity.this, ContentActivity.class));
            }
        }
    }

}
