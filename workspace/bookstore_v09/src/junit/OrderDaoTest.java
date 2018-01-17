package junit;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;

/**
 * 描述：测试orderDao
 * 开发者：Miss Wang
 * 2017年4月24日 下午7:45:35
 */
public class OrderDaoTest {
	
	private OrderDao od = new OrderDaoImpl();
	@Test
	public void testSaveOrder() {
		Order order = new Order(System.currentTimeMillis()+""+1, 100, 100, new Date(), 0, 1);
		od.saveOrder(order);
	}

	@Test
	public void testUpdateState() {
		od.updateState("14930345549611", 2);
	}

	@Test
	public void testGetOrderList() {
		List<Order> list = od.getOrderList();
		System.out.println(list);
	}

	@Test
	public void testGetOrderListByUserId() {
		List<Order> list = od.getOrderListByUserId(1);
		System.out.println(list);
	}

}
