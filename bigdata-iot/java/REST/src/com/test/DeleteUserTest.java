package com.test;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class DeleteUserTest {

	public static void main(String[] args) {
		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id31", "pw56", "SER");
		try {
			db.delete(user.getId());
			//UserDb.java? insert ?¨??? catch ??Έμ²λ¦¬ throw eκ°? ??Όλ©?
			//??¬ μ²λ¦¬κ°? ?μ§? ?κ³? OK???¨
			//??Έμ²λ¦¬ throw?κ²λ ?΄? ?? catchλ‘? μ§μ??¬ ??¬ ???  ? ??λ‘? 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
