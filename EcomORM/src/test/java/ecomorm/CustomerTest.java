package ecomorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.training.ecom.dao.CustomerDao;
import com.training.ecom.model.Customer;

public class CustomerTest {

	private Customer customer;
	private CustomerDao customerDao;
	
	@BeforeEach
	public void beforeEach() {
		customer=new Customer("Aishwarya Mankar", "aishwarya.mankar@gmail.com", "1234567890", "Pune");
		customerDao=new CustomerDao();
	}
	
	@Disabled
	@Test
	public void testCreateCustomer() {
		Assertions.assertTrue(customerDao.create(customer));
		
	}
	
	@Disabled
	@Test
	public void testFindAll() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	
	
//	@Disabled
	@Test
	public void testFindOne() {
		customer=customerDao.findOne(5);
		Assertions.assertNotNull(customer);
		System.out.println("customerId=5 : "+customer.getCustName());
	}
	
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneAndDelete(2));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customer.setCustName("Aishwarya");
		Assertions.assertTrue(customerDao.findOneAndUpdate(3, customer));
	}	
	
	
	
	
}
