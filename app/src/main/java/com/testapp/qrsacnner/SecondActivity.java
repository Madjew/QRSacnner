package com.testapp.qrsacnner;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

    public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
        private Button changeTextBtn;
        private TextInputEditText inputText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            initViews();
        }


        @Override
        public void onClick(View view) {
            showAlert();
            hideKeyboard();
        }

        private void showAlert() {
            AlertDialog.Builder builder = new AlertDialog.Builder(com.testapp.qrsacnner.SecondActivity.this);
            builder.setTitle("Alert!")
                    .setMessage(inputText.getEditableText())
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        private void hideKeyboard() {
            if (getCurrentFocus() == null) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) com.testapp.qrsacnner.SecondActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(com.testapp.qrsacnner.SecondActivity.this.getCurrentFocus().getWindowToken(), 0);
            getWindow().getDecorView().clearFocus();
        }
        private void initViews() {
            changeTextBtn = findViewById(R.id.change_text_btn);
            inputText = findViewById(R.id.textInputEditText);
            changeTextBtn.setOnClickListener(this);

        }

    }

