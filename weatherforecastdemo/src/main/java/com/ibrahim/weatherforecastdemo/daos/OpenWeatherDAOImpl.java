package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.WeatherData;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Repository
public class OpenWeatherDAOImpl implements OpenWeatherDAO {
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${isInFahrenheit}")
    private boolean isInFahrenheit;
    @Value("${API_URL}")
    private String API_URL;

    @Override
    public WeatherData getTemperatureByCityId(String cityName) {
        int status = 0;
        int temperature = 0;
        String queryTime = null;
        String requestURL = API_URL + API_KEY + "&query=" + cityName.replace(" ", "%20");
        URL url;
        HttpURLConnection con = null;
        try {
            url = new URL(requestURL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            status = con.getResponseCode();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String tmp;
            StringBuilder sb = new StringBuilder();
            while((tmp = br.readLine()) != null){
                sb.append(tmp);
            }
            br.close();
            JSONObject res = new JSONObject(sb.toString());
            temperature = res.getJSONObject("current").getInt("temperature");
            queryTime = res.getJSONObject("location").getString("localtime");
            System.out.println(status);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        } finally {
            con.disconnect();
        }
        return new WeatherData(queryTime, temperature, status == 200);
    }
}
