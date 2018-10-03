/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilesh.json.handler.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author nilesh
 */
public class DestinationResponseParser {
    
      public Destination getDestinationAdderssDetails(String dest){
      String st=getDestinationLocation(dest);
      if(st!=null)return parseResponse(st);
      else return null;
      }
     public String getDestinationLocation(String addess) {
        StringBuilder sb = new StringBuilder();
        String http = "https://maps.googleapis.com/maps/api/geocode/json?address="+addess+"&key=AIzaSyAVe5EMniZnP67zXNc7tcp_PL71OiVcIKw";
        System.out.println("Invoking URL :: "+http);
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
           /* urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            urlConnection.connect();*/
            int HttpResult = urlConnection.getResponseCode();
            System.out.println("HttpResult  :: " + HttpResult);
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                System.out.println("Url Connected HTTP Status :: " + HttpResult);
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                System.out.println("Output From Url :: " + sb.toString());
            } else {
                System.out.println("ResponseMessage ::  " + urlConnection.getResponseMessage());
            }
        } catch (MalformedURLException e) {
            System.out.println("Exception :: "+e);
            //e.printStackTrace();  
        } catch (IOException e) {
             System.out.println("Exception :: "+e);
            //e.printStackTrace();  
        } catch (Exception e) {
            System.out.println("Exception :: "+e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
       return sb.toString();
    }
     public Destination parseResponse(String respStr){
        Destination destination=null;            
        ObjectMapper mapper = new ObjectMapper();     
        try{
            destination = mapper.readValue(respStr, Destination.class);
        }catch(Exception e){
            destination=null;
             System.out.println("parseResponse() :: Exception "+e);
        }
        return destination; 
     }
}
