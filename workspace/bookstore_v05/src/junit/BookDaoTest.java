package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;

/**
 * 描述：测试BookDao
 * 开发者：Miss Wang
 * 2017年4月19日 上午10:26:42
 */
public class BookDaoTest {
	
	private BookDao bd = new BookDaoImpl();

	@Test
	public void testSaveBook() {
		Book book = new Book(null, "tomcat与javaWeb开发", "孙卫琴", 58.0, 100, 100);
		int i = bd.saveBook(book);
		System.out.println(i);
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book(1, "Tomcat与JavaWeb开发", "孙卫琴1", 78.0, 100, 100);
		int i = bd.updateBook(book);
		System.out.println(i);
	}

	@Test
	public void testDeleteBook() {
		bd.deleteBook("1");
	}

	@Test
	public void testGetBookByBookId() {
		Book book = bd.getBookByBookId("1");
		System.out.println(book);
	}

	@Test
	public void testGetBookAll() {
		List<Book> list = bd.getBookAll();
		System.out.println(list);
	}
	@Test
	public void testFindBookList(){
		Page<Book> page = new Page<Book>();
		page.setPageSize(2);
		page.setPageNo(1);
		page = bd.findBookList(page);
		
		System.out.println(page);
		System.out.println(page.getTotalPage());
		System.out.println(page.getIndex());
		
	}

}
