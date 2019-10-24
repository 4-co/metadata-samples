package com.ms.cse.harvestor.dwh.service.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ms.cse.harvestor.dwh.conf.Constants;

public class JSONGeneratorRestService {

	
		public String postFunc(String inputBody) {

		try {

			URL url = new URL(Constants.JSONGENERATORSERIVCE);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			String input = inputBody;

			//System.out.println(input);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			System.out.println("Inside JSONGeneratorRestService - > postFunc - > inputBody- >" );
			System.out.println(input);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String jsonStr = "";
			String output;
			// System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				jsonStr = jsonStr + output;
			}
			conn.disconnect();

			JSONObject json = new JSONObject(jsonStr);
			//return json;
			return jsonStr;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}

}
