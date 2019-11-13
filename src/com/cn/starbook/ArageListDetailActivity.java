package com.cn.starbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArageListDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arage_list_detail);
		
		Intent intent = getIntent();
		int imageId = intent.getIntExtra("imageId",0);
		String listtitle = intent.getStringExtra("listtitle");
		String listauthor = intent.getStringExtra("listauthor");
		String listprice = intent.getStringExtra("listprice");
		final ImageView bookImg =  findViewById(R.id.arrbookImg);
		final TextView bookName = (TextView) findViewById(R.id.arrbookname);
		final TextView bookAuthor = (TextView) findViewById(R.id.arrauther);
		final TextView bookPrice = (TextView) findViewById(R.id.arrprice);
		bookImg.setBackgroundResource(imageId);
		bookName.setText(listtitle);
		bookAuthor.setText(listauthor);
	    bookPrice.setText(listprice);
	   
	    //购买
       findViewById(R.id.arrbuy).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent in = new Intent(ArageListDetailActivity.this, ComfirmOrderActivity.class);
		    	  startActivity(in);
		    	  finish();
			}
		});
       //添加购物车
       findViewById(R.id.arrcart).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(ArageListDetailActivity.this, "已添加购物车", 0).show();
				Intent in = new Intent(ArageListDetailActivity.this, ArrageListActivity.class);
		    	startActivity(in);
			}
		});
	    //结束本页面
		findViewById(R.id.arrdetail_back).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	
}
