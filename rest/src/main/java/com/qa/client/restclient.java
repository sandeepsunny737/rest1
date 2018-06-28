package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class restclient {
	
	//1.Get method
	public void get(String Url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(Url);
		CloseableHttpResponse CloseableHttpResponse=httpclient.execute(httpget);
		int statuscode=CloseableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		String responseString=EntityUtils.toString(CloseableHttpResponse.getEntity(),"UTF-8");
		JSONObject responsejson=new JSONObject(responseString);
		System.out.println(responsejson);
		
		Header[] headersArray=CloseableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();	
				for(Header header : headersArray){
					allHeaders.put(header.getName(), header.getValue());
				}	
		System.out.println("Headers Array-->"+allHeaders);
		System.out.println("Headers asd Array-->"+allHeaders);
		System.out.println("Headers Array-->"+allHeaders);
		System.out.println("Headers asd Array-->"+allHeaders);
	}
	

}
