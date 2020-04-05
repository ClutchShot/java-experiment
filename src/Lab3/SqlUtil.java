package Lab3;

import Lab3.Annotations.Table;
import Lab3.Entity.User;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlUtil {

    /**
     * 根据传入的参数返回查询语句
     *
     * @param user
     * @return 返回查询语句
     */
    String query(User user) {

        Table t = user.getClass().getAnnotation(Table.class);
        String str =String.format("SELECT * FROM '%s' ", t.value());
        Field[] fields = user.getClass().getDeclaredFields();
        Reflection reflaction = new Reflection();
        HashMap <String, String> values = reflaction.getData(fields,user);
        if (values.containsKey("id")){
            str = str.concat("WHERE id=" + values.get("id"));
            return  str;
        }
        if (values.containsKey("username")){
            str = str.concat("WHERE username LIKE '" + values.get("username") + "';" );
            return  str;
        }
        return str;
    }

    /**
     * 根据传入的参数返回插入语句
     *
     * @param user
     * @return 返回插入语句
     */
    String insert(User user) {
        Table t = user.getClass().getAnnotation(Table.class);
        Field[] fields = user.getClass().getDeclaredFields();
        Reflection reflaction = new Reflection();
        HashMap <String, String> values = reflaction.getData(fields,user);
        String str2 = String.format("INSERT INTO `%s` (`username`, `telephone`, `email`, `age`) " +
                                    "VALUES ('%s', '%s', '%s', %s)", t.value(), values.get("username"),
                                    values.get("telephone"), values.get("email"), values.get("age"));
        return str2;
    }

    /**
     * 根据传入的参数返回插入语句
     *
     * @param users
     * @return 返回插入语句
     */
    String insert(List<User> users) {

        User first = users.get(0);
        Table t = first.getClass().getAnnotation(Table.class);
        String str =  String.format("INSERT INTO `%s` (`username`, `telephone`, `email`, `age`) VALUES",t.value());
        for (User user: users) {
            Field[] fields = user.getClass().getDeclaredFields();
            Reflection reflaction = new Reflection();
            HashMap<String, String> values = reflaction.getData(fields, user);
            String str2 = String.format(" ('%s', '%s', '%s', %s), ", values.get("username"),
                                values.get("telephone"), values.get("email"), values.get("age"));
            str = str.concat(str2);
        }
        str = str.substring(0, str.lastIndexOf(","));
        return str;
    }

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     *
     * @param user
     * @return 返回删除语句
     */
    String delete(User user) {
        Table t = user.getClass().getAnnotation(Table.class);
        Field[] fields = user.getClass().getDeclaredFields();
        Reflection reflaction = new Reflection();
        HashMap <String, String> values = reflaction.getData(fields,user);
        String str2 = String.format("DELETE FROM `%s` WHERE 'id' = %s;", t.value(), values.get("id"));
        return str2;
    }

    /**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     *
     * @param user
     * @return 返回更新语句
     */
    String update(User user) {
        Table t = user.getClass().getAnnotation(Table.class);
        String str = String.format("UPDATE `%s` SET", t.value());

        Field[] fields = user.getClass().getDeclaredFields();
        Reflection reflaction = new Reflection();
        HashMap <String, String> values = reflaction.getData(fields,user);
        for(Map.Entry<String,String> entry : values.entrySet()) {
            if (!entry.getKey().equals("id")){
                String str1 = String.format(" '%s' = '%s',",entry.getKey(),entry.getValue());
                str = str.concat(str1);
            }
        }
        str = str.substring(0, str.lastIndexOf(","));
        String str2 = String.format(" WHERE 'id' = %s ",values.get("id"));
        str = str.concat(str2);
        return str;
    }
}
