package com.cn.starbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ArrageListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arrage_list);
		
		//********************ListView
		//id
		ListView listview =(ListView) findViewById(R.id.arrageList);
		//图片
		final int []imageId =new int[] {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,
				R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8};
		
		final String []listtitle =new String[]{"将来的你","世界最诡异100个惊悚悬疑","世界上最离奇的侦探推理","故乡",
				"你若盛开，蝴蝶自来","花千骨","做一个说话有香气的女子","这一生都是你的机会"};
		final String []listauthor =new String []{"未来一线","鬼泣*魅","鬼泣*魅","老夫子","蝴蝶","花非花","牛香香","小短腿"};
		final String []listprice =new String []{"￥85","￥81","￥28","￥58","￥80","￥89","￥82","￥88"};
		List<Map<String,Object>> listItems =new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageId.length;i++){
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("imageId",  imageId[i] );
			map.put("listtitle", listtitle[i]);
			map.put("listauthor",listauthor[i]);
			map.put("listprice",listprice[i]);
			listItems.add(map);	
		}
		SimpleAdapter adapter =new SimpleAdapter(this,listItems,
				R.layout.item_detlist,new String[]{"imageId","listtitle","listauthor","listprice"},
				new int[]{R.id.tv_arrage_icon,R.id.tv_arrage_title,
						R.id.tv_arrage_author,R.id.tv_arrage_price});
		 listview.setAdapter(adapter);
		 listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent intent = new Intent(ArrageListActivity.this, ArageListDetailActivity.class);
					intent.putExtra("imageId", imageId[arg2]);
					intent.putExtra("listtitle", listtitle[arg2]);
					intent.putExtra("listauthor", listauthor[arg2]);
					intent.putExtra("listprice", listprice[arg2]);
					startActivity(intent);
					
		}
	});		
		
		//**************
		//按钮，返回操作
		((Button)findViewById(R.id.arr_cx_back)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent inback = new Intent(ArrageListActivity.this,MainActivity.class);
				startActivity(inback);
				finish();//结束本页面
			}
		});;
	}	
}
