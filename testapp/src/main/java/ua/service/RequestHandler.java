package ua.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler {
//	private static final String USER_AGENT = "Mozilla/5.0";

	public static String sendRequest(String requestMethod, String url, String id, String jsonInputString)
			throws IOException {

		if (id != null) {
			url += "/?id=" + id;
		}
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(requestMethod);
//		con.setRequestProperty("Content-Type", "application/json");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		System.out.println(jsonInputString + "MY JSON");
		if (jsonInputString != null) {
			con.setDoOutput(true);

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("UTF-8");
				os.write(input, 0, input.length);
				os.flush();
				os.close();
			}
		}

		int responseCode = con.getResponseCode();
		System.out.println("Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("Request didnt work");
			return null;
		}

	}
}
