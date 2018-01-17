package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;

/**
 * 描述：测试OrderItemDao
 * 开发者：Miss Wang
 * 2017年4月24日 下午8:04:45
 */
public class OrderItemDaoTest {
	
	private OrderItemDao oid = new OrderItemDaoImpl();
	@Test
	public void testGetOrderItemByOrderId() {
		List<OrderItem> list = oid.getOrderItemByOrderId("14930345549611");
		System.out.println(list);
	}

	@Test
	public void testSaveOrderItem() {
		OrderItem item = new OrderItem(null, "时间简史", "霍金", 58.0, 100, 100, "static/img/default.jpg", 100, 5800, "14930345549611");
		oid.saveOrderItem(item);
		
		
	}
	
	@Test
	public void testBatch() {
		//"insert into bs_order_items(title,author,price,sales,stocks,img_path,count,amount,order_id) "
		//		+ " values(?,?,?,?,?,?,?,?,?) ";
		Object[][] params = new Object[2][];
		params[0]=new Object[]{"时间简史", "霍金", 58.0, 100, 100, "static/img/default.jpg", 100, 5800, "14930345549611"};
		params[1]=new Object[]{"时间简史1", "霍金1", 58.0, 100, 100, "static/img/default.jpg", 100, 5800, "14930345549611"};
		
		oid.batchSaveOrderItem(params);
	}

}
