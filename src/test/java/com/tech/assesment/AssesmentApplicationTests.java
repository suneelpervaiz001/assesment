package com.tech.assesment;

import com.tech.assesment.constants.UserType;
import com.tech.assesment.entity.Item;
import com.tech.assesment.entity.RetailUser;
import com.tech.assesment.repository.UserRepository;
import com.tech.assesment.service.ItemBillService;
import com.tech.assesment.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AssesmentApplicationTests {


	@InjectMocks
	ItemBillService itemBillService;

	@InjectMocks
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest(){

		when(userRepository.findAll()).thenReturn(Stream
				.of(new RetailUser(1, "john", "john@gmail.com", UserType.AFFILIATE),
						new RetailUser(2, "jax", "jax@gmail.com", UserType.EMPLOYEE)).collect(Collectors.toList()));
        assertEquals(2,userService.getAllUsers().size());
	}


	@Test
	void calculateTotalBillForEmployee() {
		double totalAmount = 200.0;
		boolean isGrocery = false;
		RetailUser retailUser = new RetailUser();
		retailUser.setId(1);
		retailUser.setName("john");
		retailUser.setEmail("john@gmail.com");
		retailUser.setUserType(UserType.EMPLOYEE);
		double result = itemBillService.calculateDiscountedBill(totalAmount,retailUser, isGrocery);
		assertEquals(130.0, result);
	}

	@Test
	void calculateTotalBillForAffiliate() {
		double totalAmount =1000.0;
		boolean isGrocery = false;
		RetailUser retailUser = new RetailUser();
		retailUser.setId(1);
		retailUser.setName("john");
		retailUser.setEmail("john@gmail.com");
		retailUser.setUserType(UserType.AFFILIATE);
		double result = itemBillService.calculateDiscountedBill(totalAmount,retailUser, isGrocery);
		assertEquals(850.0, result);
	}

	@Test
	void calculateTotalBillForOverTwoYearsOldCustomer() {
		double totalAmount =1000.0;
		boolean isGrocery = false;
		RetailUser retailUser = new RetailUser();
		retailUser.setId(1);
		retailUser.setName("john");
		retailUser.setEmail("john@gmail.com");
		retailUser.setUserType(UserType.CUSTOMER_OVER_TWO_YEARS);
		double result = itemBillService.calculateDiscountedBill(totalAmount,retailUser, isGrocery);
		assertEquals(900.0, result);
	}

	@Test
	void calculateTotalBillForGroceries() {
		double totalAmount =1000.0;
		boolean isGrocery = true;
		RetailUser retailUser = new RetailUser();
		retailUser.setId(1);
		retailUser.setName("john");
		retailUser.setEmail("john@gmail.com");
		retailUser.setUserType(UserType.CUSTOMER_OVER_TWO_YEARS);
		double result = itemBillService.calculateDiscountedBill(totalAmount,retailUser, isGrocery);
		assertEquals(950.0, result);
	}

}
