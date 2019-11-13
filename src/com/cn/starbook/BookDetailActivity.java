package com.cn.starbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		
		//点击返回首页
		TextView back = findViewById(R.id.detail_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			/*Intent intent = new Intent(BookDetailActivity.this,MainActivity.class);
			startActivity(intent);*/
		    finish();
			}
		});
		//点击跳转到购物车页面
		//Button addcar = findViewById(R.id.addcar);
		findViewById(R.id.addcar).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Toast.makeText(BookDetailActivity.this, "已添加购物车啦", 1).show();
			}
		});
		
	}
	
	

	
}
