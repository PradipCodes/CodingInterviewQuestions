import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Result {

    /*
     * Complete the 'healthCheckup' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER lowerlimit
     * 2. INTEGER upperlimit
     * API URL: https://jsonmock.hackerrank.com/api/medical_records?page={page_no}
     */

    public static int healthCheckup(int lowerlimit, int upperlimit) throws IOException, ParseException {
        int totalRecords = 0;
        int page = 1;
        boolean morePages = true;
        List<JSONObject> records = new ArrayList<>();

        while (morePages) {
            String url = "https://jsonmock.hackerrank.com/api/medical_records?page=" + page;
            String jsonString = getJSONString(url);
            JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
            JSONArray data = (JSONArray) json.get("data");

            for (Object record : data) {
                JSONObject recordJSON = (JSONObject) record;
                JSONObject vitals = (JSONObject) recordJSON.get("vitals");
                int bloodPressureDiastole = Integer.parseInt(vitals.get("bloodPressureDiastole").toString());
                if (bloodPressureDiastole >= lowerlimit && bloodPressureDiastole <= upperlimit) {
                    totalRecords++;
                }
            }

            if (page == Integer.parseInt(json.get("total_pages").toString())) {
                morePages = false;
            }
            page++;
        }
        return totalRecords;
    }

    public static String getJSONString(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int lowerlimit = Integer.parseInt(bufferedReader.readLine().trim());

        int upperlimit = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.healthCheckup(lowerlimit, upperlimit);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
