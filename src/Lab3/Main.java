package Lab3;
import Lab3.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(15);
        SqlUtil util = new SqlUtil();
        System.out.println(util.query(user));

        user = new User();
        user.setUsername("史荣贞");
        System.out.println(util.query(user));

        user = new User();
        user.setUsername("user");
        user.setTelephone("12345678123");
        user.setEmail("user@123.com");
        user.setAge(20);
        System.out.println(util.insert(user));

        User user2 = new User();
        user2.setUsername("user2");
        user2.setTelephone("12345678121");
        user2.setEmail("user2@123.com");
        user2.setAge(20);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        System.out.println(util.insert(list));

        user = new User();
        user.setId(1);
        user.setEmail("change@123.com");
        System.out.println(util.update(user));

        user = new User();
        user.setId(1);
        System.out.println(util.delete(user));
    }
}
