package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;


public class ApiMain {

	public static void main(String[] args) {
		
		try {
			
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml");
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			con.disconnect();
			JSONObject obj = XML.toJSONObject(sb.toString());
			String pubDate = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getString("pubDate");
			String category = obj.getJSONObject("rss")
								 .getJSONObject("channel")
								 .getJSONObject("item")
								 .getString("category");
			JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
		
			
			List<Map<String, Object>> day = new ArrayList<Map<String, Object>>();
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);		
				Map<String, Object> weather = new HashMap<String, Object>();
				weather.put("온도", data.getInt("temp"));
				weather.put("날씨", data.getString("wfKor"));
				weather.put("시간", data.getInt("hour"));
				day.add(weather);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt"));
			writer.write(pubDate + "\n");
			writer.write(category + "\n");	
			writer.write(day.toString());
			writer.close();
								
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
