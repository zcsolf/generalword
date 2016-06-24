package com.zcsolf.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.otherframejiangjunling.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;




public class ConnectTool {

	private static HttpURLConnection conn;
	private static URL url;
	private static InputStream inputStream;
	private static BufferedReader bufferReader;
	private static String CharSet = "gbk";
	private static String uri = "http://10.0.2.2:8080/AndroidService/";

	public static InputStream getCon(String path) {
		try {
			url = new URL(uri + path);
			conn = (HttpURLConnection) url.openConnection();
			int i = conn.getResponseCode();
			if (i == 200) {
				inputStream = conn.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	public static String getString(String path) {
		String result = null;
		try {
			url = new URL(uri + path);
			conn = (HttpURLConnection) url.openConnection();			
			conn.setDoOutput(true);
			conn.setDoInput(true);			
			conn.setRequestMethod("POST");	
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);			
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();
			if (conn.getResponseCode() == HttpStatus.SC_OK) {
				inputStream = conn.getInputStream();
				bufferReader = new BufferedReader(new InputStreamReader(
						inputStream, CharSet));
				String str = null;
				StringBuffer stringBuffer = new StringBuffer();
				while ((str = bufferReader.readLine()) != null) {
					stringBuffer.append(str + "\n");
				}
				result = stringBuffer.toString().trim();
			} else {
				result = "";
			}
			bufferReader.close();
			inputStream.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getHttpGetString(String path) {
		String result = null;
		try {
			HttpGet httpRequest = new HttpGet(uri + path);			
			HttpClient httpclient = new DefaultHttpClient();		
			HttpResponse httpResponse = httpclient.execute(httpRequest);		
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {				
				result = EntityUtils
						.toString(httpResponse.getEntity(), CharSet);
			} else {
				result = "";
			}
			httpRequest.abort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getHttpPostString(String path,
			Map<String, String> params) {
		String result = null;
		HttpPost httpRequest = new HttpPost(uri + path);		
		List<NameValuePair> nameparams = new ArrayList<NameValuePair>();		
		Set<String> keyset = params.keySet();
		for (Iterator<String> it = keyset.iterator(); it.hasNext();) {
			String key = it.next();
			String value = params.get(key);
			nameparams.add(new BasicNameValuePair(key, value));
		}
		try {			
			HttpEntity httpentity = new UrlEncodedFormEntity(nameparams,
					CharSet);			
			httpRequest.setEntity(httpentity);			
			HttpClient httpclient = new DefaultHttpClient();			
			HttpResponse httpResponse = httpclient.execute(httpRequest);			
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {				
				result = EntityUtils
						.toString(httpResponse.getEntity(), CharSet);
			} else {
				result = "";
			}
			httpRequest.abort();
		} catch (Exception e) {

		}
		return result;
	}
	public static Bitmap getHttpGetBitmap(String path) {
		Bitmap bitmap=null;
		byte image[] = null;
		try {
			HttpGet httpRequest = new HttpGet(uri + path);			
			HttpClient httpclient = new DefaultHttpClient();		
			HttpResponse httpResponse = httpclient.execute(httpRequest);		
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {				
				image = EntityUtils
						.toByteArray(httpResponse.getEntity());
				bitmap=BitmapFactory.decodeByteArray(image, 0, image.length);
			} else {
				bitmap =BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ic_launcher);
			}
			httpRequest.abort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}
