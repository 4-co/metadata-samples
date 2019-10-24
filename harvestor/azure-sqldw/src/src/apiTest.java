

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class apiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyGETRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

public static void MyGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://admin:admin@40.127.72.92:21000/api/atlas/v2/entity/bulk");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
    //conection.set
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}

}
