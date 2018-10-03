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
public class bounds {
    public southwest southwest;
    public northeast northeast;
    public bounds(){
    }

    public southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(southwest southwest) {
        this.southwest = southwest;
    }

    public northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(northeast northeast) {
        this.northeast = northeast;
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
