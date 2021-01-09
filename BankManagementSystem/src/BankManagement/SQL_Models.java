package BankManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * ʵ���������ݿⲢ�����ݿ������ز���  
 * @author: LMY
 * @date:   2021��1��8�� ����9:02:31
 */
public class SQL_Models extends User {
	String uri = "jdbc:mysql://localhost:3306/bankmanegementsystem?useSSL=true";//���ݿ����ӵ�ַ
	String user = "root"; //���ݿ��¼��
	String password = "12345"; //���ݿ��¼����
	String sql = null;//���ݿ�������
	PreparedStatement ps = null;//�Ѳ�ѯ��ɾ�������µȲ�����ps
	Connection cnn = null;//����
	/**
	 * 
	 * �������ݿ�����  
	 * @return: void
	 */
	public void DriveLoad(){ //��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
	}
	/**
	 * 
	 * ���������ݿ������ 
	 * @return: void
	 */
	public void ConnectionCreate() {//��������
		try {
			cnn = DriverManager.getConnection(uri, user, password);
			System.out.println("���ݿ����ӳɹ�!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�");
		}
	}
	/**
	 * 
	 * �����ݿ�������ݵĲ������  
	 * @return: void
	 */
	public void Data_Insert() {//���ݲ���
		try {
			sql = "insert into BankUser values(?,?,?,?,?,?)";//SQL���
			ps = cnn.prepareStatement(sql);//Ԥ����
			ps.setString(1, ID);
    		ps.setString(2, userName);
    		ps.setString(3, userPassword);
    		ps.setString(4, firstTime);
    		ps.setString(5, idNumber);
    		ps.setString(6, accountBalance);
    		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
	}
	/**
	 * 
	 * �����ݿ�������ݵ�ɾ��  
	 * @return: void
	 */
	public void Data_Delete() {//����ɾ��
		
		try {
			sql = "delete from BankUser where ID="+"'"+ID+"'";
			ps = cnn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			ID = null;
		}
	}
	/**
	 * 
	 * �����ݿ�����ݽ����޸�  
	 * @param a �޸�ָ��     
	 * @return: void
	 */
	public void Data_Alter(int a) {//�޸ģ�aΪ����ָ��
		try {
			if(a==3) {//�޸�����
				sql = "update BankUser set userPassword="+"'"+userPassword+"'"+" where ID="+"'"+ID+"'";
				System.out.println(1);
			}
			if(a==6) {//�޸����
				sql = "update BankUser set accountBalance="+"'"+accountBalance+"'"+" where ID="+"'"+ID+"'";
			}
			ps = cnn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�޸Ĳ���ʧ�ܣ�");
		}
	}
	/**
	 * 
	 * ��ȡ���ݿ�����һ��������������ID        
	 * @return: void
	 */
	//������ȡ���һ������
	public void End_Data() {
		
		try {
			sql = "select * from BankUser";
			ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.last();//ָ�����һ������
			ID = rs.getString(1);
			System.out.println(1);
		} catch (SQLException e) {
			ID = "";
			userPassword="";
		}
			
	}
	/**
	 * 
	 * ��ѯ���ݿ����ݣ��˺��Ƿ����        
	 * @return: void
	 */
	//�����ݿ��в�ѯ�����˺�
	public void Data_Lookup() {
	    	try {
	    		sql="select * from BankUser where ID ='"+ID+"'";
	        	ps=cnn.prepareStatement(sql);
	     		rs=ps.executeQuery();
	     		rs.next();//ָ�������ݵĵ�һ��
	     		ID=rs.getString(1);
	     		userName=rs.getString(2);
	     		userPassword=rs.getString(3);
	     		firstTime=rs.getString(4);
	     		idNumber=rs.getString(5);
	     		accountBalance=rs.getString(6);
	    	}catch (Exception e) {
	    		ID="null";
			}
	}
	/**
	 * 
     * ������־�� ���û�����Ҫ����д�����ݿ�  
	 * @param id �˺�
	 * @param Dowhat ��Ҫ����     
	 * @return: void
	 */
	//������־��д�����ݿ�
	public void SaveLog(String id,String Dowhat) {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String Time = time.format(new Date());//��ȡ��ǰϵͳʱ��
		try {
			sql = "insert into Log values(?,?,?)";//SQL���
			ps = cnn.prepareStatement(sql);//Ԥ����
			ps.setString(1, id);
    		ps.setString(2, Time);
    		ps.setString(3, Dowhat);
    		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
	}
	/**
	 * 
	 * �����ݿ��ȡ�����û���Ϣ     
	 * @return: Object[][]
	 */
	public Object[][] UserInfo(){
		Object[][] u;
		try {
			sql="select * from BankUser";
			ps=cnn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.last();
			int line = rs.getRow();
			rs.beforeFirst();
			u = new Object[line][6];
			rs.next();
			for(int i=0;i<line;i++) {
				u[i][0] = rs.getString(1);
				u[i][1] = rs.getString(2);
				u[i][2] = rs.getString(3);
				u[i][3] = rs.getString(4);
				u[i][4] = rs.getString(5);
				u[i][5] = rs.getString(6);
				rs.next();
			}
		}catch(Exception e) {
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	/**
	 * 
	 * ��ȡ�������ݿ����־����        
	 * @return: Object[][]
	 */
	public Object[][] LogInfo(){
		Object[][] u;
		try {
			sql="select * from Log";
			ps=cnn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.last();
			int line = rs.getRow();
			rs.beforeFirst();
			u = new Object[line][3];
			rs.next();
			for(int i=0;i<line;i++) {
				u[i][0] = rs.getString(1);
				u[i][1] = rs.getString(2);
				u[i][2] = rs.getString(3);
				rs.next();
			}
		}catch(Exception e) {
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	/**
	 * 
	 * �ر������ݿ����������        
	 * @return: void
	 */
	public void Resource_Shutdown() {
    	try {
            if(cnn!=null) {
            	cnn.close();
            }
        	if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
