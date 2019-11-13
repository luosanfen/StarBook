package com.cn.starbook;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CarFrag extends Fragment implements View.OnClickListener
, ShoppingCartAdapter.CheckInterface, ShoppingCartAdapter.ModifyCountInterface {
	
	  private static final String TAG = "CarFrag";
	    Button btnBack;
	   //全选
	    CheckBox ckAll;
	    //总额
	    TextView tvShowPrice;
	   //结算
	    TextView tvSettlement;
	   //编辑
	    TextView btnEdit;//tv_edit

	    ListView list_shopping_cart;
	    private ShoppingCartAdapter shoppingCartAdapter;
	    private boolean flag = false;
	    private List<ShoppingCartBean> shoppingCartBeanList = new ArrayList<ShoppingCartBean>();
	    private boolean mSelect;
	    private double totalPrice = 0.00;// 购买的商品总价
	    private int totalCount = 0;// 购买的商品总数量
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	View view = inflater.inflate(R.layout.car_frag,container, false);
    	
    	
    	 btnBack = view.findViewById(R.id.car_back);
		 ckAll= (CheckBox) view.findViewById(R.id.ck_all);
		 tvShowPrice= (TextView)view.findViewById(R.id.tv_show_price);
		 tvSettlement= (TextView) view.findViewById(R.id.tv_settlement);
		 btnEdit= (TextView) view.findViewById(R.id.bt_header_right);
		 list_shopping_cart= (ListView) view.findViewById(R.id.list_shopping_cart);
		
		 btnEdit.setOnClickListener(this);
		 ckAll.setOnClickListener(this);
	     tvSettlement.setOnClickListener(this);
		 btnBack.setOnClickListener(this);

    	ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        
        //*********************************
	    
        initData(); //初始化
    	return view;
    }
   private Intent getIntent() {
		// TODO Auto-generated method stub
		return null;
	}
//初始化数据
   protected void initData() {

       for (int i = 0; i < 2; i++) {
           ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
           shoppingCartBean.setShoppingName("Java深入浅出");
           shoppingCartBean.setDressSize(20);
           shoppingCartBean.setId(i);
           shoppingCartBean.setPrice(30);
           shoppingCartBean.setCount(1);
           shoppingCartBean.setImageUrl("https://img.alicdn.com/bao/uploaded/i3/TB1ykKfHpXXXXXHXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
           shoppingCartBeanList.add(shoppingCartBean);
       }
       for (int i = 0; i < 2; i++) {
           ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
           shoppingCartBean.setShoppingName("我就是不想变成你喜欢的那种人");
           shoppingCartBean.setAttribute("作者：岸见一郎");
           shoppingCartBean.setPrice(90);
           shoppingCartBean.setId(i+2);
           shoppingCartBean.setCount(1);
           //网络获取网络图片
           shoppingCartBean.setImageUrl("https://img.alicdn.com/imgextra/i3/1049653664/TB2UPX5fFXXXXXNXpXXXXXXXXXX_!!1049653664.jpg_430x430q90.jpg");
           shoppingCartBeanList.add(shoppingCartBean);
       }
       
           ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
           shoppingCartBean.setShoppingName("一生一世美人骨");
           shoppingCartBean.setAttribute("作者：墨宝非宝");
           shoppingCartBean.setPrice(20);
           shoppingCartBean.setId(6);
           shoppingCartBean.setCount(1);
           shoppingCartBean.setImageUrl("https://img.alicdn.com/imgextra/i3/1049653664/TB2UPX5fFXXXXXNXpXXXXXXXXXX_!!1049653664.jpg_430x430q90.jpg");
           shoppingCartBeanList.add(shoppingCartBean);
       
       shoppingCartAdapter = new ShoppingCartAdapter(getActivity());
       shoppingCartAdapter.setCheckInterface(this);
       shoppingCartAdapter.setModifyCountInterface(this);
       list_shopping_cart.setAdapter(shoppingCartAdapter);
       shoppingCartAdapter.setShoppingCartBeanList(shoppingCartBeanList);
   }
   @Override
   public void onClick(View v) {
       switch (v.getId()) {
           //全选按钮
           case R.id.ck_all:
               if (shoppingCartBeanList.size() != 0) {
                   if (ckAll.isChecked()) {
                       for (int i = 0; i < shoppingCartBeanList.size(); i++) {
                           shoppingCartBeanList.get(i).setChoosed(true);
                       }
                       shoppingCartAdapter.notifyDataSetChanged();
                   } else {
                       for (int i = 0; i < shoppingCartBeanList.size(); i++) {
                           shoppingCartBeanList.get(i).setChoosed(false);
                       }
                       shoppingCartAdapter.notifyDataSetChanged();
                   }
               }
               statistics();
               break;
           case R.id.bt_header_right:
               flag = !flag;
               if (flag) {
                   btnEdit.setText("完成");
                   shoppingCartAdapter.isShow(false);
               } else {
                   btnEdit.setText("编辑");
                   shoppingCartAdapter.isShow(true);
               }
               break;
           case R.id.tv_settlement: //结算
               lementOnder();
               break;
          case R.id.car_back:
              // finish();
               break;
       }
   }

   /**
    * 结算订单、支付
    */
   private void lementOnder() {
   //选中的需要提交的商品清单
       for (ShoppingCartBean bean:shoppingCartBeanList ){
           boolean choosed = bean.isChoosed();
           if (choosed){
               String shoppingName = bean.getShoppingName();
               int count = bean.getCount();
               double price = bean.getPrice();
               int size = bean.getDressSize();
               String attribute = bean.getAttribute();
               int id = bean.getId();
               Log.d(TAG,id+"----id---"+shoppingName+"---"+count+"---"+price+"--size----"+size+"--attr---"+attribute);
           }
       }
       ToastUtil.showL(getActivity(),"总价："+totalPrice);
       //跳转到支付界面
       if(totalPrice != 0.0){
    	   Intent in = new Intent(getActivity(), ComfirmOrderActivity.class);
    	   startActivity(in);
       }
   }
   /**
    * 单选
    * @param position  组元素位置
    * @param isChecked 组元素选中与否
    */
   public void checkGroup(int position, boolean isChecked) {
       shoppingCartBeanList.get(position).setChoosed(isChecked);
       if (isAllCheck())
           ckAll.setChecked(true);
       else
           ckAll.setChecked(false);
       shoppingCartAdapter.notifyDataSetChanged();
       statistics();
   }
   /**
    * 遍历list集合
    * @return
    */
   private boolean isAllCheck() {

       for (ShoppingCartBean group : shoppingCartBeanList) {
           if (!group.isChoosed())
               return false;
       }
       return true;
   }
   /**
    * 统计操作
    * 1.先清空全局计数器<br>
    * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作
    * 3.给底部的textView进行数据填充
    */
   public void statistics() {
       totalCount = 0;
       totalPrice = 0.00;
       for (int i = 0; i < shoppingCartBeanList.size(); i++) {
           ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(i);
           if (shoppingCartBean.isChoosed()) {
               totalCount++;
               totalPrice += shoppingCartBean.getPrice() * shoppingCartBean.getCount();
           }
       }
       tvShowPrice.setText("合计:" + totalPrice);
       tvSettlement.setText("结算(" + totalCount + ")");
   }
   /**
    * 增加
    * @param position      组元素位置
    * @param showCountView 用于展示变化后数量的View
    * @param isChecked     子元素选中与否
    */
   public void doIncrease(int position, View showCountView, boolean isChecked) {
       ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
       int currentCount = shoppingCartBean.getCount();
       currentCount++;
       shoppingCartBean.setCount(currentCount);
       ((TextView) showCountView).setText(currentCount + "");
       shoppingCartAdapter.notifyDataSetChanged();
       statistics();
   }
   /**
    * 删减
    *
    * @param position      组元素位置
    * @param showCountView 用于展示变化后数量的View
    * @param isChecked     子元素选中与否
    */
   public void doDecrease(int position, View showCountView, boolean isChecked) {
       ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
       int currentCount = shoppingCartBean.getCount();
       if (currentCount == 1) {
           return;
       }
       currentCount--;
       shoppingCartBean.setCount(currentCount);
       ((TextView) showCountView).setText(currentCount + "");
       shoppingCartAdapter.notifyDataSetChanged();
       statistics();
   }
   /**
    * 删除
    *
    * @param position
    */
   public void childDelete(int position) {
       shoppingCartBeanList.remove(position);
       shoppingCartAdapter.notifyDataSetChanged();
       statistics();
   }
    
}
