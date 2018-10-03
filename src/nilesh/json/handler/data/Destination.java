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
public class Destination {
    public results results[];
    public String status;
    public Destination(){}

    public results[] getResults() {
        return results;
    }

    public void setResults(results[] results) {
        this.results = results;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
