/**

*/
package BankManagement;

import org.junit.jupiter.api.Test;

/**   
 * @ClassName:  SQL_ModelsTest   
 * @Description:TODO(��������������)   
 * @author: LMY
 * @date:   2021��1��9�� ����9:17:36       
 */
class SQL_ModelsTest {

	/**
	 * Test method for {@link BankManagrment.SQL_Models#Data_Lookup()}.
	 */
	@Test
	void testData_Lookup() {
		SQL_Models sql_Models = new SQL_Models();
		sql_Models.setID("000062");
		sql_Models.Data_Lookup();
		if(sql_Models.ID.equals("null")) {
			System.out.println("û�и��˺�");
		}else {
			sql_Models.toString();
		}
	}

	/**
	 * Test method for {@link BankManagrment.SQL_Models#SaveLog(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSaveLog() {
		String id = "000062";
		String Dowhat = "��¼ϵͳ";
		SQL_Models sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		sql_Models.SaveLog(id, Dowhat);
	}

	/**
	 * Test method for {@link BankManagrment.SQL_Models#UserInfo()}.
	 */
	@Test
	void testUserInfo() {
		SQL_Models sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		Object[][] u = sql_Models.UserInfo();
		if(u==null)
			System.out.println("��ȡʧ��");
		else
			System.out.println("��ȡ�ɹ�");
	}

	/**
	 * Test method for {@link BankManagrment.SQL_Models#LogInfo()}.
	 */
	@Test
	void testLogInfo() {
		SQL_Models sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		Object[][] u = sql_Models.UserInfo();
		if(u==null)
			System.out.println("��ȡʧ��");
		else
			System.out.println("��ȡ�ɹ�");
	}

}
