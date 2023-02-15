package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		try {
			
			// API주소    봤을 때 밑에 1은 필수 0은 선택
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
			apiURL += "?serviceKey=" + URLEncoder.encode("fj7ayv/XfydOpYCsuw3DdlQ/VfvzsriuCK8LrO3++OJai8PpBQ8LWg6v0it5vwdcrGM1nliz5OSGfCUSEvBCHw==", "UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");

			// URL 객체 생성 (API주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소 접속 
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// GET 방식의 요청임을 처리
			con.setRequestMethod("GET");
			
			// 응답 데이터는 "json"임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");		// charset=UTF-8는 제외가능
			
			// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
			// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요
			// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 이제 API의 응답 데이터는 sb에 저장되어 있다.
			// System.out.println(sb.toString());
			
			// API의 응답 데이터를 분석하기 위해서 JSONObject로 변환한다.
			// json 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
//			JSONObject obj = new JSONObject(sb.toString());
//			JSONObject items = obj.getJSONObject("items");
//			JSONArray itemList = items.getJSONArray("item");
			
			JSONArray itemList = new JSONObject(sb.toString())
									.getJSONObject("items")
									.getJSONArray("item");
			
//			 String occrrncDt;  // 발생월일시 (2019011622)
//	        String occrrncDayCd;  // 발생요일코드 (4)
//	        int dthDnvCnt;  // 사망자수 (0)
//	        int injpsnCnt;  // 부상자수 (1)
			
			// 여러개의 데이터를 하나의 객체나 빈으로 만들어내기 위해서 하는 작업.
			List<Accident> list = new ArrayList<Accident>();
			for(int i = 0; i < itemList.length(); i++) {
				// 응답 데이터에서 필요한 데이터를 분석(파싱)한다.
				JSONObject item = itemList.getJSONObject(i);
				String occrrncDt = item.getString("occrrnc_dt");		// 밑줄을 없애고 다음 문자를 대문자로 바꾼다
				String occrrncDayCd = item.getString("occrrnc_day_cd");
				int dthDnvCnt = item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)로 만든다.
				Accident accident = new Accident();			// accident 클래스에 만들어 두어서 부를 수 있다.
				accident.setOccrrncDt(occrrncDt);			// 요기를 안 만들고 Map으로 만들어도 된다.
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				// 객체를 ArrayList에 저장한다.
				list.add(accident);								// 저장하기.			
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}










