import java.util.Map;

import configuration.models.Beans;
import users.Admin;
import users.Rectangle;
import users.User;

public class Runner {
	
	public static void main(String ...strings) throws Exception {
		Beans beans = new Beans("./beans.json");
		User user = beans.getBean("user1");
		Admin admin = beans.getBean("admin");
		Rectangle rectangle = beans.getBean("rectangle");
		Map map = beans.getBean("map");
		System.out.println(user);
		System.out.println(admin);
		System.out.println(rectangle);
		System.out.println((String)beans.getBean("password"));
		System.out.println(map);
		System.out.println(String.class.equals(Class.class));
	}
}
