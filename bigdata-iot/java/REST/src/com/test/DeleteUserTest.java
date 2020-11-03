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
			//UserDb.java?�� insert ?��?��?��?�� catch ?��?��처리 throw e�? ?��?���?
			//?��?�� 처리�? ?���? ?���? OK?��?��?��
			//?��?��처리 throw?��게끔 ?��?�� ?��?�� catch�? 진입?��?�� ?��?�� ?��?��?�� ?�� ?��?���? 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
