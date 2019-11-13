package com.cn.starbook;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class WelcomeActivity extends Activity {
	private AlphaAnimation anima;
	private View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.welcome);
		
		new Handler().postDelayed(new Runnable() {  //新建一个线程,使得当前界面等待2秒钟
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);  //等待2秒钟,跳转到主界面
				startActivity(intent);
				finish();  //结束当前页面

			}
		}, 2000);
		
		//initData();
	}
	/*private void initData() {
		anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(5000);
		view.startAnimation(anima);
		anima.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				redirectTo();
			}
		});
	}
	
	  //跳转到首页
		private void redirectTo() {
			Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
			startActivity(intent);
			finish();
		}
*/
}
