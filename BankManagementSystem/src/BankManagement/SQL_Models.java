package BankManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * 实现连接数据库并对数据库进行相关操作  
 * @author: LMY
 * @date:   2021年1月8日 上午9:02:31
 */
public class SQL_Models extends User {
	String uri = "jdbc:mysql://localhost:3306/bankmanegementsystem?useSSL=true";//数据库连接地址
	String user = "root"; //数据库登录名
	String password = "12345"; //数据库登录密码
	String sql = null;//数据库操作语句
	PreparedStatement ps = null;//把查询，删除，更新等操作给ps
	Connection cnn = null;//连接
	/**
	 * 
	 * 加载数据库驱动  
	 * @return: void
	 */
	public void DriveLoad(){ //加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
	}
	/**
	 * 
	 * 创建与数据库的连接 
	 * @return: void
	 */
	public void ConnectionCreate() {//建立连接
		try {
			cnn = DriverManager.getConnection(uri, user, password);
			System.out.println("数据库连接成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库失败！");
		}
	}
	/**
	 * 
	 * 向数据库进行数据的插入操作  
	 * @return: void
	 */
	public void Data_Insert() {//数据插入
		try {
			sql = "insert into BankUser values(?,?,?,?,?,?)";//SQL语句
			ps = cnn.prepareStatement(sql);//预处理
			ps.setString(1, ID);
    		ps.setString(2, userName);
    		ps.setString(3, userPassword);
    		ps.setString(4, firstTime);
    		ps.setString(5, idNumber);
    		ps.setString(6, accountBalance);
    		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("拆入数据失败！");
		}
	}
	/**
	 * 
	 * 对数据库进行数据的删除  
	 * @return: void
	 */
	public void Data_Delete() {//数据删除
		
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
	 * 对数据库的数据进行修改  
	 * @param a 修改指令     
	 * @return: void
	 */
	public void Data_Alter(int a) {//修改：a为操作指令
		try {
			if(a==3) {//修改密码
				sql = "update BankUser set userPassword="+"'"+userPassword+"'"+" where ID="+"'"+ID+"'";
				System.out.println(1);
			}
			if(a==6) {//修改余额
				sql = "update BankUser set accountBalance="+"'"+accountBalance+"'"+" where ID="+"'"+ID+"'";
			}
			ps = cnn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("修改操作失败！");
		}
	}
	/**
	 * 
	 * 读取数据库的最后一条数据用来创建ID        
	 * @return: void
	 */
	//按升序取最后一条数据
	public void End_Data() {
		
		try {
			sql = "select * from BankUser";
			ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.last();//指向最后一条数据
			ID = rs.getString(1);
			System.out.println(1);
		} catch (SQLException e) {
			ID = "";
			userPassword="";
		}
			
	}
	/**
	 * 
	 * 查询数据库数据，账号是否存在        
	 * @return: void
	 */
	//在数据库中查询已有账号
	public void Data_Lookup() {
	    	try {
	    		sql="select * from BankUser where ID ='"+ID+"'";
	        	ps=cnn.prepareStatement(sql);
	     		rs=ps.executeQuery();
	     		rs.next();//指向有数据的第一行
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
     * 保存日志， 将用户的主要操作写入数据库  
	 * @param id 账号
	 * @param Dowhat 主要操作     
	 * @return: void
	 */
	//创建日志并写入数据库
	public void SaveLog(String id,String Dowhat) {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String Time = time.format(new Date());//获取当前系统时间
		try {
			sql = "insert into Log values(?,?,?)";//SQL语句
			ps = cnn.prepareStatement(sql);//预处理
			ps.setString(1, id);
    		ps.setString(2, Time);
    		ps.setString(3, Dowhat);
    		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("拆入数据失败！");
		}
	}
	/**
	 * 
	 * 从数据库读取所有用户信息     
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
	 * 读取存在数据库的日志数据        
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
	 * 关闭与数据库的所有连接        
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
