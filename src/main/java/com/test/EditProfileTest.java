package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EditProfileTest {
	
	User user = new User();

	@Test
	public void editUser() throws Exception {
		user.setPhone("7277200451");
		user.setPan("POIKLJ7894");
		user.setAddress("Bangalore");
		assertEquals(1, UserDao.updateProfile(user, 12345));
	}

}
