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
	 * ��������������ʾ��ʽ
	 * 
	 * ����Բ�εĽ��������漰��   ��  ��ť ��   �������빦��
	 * 
	 * ���εĽ������в��õ��ǿ���   ��  �߳�  �� +  ��sleep�ӳ١��ķ�ʽ
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
			//���ý�����ΪԲ����ת���
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// ���ñ���
			pd.setTitle("�������ı���");
			//��ʾ��Ϣ
			pd.setMessage("�γ�������ʾ��Ϣ");
			//���ñ���ͼ��
			pd.setIcon(R.drawable.ic_launcher);
			//�������Ƿ���ȷ
			pd.setIndeterminate(false);
			//�Ƿ������Ӧ�˻ذ�ť
			pd.setCancelable(true);
			//����dialog�İ�ť��Ӧ
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
			//���ý�����ΪԲ����ת���
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// ���ñ���
			pd.setTitle("�������ı���");
			//��ʾ��Ϣ
			pd.setMessage("�γ�������ʾ��Ϣ");
			//���ñ���ͼ��
			pd.setIcon(R.drawable.ic_launcher);
			//�������Ľ���
			pd.setProgress(100);
			//�������Ƿ���ȷ
			pd.setIndeterminate(false);
			//�Ƿ������Ӧ�˻ذ�ť
			pd.setCancelable(true);
			pd.show();
			//���߳̿��ƽ���
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
