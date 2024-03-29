package com.example.cadastro.connection;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

import android.util.Log;

import com.example.cadastro.core.Constants;

public class HttpHelper {
   
    public static String request(HttpResponse response){
        String result = "";
        try{
            InputStream in = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder str = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                str.append(line + "\n");
            }
            in.close();
            result = str.toString();
        }catch(Exception ex){
        	Log.d(Constants.TAG, ex.getMessage());
            result = "Error";
        }
        return result.trim();
    }
} 