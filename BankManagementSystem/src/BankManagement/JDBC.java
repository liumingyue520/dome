package BankManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC {
	String uri = "jdbc:mysql://localhost:3306/bankmanegementsystem?useSSL=true";//���ݿ����ӵ�ַ
	String user = "root"; //���ݿ��¼��
	String password = "12345"; //���ݿ��¼����
	String sql;//���ݿ�������
	PreparedStatement ps = null;//�Ѳ�ѯ��ɾ�������µȲ�����ps
	Connection cnn = null;//����
	ResultSet rs;
	public void DriveLoad(){ //��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
	}
	public void ConnectionCreate() {//��������
		try {
			cnn = DriverManager.getConnection(uri, user, password);
			System.out.println("-----���ݿ����ӳɹ�������������ݿ�Ԫ����------");
			System.out.println("�û�����"+cnn.getMetaData().getUserName());
			System.out.println("���ݿ�����"+cnn.getMetaData().getDatabaseProductName());
			System.out.println("���ݿ�汾�ţ�"+cnn.getMetaData().getDatabaseProductVersion());
			System.out.println("���ݿ�������������"+cnn.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�");
		}
	}
	 public static void main(String[] args) {
			JDBC jdb=new JDBC();
			jdb.DriveLoad();
			jdb.ConnectionCreate();
		}
}
