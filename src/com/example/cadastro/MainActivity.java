package com.example.cadastro;

import java.io.UnsupportedEncodingException;

import com.example.cadastro.connection.Connection;
import com.example.cadastro.core.Constants;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private EditText id;
	private EditText nome;
	private EditText telefone;
	private EditText idade;
	private ProgressDialog dialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		id  = (EditText) findViewById(R.id.etId);
		id.setOnClickListener(this);
		
		nome = (EditText) findViewById(R.id.etNome);
		nome.setOnClickListener(this);
		
		telefone = (EditText) findViewById(R.id.etTel);
		telefone.setOnClickListener(this);
		
		idade = (EditText) findViewById(R.id.etIdade);
		idade.setOnClickListener(this);
		
//		dialog = new ProgressDialog(MainActivity.this);
//		dialog.setMessage("carregando...");
//		dialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btEnviar:
			
			String nome = (String) getText(R.id.etNome);
			
			
			break;

		default:
			break;
		}
		
	}
	
	private class TestConn extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {

			try {
				
				
				//usando get
				//passando parametros pra página da internet
				//String url - Constants.URL + "nome="+ etcoco+"&"+idade="+etnumero+"&seila="+etnome+";
//				String result = Connection.sendRequestGet(Constants.URL);
				
				
//				/-----------------------------------------------/
				
				
//				usando post
				
//				Connection.getPairs.clear();
//				Connection.createParam("nome", etcoco);
//				Connection.createParam("idade", etIdade);
//				Connection.createParam("email", etEmail);
				Connection.createParam("id", R.id.etNome);
//				
				String result = Connection.sendRequestPost(Constants.URL);
				 
				 return result;
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
			dialog.dismiss();

			if (result != null) {
				Log.i(Constants.TAG, result);
			}

			super.onPostExecute(result);
		}
	}

}
