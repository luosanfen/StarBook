package com.cn.starbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class HotFrag extends Fragment implements OnClickListener{
	LinearLayout hot_1,hot_2,hot_3;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.hot_frag, container, false);
		//初始化**************
		hot_1 = view.findViewById(R.id.hot_1);
		hot_2 = view.findViewById(R.id.hot_2);
	    hot_3 = view.findViewById(R.id.hot_3);
	    initHotEvent();
		//******************
	    
	    
	    
		return view;
		
	}
	public void initHotEvent() {
		// TODO Auto-generated method stub
		hot_1.setOnClickListener(this);
		hot_2.setOnClickListener(this);
		hot_3.setOnClickListener(this);
	}
	 public void onClick(View v){
			switch (v.getId())
			{
			case R.id.hot_1:
				tiaoFF();
				break;
			case R.id.hot_2:
				tiaoFF();
				break;
			case R.id.hot_3:
				tiaoFF();
				break;
			default:
				break;
			}
		}
	   //跳转到ListView
        public void tiaoFF(){
	    Intent intent = new Intent(getActivity(),BookDetailActivity.class);
		startActivity(intent);
      }
}
