/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilesh.json.handler.data;

import static java.lang.System.out;
import java.lang.reflect.Field;

/**
 *
 * @author nilesh
 */
public class northeast {
    
    public String lat;
    public String lng;
    public northeast(){}
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    
     public String toString() {
		
        Field[] fields = this.getClass().getDeclaredFields();
        String str = this.getClass().getName()+"[";
        try {
            for (Field field : fields) {
                str += field.getName() + "=" + field.get(this) + ",";
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            out.println(ex);
        }
        str+="]";
        return str;
    }
    
}
