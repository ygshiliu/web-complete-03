package junit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.Utils.JDBCUtils;

/**
 * 描述：
 * 开发者：Miss Wang
 * 上午11:47:18
 */
public class JDBCUtilsTest {

	@Test
	public void testGetConnection() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
		//JDBCUtils.releaseConnection(connection);
	}

}
