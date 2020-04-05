package Lab3;
import Lab3.Annotations.Column;
import Lab3.Entity.User;

import java.lang.reflect.Field;
import java.util.HashMap;


public class Reflection {

    HashMap<String, String> getData(Field[] fields, User user){
        HashMap<String, String> out  = new HashMap<>();
        for (Field f: fields) {
            Column an = f.getAnnotation(Column.class);
            f.setAccessible(true);
            try {
                Object data = f.get(user);
                if (!(data == null || data.equals(0))){
                    out.put(an.value(), data.toString());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return out;
    }
}
