package BankManagement;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 *ʵ���û��͹���Ա�Ĳ���  
 * @author: LMY
 * @date:   2021��1��8�� ����9:20:56
 */
public class User {
	String ID; //�˺�
	String userName;//����
	String userPassword;//����
	String firstTime;//����ʱ��
	String idNumber;//���֤����
	String accountBalance;//�˻����
	SQL_Models sql_Models;//User������
	ResultSet rs;//SQL���������
	//getter��setter����
	
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
		this.firstTime = time.format(new Date());//��ȡ��ǰϵͳʱ��
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
	 * ��ת��ת���˺ŵ��������޸�  
	 * @param id1 ת���û�
	 * @param id2 ת���û�
	 * @param balance1 ת���˻����
	 * @param balance2 ת�����
	 * @param money    ת�����
	 * @return: void
	 */
	//ת�˹��ܷ���                ת��ID        ת��ID   ת���˻����     ת���˻����          ת�˽��
	public void Transfer(String id1,String id2,String balance1,String balance2,String money) {
		sql_Models = new SQL_Models();//ʵ������
		sql_Models.DriveLoad();//��������
		sql_Models.ConnectionCreate();//��������
		//�޸�ת���˻����
		sql_Models.setID(id1);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance1)-Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
		//�޸�ת���˻����
		sql_Models.setID(id2);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance2)+Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * �޸��û������ݿ�洢�Ľ��  
	 * @param id �û��˻�
	 * @param balance ���
	 * @param money   ��ȡ���
	 * @return: void
	 */

	public void Deposit(String id,String balance,String money) {
		sql_Models = new SQL_Models();//ʵ������
		sql_Models.DriveLoad();//��������
		sql_Models.ConnectionCreate();//��������
		//�޸����
		sql_Models.setID(id);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance)+Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * �޸��û������ݿ���˻����  
	 * @param id �û�ID
	 * @param balance  ���
	 * @param money    ȡ����  
	 * @return: void
	 */

	public void Withdrawal(String id,String balance,String money) {
		sql_Models = new SQL_Models();//ʵ������
		sql_Models.DriveLoad();//��������
		sql_Models.ConnectionCreate();//��������
		//�޸����
		sql_Models.setID(id);
		sql_Models.setAccountBalance(String.valueOf(Integer.parseInt(balance)-Integer.parseInt(money)));
		sql_Models.Data_Alter(6);
	}
	/**
	 * 
	 * �޸��û������� 
	 * @param id �û�ID
	 * @param password   Ҫ�޸ĵ�����  
	 * @return: void
	 */
	//�޸����빦�ܷ���
	public void Change_Password(String id,String password) {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();//��������
		sql_Models.ConnectionCreate();//��������
		//�޸�����
		sql_Models.setID(id);
		sql_Models.setUserPassword(password);
		sql_Models.Data_Alter(3);	
	}
	/**
	 * 
	 * ͨ�����ݿ�����һ�������������û��˻�       
	 * @return: String 
	 */
	//�����˻����ܷ���
	public String Create_ID() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();//��������
		sql_Models.ConnectionCreate();//��������
		sql_Models.End_Data();//��ȡ���ݿ�����һ�����ݵ�ID
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
	 * ���������û��������ݿ�  
	 * @param id �˻�
	 * @param name ����
	 * @param password ����
	 * @param idnumber ���֤��
	 * @param balance  ���    
	 * @return: void
	 */
	//�������ܷ���
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
	 * ɾ�������û��˺� 
	 * @param id   �û��˺�   
	 * @return: void
	 */
	//����
	public void AccountDelete(String id) {
    	sql_Models=new SQL_Models();
    	sql_Models.setID(id);
    	sql_Models.DriveLoad();
    	sql_Models.ConnectionCreate();
    	sql_Models.Data_Delete();
    }
}
