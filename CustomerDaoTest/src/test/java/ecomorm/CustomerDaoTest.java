package ecomorm;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.training.ecom.dao.CustomerDao;
import com.training.ecom.model.Customer;
import com.training.ecom.util.HibernateUtil;

public class CustomerDaoTest {

	
	private Customer customer;
	private CustomerDao customerDao;
	@BeforeEach()
	public void beforeEach() {
		customer=new Customer("Somnath","123456","Kolhapur");
		customerDao=new CustomerDao();
	}
	
	@Test
	public void testCreateCustomer() {
		Assertions.assertTrue(customerDao.createCustomer(customer));
	}
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	
	
	@Test
	public void testFindOneNotNull() {
		customer=customerDao.findOne(1);
		Assertions.assertNotNull(customer);
		System.out.println("id=1 |"+customer);
	}
	
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(2));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		customer.setCustName("Aishwarya");
		Assertions.assertTrue(customerDao.findOneandUpdate(1, customer));
	}
}
