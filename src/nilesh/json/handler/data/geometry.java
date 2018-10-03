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
public class geometry {
    
    public bounds bounds;
    public location location;
    public String location_type;
    public viewport viewport;
    public geometry(){}

    public bounds getBounds() {
        return bounds;
    }

    public void setBounds(bounds bounds) {
        this.bounds = bounds;
    }

    public location getLocation() {
        return location;
    }

    public void setLocation(location location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public viewport getViewport() {
        return viewport;
    }

    public void setViewport(viewport viewport) {
        this.viewport = viewport;
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
