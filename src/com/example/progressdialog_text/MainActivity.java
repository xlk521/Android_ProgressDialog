package com.example.progressdialog_text;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity implements OnClickListener{

	/**
	 * 
	 * 两个进度条的显示方式
	 * 
	 * 其中圆形的进度条中涉及到   【  按钮 】   的设置与功能
	 * 
	 * 条形的进度条中采用的是开启   【  线程  】 +  【sleep延迟】的方式
	 * 
	 * */
	private Button btn1 = null;
	private Button btn2 = null;
	private ProgressDialog pd = null;
	private int count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			pd = new ProgressDialog(this);
			//设置进度条为圆形旋转风格
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// 设置标题
			pd.setTitle("进度条的标题");
			//提示信息
			pd.setMessage("次出现是提示信息");
			//设置标题图标
			pd.setIcon(R.drawable.ic_launcher);
			//进度条是否明确
			pd.setIndeterminate(false);
			//是否可以响应退回按钮
			pd.setCancelable(true);
			//设置dialog的按钮响应
			pd.setButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			pd.show();
			break;
		case R.id.button2:
			pd = new ProgressDialog(this);
			//设置进度条为圆形旋转风格
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// 设置标题
			pd.setTitle("进度条的标题");
			//提示信息
			pd.setMessage("次出现是提示信息");
			//设置标题图标
			pd.setIcon(R.drawable.ic_launcher);
			//进度条的进度
			pd.setProgress(100);
			//进度条是否明确
			pd.setIndeterminate(false);
			//是否可以响应退回按钮
			pd.setCancelable(true);
			pd.show();
			//由线程控制进度
			new Thread(){
				public void run(){
					try {
						while (count<=100) {
							pd.setProgress(count++);
							Thread.sleep(100);
						}
						pd.cancel();
					} catch (InterruptedException e) {
						pd.cancel();
					}
				}
			}.start();
			break;
		default:
			break;
		}
	}
}
