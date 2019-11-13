
package com.cn.starbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

public class ComfirmOrderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.comfirmorder);
		findViewById(R.id.tv_buy_ok).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(ComfirmOrderActivity.this, "付款成功！", 1).show();
				Intent intent = new Intent(ComfirmOrderActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	
}
