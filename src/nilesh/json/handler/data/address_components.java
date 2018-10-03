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
public class address_components {
    String long_name;
    String short_name;
    String types[];
    public address_components(){}
    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
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
