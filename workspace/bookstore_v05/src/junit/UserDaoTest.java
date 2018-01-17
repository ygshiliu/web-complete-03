package junit;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;

/**
 * 描述：用来测试userDao实现方法
 * 开发者：Miss Wang
 * 下午2:10:55
 */
public class UserDaoTest {
	
	private UserDao  ud = new UserDaoImpl();

	@Test
	public void testSave() {
		User user = new User(null, "admin", "123123", "admin@163.com");
		int save = ud.save(user);
		System.out.println(save);
	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		User user = new User(null, "admin1", "123123", null);
		User user2 = ud.getUserByUsernameAndPassword(user);
		System.out.println(user2);
	}

}
