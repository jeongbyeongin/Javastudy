package api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiMain1 {

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

            // 응답데이터 확인(XML) 확인
             System.out.println(sb.toString());

            // 응답데이터(XML)를 JSON데이터로 변환하기
            JSONObject obj = XML.toJSONObject(sb.toString());
             System.out.println(obj);

            // (제일 바깥쪽에있는)pubDate 조회  // 2023년 02월 13일 (월)요일 20:00
            String pubDate = obj.getJSONObject("rss")
                    .getJSONObject("channel")
                    .getString("pubDate");
            System.out.println(pubDate);

            // category 조회   //  서울특별시 금천구 가산동
            String category = obj.getJSONObject("rss")
                    .getJSONObject("channel")
                    .getJSONObject("item")
                    .getString("category");
            System.out.println(category);
            // data 속성에 저장된 날씨 배열 가져오기      // 포스트 맨 을 보고 ex ) rss안에 channel이 있고 channel안에 item이 있고 ...등
            JSONArray dataList = obj.getJSONObject("rss")
                    .getJSONObject("channel")
                    .getJSONObject("item")
                    .getJSONObject("description")
                    .getJSONObject("body")
                    .getJSONArray("data");

            List<Object> list = new ArrayList<>();
            // 순회
            for(int i = 0; i < dataList.length(); i++) {
                JSONObject data = dataList.getJSONObject(i);      // 배열요소 한개를 가져오고

//=1111111111111111111111111111111111111111111111111111111111111111111111111111==                
                
                int temp = data.getInt("temp");
                String wfKor = data.getString("wfKor");
                int hour = data.getInt("hour");
// list에 담기 쉽게 변수에 데이터를 저장함                

//=2222222222222222222222222222222222222222222222222222222222222222222222222==                

                // 파일에 누적될 수 있게 만들기.
                System.out.println(data.getInt("temp"));    // 온도
                System.out.println(data.getString("wfKor")); // 날씨      위에 출력한 값에서 보고 타입을 확인한다.
                System.out.println(data.getInt("hour"));    // 시간

//=1111111111111111111111111111111111111111111111111111111111111111111111111111== 

                list.add(temp);
                list.add(wfKor);
                list.add(hour);
                System.out.println(list);
// 온도, 날씨, 시간 정보를 list에 하나씩 담는다.
// list = [0, 맑음, 3, -2, 맑음, 6, -1, 맑음, 9, 2, 맑음, 12, 5, 맑음, 15, 3, 맑음, 18, 1, 맑음, 21, 0, 구름 많음, 24, -1,
//        구름 많음, 3, -1, 흐림, 6, 0, 흐림, 9, 4, 흐림, 12, 6, 구름 많음, 15, 4, 구름 많음, 18, 2, 구름 많음, 21, 1, 맑음,24]                

//=2222222222222222222222222222222222222222222222222222222222222222222222222==            
            }

            // 결과 파일 만들기      // 경로 지정 안해주면 프로젝트에 생긴다.
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/woomin/Documents/storage/weather.txt"));
            writer.write(pubDate + "\n");
            writer.write(category + "\n");
//=1111111111111111111111111111111111111111111111111111111111111111111111111111== 
            for(int i=0; i<list.size(); i++){
                writer.write(list.get(i).toString());
            }
            writer.close();
// list에 담긴 요소를 하나씩 꺼내서 메모장에 작성.
//=2222222222222222222222222222222222222222222222222222222222222222222222222==            
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}