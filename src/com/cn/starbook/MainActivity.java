package com.cn.starbook;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener{
	
	//定义变量名
	private LinearLayout mTabHome,mTabHot,mTabCar,mTabPerson;
	private ImageButton mImgHome,mImgHot,mImgCar,mImgPerson;
	private Fragment mTab01,mTab02,mTab03,mTab04;
	private TextView home_tv,hot_tv,car_tv,person_tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//表示没有标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		//menu();
		initView();
		initEvent(); //初始化
		setSelect(0); //赋值选择首页
	}
 
	 //声明点击事件
	public void initEvent(){
		mTabHome.setOnClickListener(this);
		mTabHot.setOnClickListener(this);
		mTabCar.setOnClickListener(this);
		mTabPerson.setOnClickListener(this);
	}
	public void initView(){
		//获取底部各个的线性布局的ID
		mTabHome = (LinearLayout) findViewById(R.id.id_tab_home);
		mTabHot = (LinearLayout) findViewById(R.id.id_tab_hot);
		mTabCar = (LinearLayout) findViewById(R.id.id_tab_car);
		mTabPerson = (LinearLayout) findViewById(R.id.id_tab_person);
		//获取底部图片的Id
		mImgHome = (ImageButton) findViewById(R.id.id_tab_xinwen_img);
		mImgHot = (ImageButton) findViewById(R.id.id_tab_focus_img);
		mImgCar = (ImageButton) findViewById(R.id.id_tab_picture_img);
		mImgPerson = (ImageButton) findViewById(R.id.id_tab_person_img);
		
		//获取底部文本的Id
		home_tv = (TextView) findViewById(R.id.id_tv_home);
		hot_tv = (TextView) findViewById(R.id.id_tv_hot);
		car_tv = (TextView) findViewById(R.id.id_tv_car);
		person_tv = (TextView) findViewById(R.id.id_tv_person);
	}
	
	//选择事件
	private void setSelect(int i){
		
		FragmentManager fm = getSupportFragmentManager();
		//转变
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		// 把图片设置为亮的
		// 设置内容区域
		switch (i){
		case 0:
			if (mTab01 == null)
			{
				mTab01 = new HomeFrag();
				transaction.add(R.id.id_content, mTab01);
			} else
			{
				transaction.show(mTab01);
			}
			mImgHome.setImageResource(R.drawable.home_c);	
			home_tv.setTextColor(getResources().getColor(R.color.tv_press));
			break;
		case 1:
			if (mTab02 == null)
			{
				mTab02 = new HotFrag();
				transaction.add(R.id.id_content, mTab02);
			} else
			{
				transaction.show(mTab02);				
			}
			mImgHot.setImageResource(R.drawable.hot_c);
		    hot_tv.setTextColor(getResources().getColor(R.color.tv_press));
			break;
		case 2:
			if (mTab03 == null)
			{
				mTab03 = new CarFrag();
				transaction.add(R.id.id_content, mTab03);
			} else
			{
				transaction.show(mTab03);
			}
			mImgCar.setImageResource(R.drawable.cart_c);
			car_tv.setTextColor(getResources().getColor(R.color.tv_press));
			break;
		case 3:
			if (mTab04 == null)
			{
				mTab04 = new PersonFrag();
				transaction.add(R.id.id_content, mTab04);
			} else
			{
				transaction.show(mTab04);
			}
			mImgPerson.setImageResource(R.drawable.person_img2);
			person_tv.setTextColor(getResources().getColor(R.color.tv_press));
			break;

		default:
			break;
		}

		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction)
	{
		if (mTab01 != null)
		{
			transaction.hide(mTab01);
		}
		if (mTab02 != null)
		{
			transaction.hide(mTab02);
		}
		if (mTab03 != null)
		{
			transaction.hide(mTab03);
		}
		if (mTab04 != null)
		{
			transaction.hide(mTab04);
		}
	}
    
	//点击事件
	@Override
	public void onClick(View v)
	{
		resetImgs();
		switch (v.getId())
		{
		case R.id.id_tab_home:
			setSelect(0);
			break;
		case R.id.id_tab_hot:
			setSelect(1);
			break;
		case R.id.id_tab_car:
			setSelect(2);
			break;
		case R.id.id_tab_person:
			setSelect(3);
			break;

		default:
			break;
		}
	}

	/**
	 * 切换图片至暗色
	 * 表示未选中
	 */
	private void resetImgs(){
		//设置为灰色图片
		mImgHome.setImageResource(R.drawable.home);
		mImgHot.setImageResource(R.drawable.hot);
		mImgCar.setImageResource(R.drawable.cart);
		mImgPerson.setImageResource(R.drawable.person_img);
		
		//文字为灰色
		home_tv.setTextColor(getResources().getColor(R.color.tv_normal));
		hot_tv.setTextColor(getResources().getColor(R.color.tv_normal));
		car_tv.setTextColor(getResources().getColor(R.color.tv_normal));
		person_tv.setTextColor(getResources().getColor(R.color.tv_normal));
	}
  
	

}
