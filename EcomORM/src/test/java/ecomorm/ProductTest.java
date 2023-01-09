package ecomorm;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.training.ecom.dao.ProductDao;
import com.training.ecom.model.Product;
import com.training.ecom.util.HibernateUtil;

public class ProductTest {

//	private Query query;
//	private Session session;
//	private Transaction transaction;
	private Product product;
	private ProductDao productDao;

	@BeforeEach
	public void beforeEach() {
//		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
//		transaction=session.beginTransaction();
		product=new Product("Pencil",120.00);
		productDao=new ProductDao();
	}

	@Disabled
	@Test
	public void testCreateProduct() {

		Assertions.assertTrue(productDao.create(product));
//      session.save(product);
//		System.out.println("ProductId: "+product.getPid());
	}
	
	@Disabled
	@Test
	public void testFindAll() {
		Assertions.assertNotNull(productDao.findAll());
	}
	
	
//	@Disabled
	@Test
	public void testFindOne() {
		product=productDao.findOne(6);
		Assertions.assertNotNull(product);
		System.out.println("productId=6 : "+product);
	}
	
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneAndDelete(2));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setPname("Pencil");
		Assertions.assertTrue(productDao.findOneAndUpdate(3, product));
	}
	
}
