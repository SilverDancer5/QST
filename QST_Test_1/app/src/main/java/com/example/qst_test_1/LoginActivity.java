package com.example.qst_test_1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String adminAccount = "hym";
    String adminPassword = "han123";

    Button loginBtn;//登录按钮
    Button registBtn;//注册按钮

    MyCheckBox rembAccount;
    MyCheckBox rembPassword;

    EditText accountText;
    EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountText = findViewById(R.id.account_Text);

        passText = findViewById(R.id.pass_Text);

        loginBtn = findViewById(R.id.login_Btn);
        loginBtn.setOnClickListener(new loginCheck(){
        });//登录按钮

        registBtn = findViewById(R.id.regist_Btn);//注册按钮
        registBtn.setOnClickListener(onClickListener);

        rembAccount = findViewById(R.id.remb_Account);
        rembAccount.setOnClickListener(this);

        rembPassword = findViewById(R.id.remb_Password);
        rembPassword.setOnClickListener(this);

    }


    //记住账号密码
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.remb_Account:
                if(accountText.getText().length() == 0) {
                    Toast.makeText(this,"请先输入账号", Toast.LENGTH_SHORT).show();
                    rembAccount.setChecked(false);
                } else {
                    Toast.makeText(this,"已经记住账号", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remb_Password:
                if(passText.getText().length() == 0) {
                    Toast.makeText(this,"请先输入密码", Toast.LENGTH_SHORT).show();
                    rembPassword.setChecked(false);
                } else {
                    Toast.makeText(this,"已经记住密码", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }


    }

    //回调
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.i("onKeyDown", "音量减");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.i("onKeyDown", "音量加");
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    //注册提示
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.regist_Btn: {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("暂未完成").setTitle("提示");
                    //
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                           // LoginActivity.this.finish();
                        }
                    });
                    //
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                    break;
                }
                default:
                    break;
            }
        }
    };

    //登录检测
    class loginCheck implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String account = accountText.getText().toString();
            String password = passText.getText().toString();
            if(account.equals(adminAccount) && password.equals(adminPassword)) {
                switch (v.getId()) {
                    case R.id.login_Btn: {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("登录成功").setTitle("提示");
                        //
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                // LoginActivity.this.finish();
                            }
                        });
                        //
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                        break;
                    }
                    default:
                        break;
                }
            } else {
                Toast.makeText(v.getContext(),"登录失败", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
