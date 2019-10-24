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

public class QnsRestService {

	public static HashMap<String, String> typeNameFields = new HashMap<String, String>();

	private static void getFun(String typeName) {
		try {

			URL url = new URL(Constants.QNSSERIVCE + "&typeName=" + typeName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String jsonStr = "";
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				jsonStr = jsonStr + output;
			}
			conn.disconnect();

			JSONObject json = new JSONObject(jsonStr);
			// print object
			System.out.println("***********" + typeName + "***********");
			// get value for a key
			JSONArray arr = json.getJSONArray("input_parameters");
			String param_name = "";
			for (int i = 0; i < arr.length(); i++) {
				param_name = param_name + arr.getJSONObject(i).getString("param_name") + ",";

			}
			param_name = param_name.substring(0, param_name.lastIndexOf(','));
			System.out.println(param_name);
			typeNameFields.put(typeName, param_name);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// public static void postFunc(String typeName,String[] typeParameters)
	public JSONObject postFunc(String typeName, String inputBody) {

		try {

			URL url = new URL(Constants.QNSSERIVCE + "&typeName=" + typeName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			String input = inputBody;

			// System.out.println(input);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			System.out.println("Inside Qns - > postFunc - > inputBody- >" + input);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String jsonStr = "";
			String output;
			// System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				jsonStr = jsonStr + output;
			}
			conn.disconnect();

			JSONObject json = new JSONObject(jsonStr);
			return json;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}

}
