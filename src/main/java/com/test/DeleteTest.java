package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeleteTest {
	
	User user = new User();

	@Test
	public void deleteUser() throws Exception{
		assertEquals(1, UserDao.delete(475275));
	}
	
}
