package com.cn.starbook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.view.ViewPager.OnPageChangeListener;
public class HomeFrag extends Fragment implements OnClickListener{
	LinearLayout imag; //
	private ViewPager viewPager; // android-support-v4中的滑动组件  
    private List<ImageView> imageViews; // 滑动的图片集合  
    private String[] titles; // 图片标题  
    private int[] imageResId; // 图片ID  
    private List<View> dots; // 图片标题正文的那些点  
    private TextView tv_title;  
    private int currentItem = 0; // 当前图片的索引号  
    private ScheduledExecutorService scheduledExecutorService;  
    //五个图标layoutId
    LinearLayout chagnxiaoLy,tejiaLy,xinshuLy,fenleiLy,paihangLy;
    
    // 切换当前显示的图片  
    private Handler handler = new Handler() {  
        public void handleMessage(android.os.Message msg) {  
            viewPager.setCurrentItem(currentItem);// 切换当前显示的图片  
        };  
    };  
    
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.home_frag, container, false);
		
		//五个图片初始化**********
		 chagnxiaoLy = (LinearLayout)view.findViewById(R.id.chagnxiaoLy);
		 tejiaLy = (LinearLayout)view.findViewById(R.id.tejiaLy);
		 xinshuLy = (LinearLayout)view.findViewById(R.id.xinshuLy);
		 fenleiLy = (LinearLayout)view.findViewById(R.id.fenleiLy);
		 paihangLy = (LinearLayout)view.findViewById(R.id.paihangLy);
		initEvent();
		//*****************
		
		//获取小编推荐的第一本书的ID，点击跳转到另一个页面************
		//跳转到书的详情页
		imag = (LinearLayout) view.findViewById(R.id.fristLy);
		imag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getActivity(),BookDetailActivity.class);
				startActivity(in);
			}
		});
		//******************
		
		//广告轮播图*******************
		 imageResId = new int[] { R.drawable.banner, R.drawable.banner2, R.drawable.banner3, R.drawable.banner2, R.drawable.banner3 };  
	        titles = new String[imageResId.length];  
	        titles[0] = "多读书，读好书，好读书";  
	        titles[1] = "扑树又回来啦！再读经典老书与之共鸣";  
	        titles[2] = "揭秘人类历史";  
	        titles[3] = "没钱就多读书";  
	        titles[4] = "读书使人进步";  
	  
	        imageViews = new ArrayList<ImageView>();  
	  
	        // 初始化图片资源  
	        for (int i = 0; i < imageResId.length; i++) {  
	            ImageView imageView = new ImageView(getActivity());  
	            imageView.setImageResource(imageResId[i]);  
	            imageView.setScaleType(ScaleType.CENTER_CROP);  
	            imageViews.add(imageView);  
	        }  
	          
	        dots = new ArrayList<View>();  
	        dots.add(view.findViewById(R.id.v_dot0));  
	        dots.add(view.findViewById(R.id.v_dot1));  
	        dots.add(view.findViewById(R.id.v_dot2));  
	        dots.add(view.findViewById(R.id.v_dot3));  
	        dots.add(view.findViewById(R.id.v_dot4));  
	  
	        tv_title = (TextView)view.findViewById(R.id.tv_title);  
	        tv_title.setText(titles[0]);//  
	  
	        viewPager = (ViewPager)view.findViewById(R.id.vp);  
	        viewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器  
	        // 设置一个监听器，当ViewPager中的页面改变时调用  
	        viewPager.setOnPageChangeListener(new MyPageChangeListener());         
		//****************************
	        
	        
		return view;
		
	}
	//图片 线程切换
	 public class ScrollTask implements Runnable {  
	      
         public void run() {  
             synchronized (viewPager) {  
                 System.out.println("currentItem: " + currentItem);  
                 currentItem = (currentItem + 1) % imageViews.size();  
                 handler.obtainMessage().sendToTarget(); // 通过Handler切换图片  
             }  
         }  
   
     } 
	 //开始轮播
	  @Override  
     public void onStart() {  
          scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();  
          // 当Activity显示出来后，每两秒钟切换一次图片显示  
          scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);  
          super.onStart();  
      }  
	  //停止切换
      @Override  
     public void onStop() {  
          // 当Activity不可见的时候停止切换  
          scheduledExecutorService.shutdown();  
          super.onStop();  
      }  
     //图片、ID 
	 public class MyPageChangeListener implements OnPageChangeListener {  
         private int oldPosition = 0;  
   
         /** 
          * This method will be invoked when a new page becomes selected. 
          * position: Position index of the new selected page. 
          */  
         public void onPageSelected(int position) {  
             currentItem = position;  
             tv_title.setText(titles[position]);  
             dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);  
             dots.get(position).setBackgroundResource(R.drawable.dot_focused);  
             oldPosition = position;  
         }  
   
         public void onPageScrollStateChanged(int arg0) {  
   
         }  
   
         public void onPageScrolled(int arg0, float arg1, int arg2) {  
   
         }  
     }  
	 //图片、适配
	 public class MyAdapter extends PagerAdapter {  
	      
         @Override  
         public int getCount() {  
             return imageResId.length;  
         }  
   
         @Override  
         public Object instantiateItem(View arg0, int arg1) {  
             ((ViewPager) arg0).addView(imageViews.get(arg1));  
             return imageViews.get(arg1);  
         }  
   
         @Override  
         public void destroyItem(View arg0, int arg1, Object arg2) {  
             ((ViewPager) arg0).removeView((View) arg2);  
         }  
   
         @Override  
         public boolean isViewFromObject(View arg0, Object arg1) {  
             return arg0 == arg1;  
         }  
   
         @Override  
         public void restoreState(Parcelable arg0, ClassLoader arg1) {  
   
         }  
   
         @Override  
         public Parcelable saveState() {  
             return null;  
         }  
   
         @Override  
         public void startUpdate(View arg0) {  
   
         }  
   
         @Override  
         public void finishUpdate(View arg0) {  
   
         }  
     }
	
	 //声明点击事件
	 public void initEvent(){
		chagnxiaoLy.setOnClickListener(this);
		tejiaLy.setOnClickListener(this);
		xinshuLy.setOnClickListener(this);
		fenleiLy.setOnClickListener(this);
		paihangLy.setOnClickListener(this);
	 }
		
	 public void onClick(View v){
			switch (v.getId())
			{
			case R.id.chagnxiaoLy:
				tiaoFF();
				break;
			case R.id.tejiaLy:
				tiaoFF();
				break;
			case R.id.xinshuLy:
				tiaoFF();
				break;
			case R.id.fenleiLy:
				tiaoFF();
				break;
			case R.id.paihangLy:
				tiaoFF();
				break;
			default:
				break;
			}
		}
	//跳转到ListView
   public void tiaoFF(){
	   Intent intent = new Intent(getActivity(),ArrageListActivity.class);
		startActivity(intent);
   }
	 

}
