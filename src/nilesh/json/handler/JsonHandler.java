/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilesh.json.handler;

import nilesh.json.handler.data.Destination;
import nilesh.json.handler.data.DestinationResponseParser;

/**
 *
 * @author nilesh
 */
public class JsonHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DestinationResponseParser destinationResponseParser =new DestinationResponseParser();
        String input="{\n" +
"   \"results\" : [\n" +
"      {\n" +
"         \"address_components\" : [\n" +
"            {\n" +
"               \"long_name\" : \"Delhi\",\n" +
"               \"short_name\" : \"DL\",\n" +
"               \"types\" : [ \"administrative_area_level_1\", \"locality\", \"political\" ]\n" +
"            },\n" +
"            {\n" +
"               \"long_name\" : \"India\",\n" +
"               \"short_name\" : \"IN\",\n" +
"               \"types\" : [ \"country\", \"political\" ]\n" +
"            }\n" +
"         ],\n" +
"         \"formatted_address\" : \"Delhi, India\",\n" +
"         \"geometry\" : {\n" +
"            \"bounds\" : {\n" +
"               \"northeast\" : {\n" +
"                  \"lat\" : 28.881338,\n" +
"                  \"lng\" : 77.34845780000001\n" +
"               },\n" +
"               \"southwest\" : {\n" +
"                  \"lat\" : 28.412593,\n" +
"                  \"lng\" : 76.83806899999999\n" +
"               }\n" +
"            },\n" +
"            \"location\" : {\n" +
"               \"lat\" : 28.7040592,\n" +
"               \"lng\" : 77.10249019999999\n" +
"            },\n" +
"            \"location_type\" : \"APPROXIMATE\",\n" +
"            \"viewport\" : {\n" +
"               \"northeast\" : {\n" +
"                  \"lat\" : 28.881338,\n" +
"                  \"lng\" : 77.34845780000001\n" +
"               },\n" +
"               \"southwest\" : {\n" +
"                  \"lat\" : 28.412593,\n" +
"                  \"lng\" : 76.83806899999999\n" +
"               }\n" +
"            }\n" +
"         },\n" +
"         \"place_id\" : \"ChIJLbZ-NFv9DDkRQJY4FbcFcgM\",\n" +
"         \"types\" : [ \"administrative_area_level_1\", \"locality\", \"political\" ]\n" +
"      }\n" +
"   ],\n" +
"   \"status\" : \"OK\"\n" +
"}";
   Destination destination=destinationResponseParser.parseResponse(input);
   System.out.println("output :: \nlst= "+destination.results[0].getGeometry().getLocation().getLat());
   System.out.println("lng= "+destination.results[0].getGeometry().getLocation().getLng());
   System.out.println("long_name= "+destination.results[0].address_components[0].getLong_name());
   
   
   
  Destination destination2=destinationResponseParser.getDestinationAdderssDetails("Delhi");
  
  System.out.println("output :: \nlst= "+destination2.results[0].getGeometry().getLocation().getLat());
   System.out.println("lng= "+destination2.results[0].getGeometry().getLocation().getLng());
   System.out.println("long_name= "+destination2.results[0].address_components[0].getLong_name());
   
    }
    
}
