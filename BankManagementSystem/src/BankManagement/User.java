package BankManagement;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 *实现用户和管理员的操作  
 * @author: LMY
 * @date:   2021年1月8日 上午9:20:56
 */
public class User {
	String ID; //账号
	String userName;//姓名
	String userPassword;//密码
	String firstTime;//开户时间
	String idNumber;//身份证号码
	String accountBalance;//账户余额
	SQL_Models sql_Models;//User的子类
	ResultSet rs;//SQL语句操作结果
	//getter和setter方法
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getFirstTime() {
		return firstTime;
	}
	
	public void setFirstTime() {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		this.firstTime = time.format(new Date());//获取当前系统时间
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", userName=" + userName + ", userPassword=" + userPassword + ", firstTime="
				+ firstTime + ", idNumber=" + idNumber + ", accountBalance=" + accountBalance + "]";
	}

	/**
	 * 
	 * 对转出转入账号的余额进行修改  
	 * @param id1 转出用户
	 * @param id2 转入用户
	 * @param balance1 转出账户余额
	 * @param balance2 转入余额
	 * @param money    转出金额
	 * @return: void
	 */
	//转账功能方法                转出ID        转入ID   转出账户余额     转入账户余额          转账金额
	public void Transfer(String id1,String id2,String balance1,String balance2,String money) {
		sql_Models = new SQL_Models();//实例对象
		sql_Models.DriveLoad();//加载驱动
		sql_Models.ConnectionCreate();//建立连接
		//修改转出账户余额
		sql_Models.setID(id1);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance1)-Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
		//修改转入账户余额
		sql_Models.setID(id2);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance2)+Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * 修改用户在数据库存储的金额  
	 * @param id 用户账户
	 * @param balance 余额
	 * @param money   存取金额
	 * @return: void
	 */

	public void Deposit(String id,String balance,String money) {
		sql_Models = new SQL_Models();//实例对象
		sql_Models.DriveLoad();//加载驱动
		sql_Models.ConnectionCreate();//建立连接
		//修改余额
		sql_Models.setID(id);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance)+Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * 修改用户在数据库的账户余额  
	 * @param id 用户ID
	 * @param balance  余额
	 * @param money    取款金额  
	 * @return: void
	 */

	public void Withdrawal(String id,String balance,String money) {
		sql_Models = new SQL_Models();//实例对象
		sql_Models.DriveLoad();//加载驱动
		sql_Models.ConnectionCreate();//建立连接
		//修改余额
		sql_Models.setID(id);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance)-Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * 修改用户的密码 
	 * @param id 用户ID
	 * @param password   要修改的密码  
	 * @return: void
	 */
	//修改密码功能方法
	public void Change_Password(String id,String password) {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();//加载驱动
		sql_Models.ConnectionCreate();//建立连接
		//修改密码
		sql_Models.setID(id);
		sql_Models.setUserPassword(password);
		sql_Models.Data_Alter(3);	
	}
	/**
	 * 
	 * 通过数据库的最后一条数据来生成用户账户       
	 * @return: String 
	 */
	//生成账户功能方法
	public String Create_ID() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();//加载驱动
		sql_Models.ConnectionCreate();//建立连接
		sql_Models.End_Data();//获取数据库的最后一条数据的ID
		String id = sql_Models.getID();
		String Id = "";
		if(id.equals(""))
			return "";
		id = String.valueOf(Integer.parseInt(id)+1);
		int length = id.length();
		for(int i=0;i<6-length;i++) {
			Id=Id+"0";
		}
		return Id+id;
	}
	/**
	 * 
	 * 将新增的用户插入数据库  
	 * @param id 账户
	 * @param name 姓名
	 * @param password 密码
	 * @param idnumber 身份证号
	 * @param balance  余额    
	 * @return: void
	 */
	//开户功能方法
	public void Open_Account(String id,String name,String password,String idnumber,String balance) {
		sql_Models=new SQL_Models();
    	sql_Models.DriveLoad();
    	sql_Models.ConnectionCreate();
    	sql_Models.setID(id);
    	sql_Models.setUserName(name);
    	sql_Models.setUserPassword(password);
    	sql_Models.setFirstTime();
    	sql_Models.setIdNumber(idnumber);
    	sql_Models.setAccountBalance(balance);
         sql_Models.Data_Insert();
	}
	/**
	 * 删除已有用户账号 
	 * @param id   用户账号   
	 * @return: void
	 */
	//销户
	public void AccountDelete(String id) {
    	sql_Models=new SQL_Models();
    	sql_Models.setID(id);
    	sql_Models.DriveLoad();
    	sql_Models.ConnectionCreate();
    	sql_Models.Data_Delete();
    }
}
