package com.cn.starbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText mUserName;
	private EditText mUserPwd;
	private Button mLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		mUserName = (EditText)findViewById(R.id.txtUserName);
		mUserPwd = (EditText)findViewById(R.id.txtPassword);
		mLogin  = (Button)findViewById(R.id.btnLogin);
		mLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mUserName.getText().toString().equals("123")&& mUserPwd.getText().toString().equals("123")){
					Toast.makeText(LoginActivity.this,"登录成功", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(LoginActivity.this,MainActivity.class); 
					startActivity(intent);
					finish();  //结束当前页面
				}else{
					Toast.makeText(LoginActivity.this,"用户或密码错误！", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		final TextView txtView2 = (TextView)findViewById(R.id.textView2);
		txtView2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
}
