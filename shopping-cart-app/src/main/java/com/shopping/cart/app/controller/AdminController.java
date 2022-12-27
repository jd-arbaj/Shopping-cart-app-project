package com.shopping.cart.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shopping.cart.app.model.Customer;
import com.shopping.cart.app.model.Employee;
import com.shopping.cart.app.model.Office;
import com.shopping.cart.app.model.Order;
import com.shopping.cart.app.model.OrderDetail;
import com.shopping.cart.app.model.Payment;
import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.model.ProductLine;
import com.shopping.cart.app.repository.CustomerRepository;
import com.shopping.cart.app.repository.OfficeRepository;
import com.shopping.cart.app.repository.OrderDetailRepository;
import com.shopping.cart.app.repository.PaymentRepository;
import com.shopping.cart.app.repository.ProductLineRepository;


@Controller
public class AdminController {
	
	@Autowired
	private ProductLineRepository productLineRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	
		public void run() {
			
			//Creating productline objects
			ProductLine pl1 = new ProductLine("This carry bag","Html decription","img.jpeg",null);
			
			//Creating product objects
			Product p1 = new Product("carry bag", pl1,"product scale","product vendor","This is carry bag",5,110,133.5);
			
			List<Product> producList1 = new ArrayList<>();
			producList1.add(p1);
			
			//Set product list in productline
			pl1.setProducts(producList1);

			//Save objects in database
			productLineRepository.save(pl1);
			
			//Creating orderdetails objects
			OrderDetail orderDetail1 = new OrderDetail(2, 125, 1,p1, null);
			
			//Saving orderDetails objects in db
			orderDetailRepository.save(orderDetail1);
			
			//Creating office objects
			Office office1 = new Office("indore", "9985221571", "field 1", " field indore",
					"madhya pradesh" , "India", "455399","perrymorphis", null);
			

			//Creating employee objects
			Employee employee1 = new Employee("sheikh","arbaj","extention","arbaj3923@gmaIL.com",office1,"M",
					"engneer",null,null);
			
			Employee employee2 = new Employee("yash","Yes","extention","yash11@gmail.com",office1,"CEO",
					"Developer",null,null);
			
			//Creating list of employees
			List<Employee> employeeList1 = new ArrayList<>();
			employeeList1.add(employee1);
			employeeList1.add(employee2);
			
			List<Employee> employeeList2 = new ArrayList<>();
			
			office1.setEmployees(employeeList1);
			//Saving offices in the database
			officeRepository.save(office1);

			
			//Creating customer objects
			Customer customer1 = new Customer();
			
			customer1.setCustomerName("suresh tati");
			customer1.setContactLastName("tati");
			customer1.setContactFirstName("suresh");
			customer1.setPhone("5647287241");
			customer1.setAddressLine1("Indore");
			customer1.setAddressLine2("ajnash");
			customer1.setCity("chicholi");
			customer1.setState("harda");
			customer1.setPostalCode("883309");
			customer1.setCountry("India");
			customer1.setSalesRepEmployeeNumber(employee1);
			customer1.setCreditLimit(60000);
			customer1.setOrders(null);//order list
			
			Customer customer2 = new Customer("rohan singh","singh","rohan","8712377863",
					"n chock","n chock  chichali","khirkiya","khirkiya","893022","India",employee1,5000,null);
			
			//Creating list of customers
			List<Customer> customersList1= new ArrayList<>();
			customersList1.add(customer1);
			customersList1.add(customer2);			

			//Set customerlist to employee
			employee1.setCustomers(customersList1);
			
			//Saveing employees in database
//			employeeRepository.save(employee1);

			//Creating order objects
			LocalDate orderDate1 = LocalDate.of(2022,12,15);
			LocalDate requiredDate1 = LocalDate.of(2022,12,18);
			LocalDate shippedDate1 = LocalDate.of(2022,12,15);
			
			Order order1 = new Order(orderDate1, requiredDate1, shippedDate1, 1, "This is first order", customer2, orderDetail1);
			Order order2 = new Order(orderDate1,requiredDate1,shippedDate1,1,"second order",customer1,null);		
	
			//Creating list of order objects
			List<Order> orderList1 = new ArrayList<>();
			orderList1.add(order1);
//			
			List<Order> orderList2 = new ArrayList<>();
			orderList1.add(order2);
			
			//Set order list to customers
			customer2.setOrders(orderList1);
			customer1.setOrders(orderList2);
			
			//Saving customers in database
			customerRepository.save(customer1);
			customerRepository.save(customer2);
			
			//Creating local date objects
			LocalDate date1 = LocalDate.of(2022,12,13);
			LocalDate date2 = LocalDate.of(2022,12,14);
			
			//Creating payment objects
			Payment payment1 = new Payment(date1,250.1,customer1);
			Payment payment2 = new Payment(date2,2500.50,customer2);
			
			//Saving payment objects in db
			paymentRepository.save(payment1);
			paymentRepository.save(payment2);
			
		
	
		}
}


