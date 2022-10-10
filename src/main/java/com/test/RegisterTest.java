package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterTest {

	User user = new User();
	
	@Test
	public void saveUser() throws Exception {
		user.setInitial("Mr.");
		user.setFirst_name("Hello");
		user.setLast_name("World");
		user.setPhone("7894561233");
		user.setPan("KIJUKLOP78");
		user.setAddress("Bangalore");
		user.setOcc("Salaried");
		user.setIncome("Above 10 Lakhs");
		user.setPass("World");
		user.setAccno(12563);
		user.setCustid(78945);
		user.setType("Savings");
		user.setBalance(5000);
		
		assertEquals(1, UserDao.save(user));
	}

}
