package com.cn.starbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PersonFrag extends Fragment {

	String[] data1 = { "个人信息", "我的地址", "我的钱包", "我的评价", "关于app", "联系客服" }; // 定义文字数据
	String[] data2 = { ">", ">", ">", ">", ">", ">" }; // 定义文字数据
	ArrayList<Map<String, Object>> list; // 定义ArrayList
	Map<String, Object> map;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.person_frag, container, false);
		ListView person_list = (ListView) view.findViewById(R.id.personlist);
		list = new ArrayList<Map<String, Object>>(); // 定义ArrayList集合
		for (int i = 0; i < data1.length; i++) { // 把原始数据放放进map集合里
			map = new HashMap<String, Object>(); // 定义map集合(数组），一个map集合对应ListView的一栏。
			map.put("gn", data1[i]); // 添加数据给map集合
			map.put("zk", data2[i]);
			list.add(map); // 把map集合放进list集合里
		}
		// 调用SimpleAdapter适配器
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), list,
				R.layout.fenlei, // 与数据匹配的布局
				new String[] { "gn", "zk" }, // 字符串数组，里面放参数名。
				new int[] { R.id.tv_person, R.id.tv_icon });
		person_list.setAdapter(adapter);
		
		view.findViewById(R.id.loginLy).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),LoginActivity.class);
				startActivity(intent);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		return view;

	}

}
