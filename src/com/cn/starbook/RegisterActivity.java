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
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private EditText rEmail;
	private EditText rUserName;
	private EditText rUserPwd;
	private EditText rRUserPwd;
	private Button btRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		rEmail = (EditText)findViewById(R.id.email);
		rUserName = (EditText)findViewById(R.id.username);
		rUserPwd = (EditText)findViewById(R.id.password);
		rRUserPwd = (EditText)findViewById(R.id.confirm_password);
		btRegister  = (Button)findViewById(R.id.btnRegister);
		btRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(rUserName.getText().toString().equals("xiaoming")&& rUserPwd.getText().toString().equals("abc")){
				if(rEmail.getText().toString().equals("")||rUserName.getText().toString().equals("")|| rUserPwd.getText().toString().equals("")||rRUserPwd.getText().toString().equals("")){
					Toast.makeText(RegisterActivity.this,"请将注册信息填写完整", Toast.LENGTH_LONG).show();
					
				}else{
					Toast.makeText(RegisterActivity.this,"注册成功！返回登录", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(RegisterActivity.this,LoginActivity.class); 
					startActivity(intent);
					finish();  //结束当前页面
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
