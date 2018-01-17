package junit;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;

/**
 * 描述：测试购物车
 * 开发者：Miss Wang
 * 2017年4月24日 上午11:48:20
 */
public class CartTest {
	
	private BookDao bd = new BookDaoImpl();
	@Test
	public void test01(){
		/**
		 * double类型有精度问题，在实际开发中我们使用BigDecimal来解决精度问题
		 * BigDecimal使用字符串构造器，不要使用double类型的构造器，易出现不可未知的问题
		 * 
		 */
		BigDecimal d3 = new BigDecimal("0.01");
		BigDecimal d4 = new BigDecimal("0.05");
		
		System.out.println("加："+d3.add(d4));
		System.out.println("减："+d3.subtract(d4));
		System.out.println("乘："+d3.multiply(d4));
		System.out.println("除："+d3.divide(d4));
		
		System.out.println("===============");
		
		BigDecimal d5 = new BigDecimal(0.01);
		BigDecimal d6 = new BigDecimal(0.05);
		
		System.out.println(d5.add(d6));
		
		System.out.println("===============");
		
		
		
		
		
		double d1= 0.01;
		double d2= 0.05;
		System.out.println(d1+d2);
	}

	@Test
	public void testCart() {
		
		Book book = bd.getBookByBookId("42");
		Book book1 = bd.getBookByBookId("42");
		Book book3 = bd.getBookByBookId("43");
		Book book4 = bd.getBookByBookId("44");
		
		System.out.println("book:"+book);
		System.out.println("book3"+book3);
		System.out.println("book3"+book4);
		
		Cart cart = new Cart();
		
		//添加图书
		cart.addBook2Cart(book);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book3);
		cart.addBook2Cart(book4);
		
		System.out.println("购物车中的总数量："+cart.getTotalCount());
		System.out.println("购物车中的总金额："+cart.getTotalAmount());
		System.out.println("单品种图书的数量："+cart.getMap().get(book.getId()+"").getCount());
		System.out.println("单品种图书的金额："+cart.getMap().get(book.getId()+"").getAmount());
		
		
	}

}
