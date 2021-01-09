/**

*/
package BankManagement;

import org.junit.jupiter.api.Test;

/**   
 * @ClassName:  UserTest   
 * @Description:TODO(描述这个类的作用)   
 * @author: LMY
 * @date:   2021年1月9日 上午8:50:39       
 */
class UserTest {

	/**
	 * Test method for {@link BankManagrment.User#Transfer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTransfer() {
		String id1 = "999988";
		String id2 = "999987";
		String balance1 = "5000";
		String balance2 = "5000";
		String money = "1000";
		new User().Transfer(id1, id2, balance1, balance2, money);
	}

	/**
	 * Test method for {@link BankManagrment.User#Deposit(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testDeposit() {
		String id="999986";
		String balance="5000";
		String money="1000";
		new User().Deposit(id, balance, money);
	}

	/**
	 * Test method for {@link BankManagrment.User#Withdrawal(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testWithdrawal() {
		String id="999985";
		String balance="10000";
		String money="2000";
		new User().Deposit(id, balance, money);
	}

	/**
	 * Test method for {@link BankManagrment.User#Change_Password(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testChange_Password() {
		String id="999986";
		String password="123456";
		new User().Change_Password(id, password);
	}

	/**
	 * Test method for {@link BankManagrment.User#Create_ID()}.
	 */
	@Test
	void testCreate_ID() {
		System.out.println(new User().Create_ID());
	}

	/**
	 * Test method for {@link BankManagrment.User#Open_Account(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testOpen_Account() {
		String id="999999";
		String name="王五";
		String password="123456";
		String idnumber="431024112299";
		String balance="10000";
		new User().Open_Account(id, name, password, idnumber, balance);
	}

	/**
	 * Test method for {@link BankManagrment.User#AccountDelete(java.lang.String)}.
	 */
	@Test
	void testAccountDelete() {
		String id="999824";
		new User().AccountDelete(id);
	}
		

}
