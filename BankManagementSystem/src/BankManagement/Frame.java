package BankManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * 创建一个GUI界面  
 * @author: LMY
 * @date:   2021年1月8日 上午10:36:36
 */
@SuppressWarnings("serial")
class Frame extends JFrame implements ActionListener {
	WindowCreate WCreate;// 界面组件初始化
	Container Cner;// 容器承载器
	SQL_Models sql_Models;
	String arr[]= {"账号","姓名","用户密码","开户时间","身份证号","余额"};
	Object[][] u=null;
	String Log1[] = {"账号","时间","事件"};
	Object Log2[][] = null;
	ImageIcon img1 = new ImageIcon("G:\\图片\\ok.png");
	ImageIcon img2 = new ImageIcon("G:\\图片\\yh.psd");
	ImageIcon img3 = new ImageIcon("G:\\图片\\M.png");
	JLabel Ok = new JLabel(img1);
	JLabel HY = new JLabel("银行欢迎你");
	JLabel Manager = new JLabel("Manager");
	Icon icon = new ImageIcon("G:\\图片\\20101.jpg");
	JLabel bg = new JLabel(icon);
	
	// 登录界面组件
	JTextField TextField_Login_Id;// 账号文本框
	JPasswordField PasswordField_Login_Password; // 密码文本框
	JButton Button_Login_Login; // 登录按钮
	JButton Button_Login_Exit; // 退出按钮
	JLabel Label_Login_Title; // 登录界面标签
	JLabel Label_Login_Id; // 账号标签
	JLabel Label_Login_Password; // 密码标签
	JLabel Label_Login_Reminder; // 提示标签
	JCheckBox jCheckBox1; // 复选框
	JMenuBar Bar = new JMenuBar();
	JMenu Help = new JMenu("帮助");
	JMenu About = new JMenu("关于");
	// 管理员界面组件
	JButton Button_Manager_Open;// 开户按钮
	JButton Button_Manager_Delete;// 销户按钮
	JButton Button_Manager_Back;// 返回按钮
	JButton Button_Manager_Exit;// 退出按钮
	JButton Button_Manager_Select;
	JButton Button_Manager_Log;
	JButton Button_Manager_Select1;
	JLabel Label_Manager_Title1;
	// 用户界面组件
	JButton Button_User_Select;// 查询
	JButton Button_User_Deposit;// 存款
	JButton Button_User_Withdrawal;// 取款
	JButton Button_User_Transfer;// 转账
	JButton Button_User_ChangePassword;// 改密
	JButton Button_User_Back;// 返回
	JLabel Label_User_Icon;// 标签1
	// 查询界面组件
	JLabel Label_Select_Id;// 账户标签
	JLabel Label_Select_Name;// 姓名标签
	JLabel Label_Select_Balance;// 余额标签
	JLabel Label_Select_IdNumber;// 身份证号标签
	JLabel Label_Select_FirstTime;// 开户时间标签
	JButton Button_Select_Back;// 返回按钮
	JButton Button_Select_Exit;// 退出按钮
	// 存取款界面组件
	JTextField TextField_D$W_Money;// 输入金额文本框
	JButton Button_D$W_Back;// 返回按钮
	JButton Button_D$W_Confirm;// 退出按钮
	JButton Button_D$W_Exit;// 退出按钮
	JLabel Label_D$W_Title;// 金额标签
	JLabel Label_D$W_Reminder;// 存取款提示信息标签
	// 改密界面组件
	JButton Button_Change_Back;// 返回按钮
	JButton Button_Change_Exit;// 退出按钮
	JButton Button_Change_Confirm;// 确定按钮
	JPasswordField NewPassword1;// 密码文本框1
	JPasswordField NewPassword2;// 密码文本框2
	JLabel Label_Change1;// 密码提示标签1
	JLabel Label_Change2;// 密码提示标签2
	JLabel Label_Change_Reminder;// 修改提示
	// 转账界面1组件
	JTextField TextField_Transfer_Id;// 转账账号文本框
	JTextField TextField_Transfer_Money;// 转账金额文本框
	JButton Button_Transfer_Back;// 返回按钮
	JButton Button_Transfer_Confirm;// 确定按钮
	JLabel Label_Transfer_Id;// 转账账号标签
	JLabel Label_Transfer_Money;// 转账金额标签
	// 转账界面2组件
	JButton Button_Transfer2_Back;// 返回按钮
	JButton Button_Transfer2_Confirm;// 确认按钮
	JButton Button_Transfer2_Exit;// 退出按钮
	JLabel Label_Transfer2_Title;// 标签
	JLabel Label_Transfer2_Name;// 账户姓名标签
	JLabel Label_Transfer2_Id;// 账户ID标签
	JLabel Label_Transfer2_Money;// 转账金额标签
	JLabel Label_Transfer2_Reminder;// 转账提示标签
	// 开户界面1组件
	JButton Button_Open1_Back;// 返回按钮
	JButton Button_Open1_Confirm;// 确认按钮
	JLabel Label_Open1_Name;// 姓名标签
	JLabel Label_Open1_Password;// 密码标签1
	JLabel Label_Open1_Password2;// 密码标签2
	JLabel Label_Open1_Money;// 预存金额标签
	JLabel Label_Open1_IdNumber;// 身份证号标签
	JLabel Label_Open1_Reminder;// 开户提示标签
	JTextField TextField_Open1_Name;// 姓名文本框
	JPasswordField PasswordField1_Open1;// 密码文本框1
	JPasswordField PasswordField2_Open1;// 密码文本框2
	JTextField TextField_Open1_Money;// 金额文本框
	JTextField TextField_Open1_IdNumber;// 身份证号文本框
	// 开户界面2组件
	JLabel Label_Open2_Title;// 标签
	JLabel Label_Open2_Id;// 账号标签
	JLabel Label_Open2_Name;// 姓名标签
	JLabel Label_Open2_Money;// 金额标签
	JLabel Label_Open2_IdNumber;// 身份证号标签
	JLabel Label_Open2_FistTime;// 开户时间标签
	JButton Button_Open2_Back;// 返回按钮
	JButton Button_Open2_Confirm;// 确认按钮
	JButton Button_Open2_Exit;// 退出按钮
	// 销户界面组件
	JButton Button_Delete_Back;// 返回按钮
	JButton Button_Delete_Confirm;// 确认按钮
	JButton Button_Delete_Exit;// 退出按钮
	JLabel Label_Delete_Title;
	JLabel Label_Delete_Id;// ID标签
	JLabel Label_Delete_Password;// 密码标签
	JLabel Label_Delete_Reminder1;// 销户提示标签
	JLabel Label_Delete_Reminder2;// 销户提示标签
	JTextField TextField_Delete_Id;// ID文本框
	JPasswordField PasswordField_Delete_Password;// 密码文本框
	//管理员查看用户界面组件
	JTable Select2_Table;
	JScrollPane Select2_Scroll;
	DefaultTableModel model;//模板
	JButton Select2_Back;
	JButton Select2_Exit;
	JScrollPane jScrollPane;
	//日志界面组件
	JTable Log_Table;
	JScrollPane Log_JS;
	DefaultTableModel model1;//模板
	JButton Log_Back;
	JButton Log_Exit;
	JScrollPane jScrollPane2;
	//容器界面
	JPanel Panel_Login;// 登录界面
	JPanel Panel_User_Function;// 用户功能界面
	JPanel Panel_Administrator_Function;// 管理员功能界面
	JPanel Panel_Transfer;// 转账界面1
	JPanel Panel_Transfer2;// 转账界面2
	JPanel Panel_Select;//查询界面
	JPanel Panel_D$W;//存取款界面
	JPanel Panel_Change;//用户改密界面
	JPanel Panel_Open1;//开户界面1
	JPanel Panel_Open2;//开户界面2
	JPanel Panel_Delete;//销户界面
	JPanel Panel_Select2;//用户信息界面
	JPanel Panel_Log;//日志界面
	JPanel Panel_bg = new JPanel();
	// 账户参数
	String id;
	String firsttime;
	String name;
	String balance;
	String idnumber;
	String password;
	//构造方法
	/**
	 * 设置frame的格式
	 */
	public Frame() {
		super("银行管理系统");
		//菜单栏
		Bar.add(Help);
		Bar.add(About);
		Bar.setOpaque(false);
		this.setJMenuBar(Bar);
		Frame_Login();
		Cner = super.getContentPane();
		Cner.setLayout(null);// 空布局
		//设置Frame的背景图
		((JPanel)this.getContentPane()).setOpaque(false);
	    bg=new JLabel(icon);
	    this.add(bg);
	    this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE)); //把背景图片添加到分层窗格的最底层作为背景
	    bg.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
	     		
		this.setBackground(Color.WHITE);
		this.setBounds(520, 170, 600, 400);// 位置加大小；
		this.setResizable(false);// 固定窗口大小；
		this.setVisible(true);// 设置窗口为可见的；
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭按钮；
		Cner.add(Panel_Login);
		Help.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /c start file:///C:/Users/12608/eclipse-workspace/BankManagementSystem/doc/BankManagement/package-summary.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		About.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new about();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	/**
	 * 
	 * 登录界面,加载登录界面的组件并设置其中的监听功能 
	 * @return: void
	 */
	// 将登录界面组件加入容器中
	public void Frame_Login() {
		WCreate = new WindowCreate();
		// 建立文本框
		TextField_Login_Id = WCreate.setFiled(180, 100, 200, 30, "", Color.WHITE, true);
		PasswordField_Login_Password = WCreate.setPasswordFiled(180, 160, 200, 30, "", true);
		// 建立按钮
		Button_Login_Login = WCreate.setButton(200, 250, 60, 40, "登录");
		Button_Login_Exit = WCreate.setButton(300, 250, 60, 40, "退出");
		// 建立标签
		Label_Login_Title = WCreate.setLabel(210, 30, 150, 100, "银行账户登录界面");
		Label_Login_Id = WCreate.setLabel(113, 85, 100, 60, "账号");
		Label_Login_Password = WCreate.setLabel(113, 145, 100, 60, "密码");
		Label_Login_Reminder = WCreate.setLabel(210, 200, 200, 60, "");
		// 建立复选框
		jCheckBox1 = WCreate.setJCheckBox(225, 300, 119, 20, "管理员账户登录");
		
		
		
		Panel_Login = WCreate.setPanel(0, 0, 600, 400,Color.WHITE);
		// 向登录容器中加入组件
		Panel_Login.add(Label_Login_Title);
		Panel_Login.add(Label_Login_Id);
		Panel_Login.add(TextField_Login_Id);
		Panel_Login.add(Label_Login_Password);
		Panel_Login.add(PasswordField_Login_Password);
		Panel_Login.add(Label_Login_Reminder);
		Panel_Login.add(Button_Login_Login);
		Panel_Login.add(Button_Login_Exit);
		Panel_Login.add(jCheckBox1);
		Button_Login_Exit.addActionListener(this);
		Button_Login_Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  if(jCheckBox1.isSelected()==true) {//管理员登录
					  if(String.valueOf(PasswordField_Login_Password.getPassword()).equals("999999")) {
						  Frame_Administrator();
						  Panel_Login.setVisible(false); 
						  Cner.add(Panel_Administrator_Function);
					  }
					  else {
						  Label_Login_Reminder.setText("密码错误，请重新输入");
						  PasswordField_Login_Password.setText("");
					  }
					  
				  }else {//用户登录
					  sql_Models = new SQL_Models(); 
					  sql_Models.DriveLoad();//加载驱动器
					  sql_Models.ConnectionCreate();//建立连接
					  sql_Models.setID(TextField_Login_Id.getText()); 
					  sql_Models.Data_Lookup();//取出用户信息，并赋值给sql_Models对象
					  if(String.valueOf(PasswordField_Login_Password.getPassword()).equals(sql_Models.getUserPassword())) {
						  Label_Login_Reminder.setText("登录成功，欢迎你的光临！"); 
						  name=sql_Models.getUserName();
						  password=String.valueOf(PasswordField_Login_Password.getPassword());
						  firsttime=sql_Models.getFirstTime(); 
						  idnumber=sql_Models.getIdNumber();
						  balance=sql_Models.getAccountBalance(); 
						  
						  sql_Models.SaveLog(TextField_Login_Id.getText(), "登录系统");
						  
						  Panel_Login.setVisible(false);
						  Frame_User();
						  Cner.add(Panel_User_Function);
						  
					  }
					  else if(sql_Models.getID().equals("null")) {
						  Label_Login_Reminder.setText("账号错误，请重新输入");
						  TextField_Login_Id.setText("");
						  PasswordField_Login_Password.setText("");
					  }
					  else {
						  Label_Login_Reminder.setText("密码错误，请重新输入");
						  PasswordField_Login_Password.setText("");
					  }
					  }
				 

			}

		});
		jCheckBox1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(e.getSource()==jCheckBox1) {//复选框判定管理员和用户
					if(jCheckBox1.isSelected()==true) {
						Label_Login_Reminder.setText("");
						TextField_Login_Id.setText("007");
						//PasswordField_Login.setText("123456");
						Label_Login_Title.setText("管理员账户登录界面");
						TextField_Login_Id.setEditable(false);
						PasswordField_Login_Password.setEditable(true);
					}
					else{
						if(Label_Login_Title.getText().equals("银行账户登录界面")) {
							
						}
						else {
						Label_Login_Title.setText("银行账户登录界面");
						TextField_Login_Id.setEditable(true);
						PasswordField_Login_Password.setEditable(true);
						TextField_Login_Id.setText("");
						PasswordField_Login_Password.setText("");}
					}
				}
			}
		});
	}
	/**
	 * 
	 * 加载用户界面组件并设置监听功能     
	 * @return: void
	 */
	//用户功能界面
	public void Frame_User() {
		//按钮
		Button_User_Select = WCreate.setButton(50, 40, 90, 60, "查询");// 查询
		Button_User_Deposit = WCreate.setButton( 50,140,90,60,"存款");;// 存款
		Button_User_Withdrawal = WCreate.setButton( 450,138,90,60,"取款");// 取款
		Button_User_Transfer = WCreate.setButton(450,238,90,60,"转账");// 转账
		Button_User_ChangePassword = WCreate.setButton(450,38,90,60,"改密");// 改密
		Button_User_Back = WCreate.setButton(50,240,90,60,"返回");// 返回
		HY = WCreate.setLabel(180,120,300,100,"银行欢迎你");
		HY.setFont(new Font("Dialog", 1, 45));
		//建立卡片
		Panel_User_Function = WCreate.setPanel(0, 0, 600, 400,Color.WHITE);
		
		Panel_User_Function.add(Button_User_Select);
		Panel_User_Function.add(Button_User_Deposit);
		Panel_User_Function.add(Button_User_Withdrawal);
		Panel_User_Function.add(Button_User_Transfer);
		Panel_User_Function.add(Button_User_ChangePassword);
		Panel_User_Function.add(Button_User_Back);
		Panel_User_Function.add(HY);
		
		Button_User_Select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_Select();
				Panel_User_Function.setVisible(false);
				Cner.add(Panel_Select);
				Label_Select_Id.setText("账户号："+TextField_Login_Id.getText());
			    Label_Select_Name.setText("账户名称："+name);
			    Label_Select_Balance.setText("账户余额："+balance);
			    Label_Select_IdNumber.setText("身份证号："+idnumber);
			    Label_Select_FirstTime.setText("开户日期："+firsttime);
			}
			
		});
		Button_User_Deposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_D$W();
				Panel_User_Function.setVisible(false);				
				Cner.add(Panel_D$W);
				Label_D$W_Title.setText("请输入存款金额");
			}
		});
		Button_User_Withdrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_User_Function.setVisible(false);
				Frame_D$W();
				Cner.add(Panel_D$W);
				Label_D$W_Title.setText("请输入取款金额");
			}
			
		});
		Button_User_Transfer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_Transfer1();
				Panel_User_Function.setVisible(false);
				Cner.add(Panel_Transfer);
			}
			
		});
		Button_User_ChangePassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_Change();
				Panel_User_Function.setVisible(false);
				Cner.add(Panel_Change);
			}
			
		});
		Button_User_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_User_Function.setVisible(false);
				Panel_Login.setVisible(true);
				TextField_Login_Id.setText("");
				PasswordField_Login_Password.setText("");
				Label_Login_Reminder.setText("");
			}
		});
	}
	/**
	 *  管理员界面 ， 加载管理员界面并设置监听功能 
	 * @return: void
	 */
	//管理员功能界面
	public void Frame_Administrator() {
		//按钮
		Button_Manager_Back = WCreate.setButton( 50,240,90,60,"返回");
		Button_Manager_Exit = WCreate.setButton(450,240,90, 60, "退出");
		Button_Manager_Delete = WCreate.setButton( 450,140,90,60, "销户");
		Button_Manager_Open = WCreate.setButton(50,140,90,60, "开户");
		Button_Manager_Select = WCreate.setButton(50, 40, 90, 60, "客户信息");
		Button_Manager_Log = WCreate.setButton(450,38,90,60,"查询日志");
		//标签
		Label_Manager_Title1 = WCreate.setLabel(190,20,300,100,"欢迎进入管理员界面");
		Label_Manager_Title1.setFont(new Font("Dialog", 1, 22));
		Manager.setBounds(170, 120, 280, 80);
		Manager.setFont(new Font("Dialog", 1, 60));
		//建立卡片
		Panel_Administrator_Function = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		
		Panel_Administrator_Function.add(Button_Manager_Back);
		Panel_Administrator_Function.add(Button_Manager_Delete);
		Panel_Administrator_Function.add(Button_Manager_Exit);
		Panel_Administrator_Function.add(Button_Manager_Open);
		Panel_Administrator_Function.add(Button_Manager_Select);
		Panel_Administrator_Function.add(Label_Manager_Title1);
		Panel_Administrator_Function.add(Manager);
		Panel_Administrator_Function.add(Button_Manager_Log);
		
		Button_Manager_Open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Frame_Open1();
				 Panel_Administrator_Function.setVisible(false); 
				 Cner.add(Panel_Open1);
			}
		});
		Button_Manager_Delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Frame_Delete();
				 Panel_Administrator_Function.setVisible(false);
				 Cner.add(Panel_Delete);
			}
		});
		Button_Manager_Select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_Select2();
				Panel_Administrator_Function.setVisible(false);
				Cner.add(Panel_Select2);
			}
			
		});
		Button_Manager_Log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Look_Log();
				Panel_Administrator_Function.setVisible(false);
				Cner.add(Panel_Log);
			}
			
		});
		Button_Manager_Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Panel_Administrator_Function.setVisible(false);
				 Panel_Login.setVisible(true);
				 jCheckBox1.setSelected(false);
			}
		});
		Button_Manager_Exit.addActionListener(this);
	}
	/**
	 *用户查看信息功能， 加载用户查看信息功能并设置监听功能  
	 * @return: void
	 */
	//查询功能界面
	public void Frame_Select() {
		//按钮
		Button_Select_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		Button_Select_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		//标签
		Label_Select_Id = WCreate.setLabel(200, 30, 300, 100, "");
		Label_Select_Name = WCreate.setLabel(200, 60, 300, 100, "");
		Label_Select_Balance = WCreate.setLabel(200, 90, 300, 100, "");
		Label_Select_IdNumber = WCreate.setLabel(200, 120, 300, 100, "");
		Label_Select_FirstTime = WCreate.setLabel(200, 150, 300, 100, "");
		//建立卡片	
		Panel_Select = WCreate.setPanel(0,0, 600, 400,Color.WHITE);
		
		Panel_Select.add(Label_Select_Id);
		Panel_Select.add(Label_Select_Name);
		Panel_Select.add(Label_Select_Balance);
		Panel_Select.add(Label_Select_IdNumber);
		Panel_Select.add(Label_Select_FirstTime);
		Panel_Select.add(Button_Select_Back);
		Panel_Select.add(Button_Select_Exit);
		
		Button_Select_Exit.addActionListener(this);
		Button_Select_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Select.setVisible(false);
				Panel_User_Function.setVisible(true);
			}
			
		});
	}
	/**
	 *用户改密界面，加载用户修改密码界面并设置监听功能  
	 * @return: void
	 */
	//改密功能界面
	public void Frame_Change() {
		 //按钮
		 Button_Change_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		 Button_Change_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		 Button_Change_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		 //标签
		 Label_Change1 = WCreate.setLabel(200, 30, 150, 100, "请输入您的新密码");
		 Label_Change2 = WCreate.setLabel(200, 100, 150, 100, "请请再次输入新密码");
		 Label_Change_Reminder = WCreate.setLabel(200, 170, 200, 100, "");
		 //文本框
		 NewPassword1 = WCreate.setPasswordFiled(180, 100, 200, 30,"",true);
		 NewPassword2 = WCreate.setPasswordFiled(180, 170, 200, 30,"",true);
		 //建立卡片
		 Panel_Change = WCreate.setPanel(0, 0, 600, 400,Color.WHITE);
		 
		 Panel_Change.add(Button_Change_Back);
		 Panel_Change.add(Button_Change_Confirm);
		 Panel_Change.add(Button_Change_Exit);
		 Panel_Change.add(Label_Change1);
		 Panel_Change.add(Label_Change2);
		 Panel_Change.add(NewPassword1);
		 Panel_Change.add(NewPassword2);
		 Panel_Change.add(Label_Change_Reminder);
		 
		 Button_Change_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Change.setVisible(false);
				Panel_User_Function.setVisible(true);
			} 
		 });
		 Button_Change_Confirm.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(NewPassword1.getPassword())
						.equals(String.copyValueOf(NewPassword2.getPassword()))) {
					if(String.copyValueOf(NewPassword1.getPassword()).equals(password)) {
						Label_Change_Reminder.setText("新密码与当前密码相同");
					}
					else {
						
						sql_Models.Change_Password(TextField_Login_Id.getText(),String.valueOf(NewPassword1.getText()));
						Label_Change_Reminder.setText("密码修改成功");
						password = String.valueOf(NewPassword1.getPassword());
						
						sql_Models.SaveLog(TextField_Login_Id.getText(), "将密码修改为："+password);
						
						Button_Change_Confirm.setVisible(false);
						Label_Change1.setVisible(false);
						Label_Change2.setVisible(false);
						NewPassword1.setVisible(false);
						NewPassword2.setVisible(false);
					}
				}
				else {
					Label_Change_Reminder.setText("两次密码输入不一致，请核对");
				}
			}
			 
		 });
		 Button_Change_Exit.addActionListener(this);
	}
	/**
	 * 转账功能1界面  ， 加载用户转账功能1界面并设置监听功能 
	 * @return: void
	 */
	//转账功能界面1
	public void Frame_Transfer1() {
		//文本框
		 TextField_Transfer_Id = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);
		 TextField_Transfer_Money = WCreate.setFiled(180, 200, 200, 30,"", Color.WHITE,true);
		 //标签
		 Label_Transfer_Id = WCreate.setLabel(200, 30, 150, 100, "请输入你的转账账号" );
		 Label_Transfer_Money = WCreate.setLabel(200, 130, 150, 100, "请输入您的转账金额");
		 //按钮
		 Button_Transfer_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		 Button_Transfer_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		 //建立卡片
		 Panel_Transfer = WCreate.setPanel(0,0, 600, 400,Color.WHITE);
		 
		 Panel_Transfer.add(Button_Transfer_Confirm);
		 Panel_Transfer.add(Button_Transfer_Back);
		 Panel_Transfer.add(Label_Transfer_Id);
		 Panel_Transfer.add(Label_Transfer_Money);
		 Panel_Transfer.add(TextField_Transfer_Money);
		 Panel_Transfer.add(TextField_Transfer_Id);
		 
		 Button_Transfer_Back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Transfer.setVisible(false);
				Panel_User_Function.setVisible(true);
			} 
		 });
		 Button_Transfer_Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sql_Models.setID(TextField_Transfer_Id.getText());
				sql_Models.Data_Lookup();
				Panel_Transfer.setVisible(false);
				Frame_Transfer2();
				Cner.add(Panel_Transfer2);
				try {
					if(sql_Models.getID().equals("null")||sql_Models.getID().equals(TextField_Login_Id.getText())) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("账户有误，返回核对");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())>20000) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("转账金额超额");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())>Integer.parseInt(balance)) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("余额不足");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())<0) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("金额不能为负数");
					}
					else {
						String name = sql_Models.getUserName();
						if(name.length()>=2&&name.length()<4) {
							Label_Transfer2_Name.setText("转入姓名："+name.replace(name.charAt(1),'*'));
						}
						else if(name.length()>=4) {
							Label_Transfer2_Name.setText("转入姓名："+name.replace(name.charAt(2),'*'));
						}
						else {
							Label_Transfer2_Name.setText("转入姓名："+name);
						}
						Label_Transfer2_Id.setText("转入账号： "+TextField_Transfer_Id.getText());
						Label_Transfer2_Money.setText("转入金额： "+TextField_Transfer_Money.getText());
					}
				}catch(Exception n) {
					Label_Transfer2_Title.setVisible(false);
					 Button_Transfer2_Confirm.setVisible(false);
					 Label_Transfer2_Reminder.setText("转账金额输入有误");
				}
			} 
		 });
	} 
	/**
	 *  转账功能2界面， 为转账功能2界面加入组件并设置监听事件
	 * @return: void
	 */
	//转账功能界面2
	public void Frame_Transfer2() {
		 //标签
		 Label_Transfer2_Title = WCreate.setLabel(225, 30, 150, 100, "请确认您的转账信息" );
		 Label_Transfer2_Name = WCreate.setLabel(225, 60, 150, 100, "" );
		 Label_Transfer2_Id = WCreate.setLabel(225, 90, 150, 100, "");
		 Label_Transfer2_Money = WCreate.setLabel(225, 120, 150, 100, "");
		 Label_Transfer2_Reminder = WCreate.setLabel(225, 150, 150, 100, "");
		 //按钮
		 Button_Transfer2_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		 Button_Transfer2_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		 Button_Transfer2_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		//建立卡片
		 Panel_Transfer2 = WCreate.setPanel(0,0, 600, 400,Color.WHITE);
		 
		 Panel_Transfer2.add(Button_Transfer2_Back);
		 Panel_Transfer2.add(Button_Transfer2_Confirm);
		 Panel_Transfer2.add(Button_Transfer2_Exit);
		 Panel_Transfer2.add(Label_Transfer2_Title);
		 Panel_Transfer2.add(Label_Transfer2_Name);
		 Panel_Transfer2.add(Label_Transfer2_Id);
		 Panel_Transfer2.add(Label_Transfer2_Money);
		 Panel_Transfer2.add(Label_Transfer2_Reminder);
		 
		 Button_Transfer2_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Label_Transfer2_Reminder.getText().equals("转账成功")) {
					 Panel_Transfer2.setVisible(false);
					 Panel_User_Function.setVisible(true);
				 }
				 else {
					 Panel_Transfer2.setVisible(false);
					 Panel_Transfer.setVisible(true);
				 }
			}
		 });
		 Button_Transfer2_Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sql_Models.Transfer(TextField_Login_Id.getText(), TextField_Transfer_Id.getText(), balance,sql_Models.getAccountBalance(), TextField_Transfer_Money.getText());
				Label_Transfer2_Reminder.setText("转账成功");
				
				sql_Models.SaveLog(TextField_Login_Id.getText(),"向账号："+TextField_Transfer_Id.getText()+"转入"+TextField_Transfer_Money.getText()+"元");
				
				balance=String.valueOf(Integer.parseInt(balance)-Integer.parseInt(TextField_Transfer_Money.getText()));
				Button_Transfer2_Confirm.setVisible(false);
			} 
		 });
		 Button_Transfer2_Exit.addActionListener(this);
	}
	/**
	 * 存取款功能界面 ， 为存取款界面加入组件并设置监听事件
	 * @return: void
	 */
	//存取款功能界面
	public void Frame_D$W() {
		Button_D$W_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		Button_D$W_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		Button_D$W_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		Label_D$W_Title = WCreate.setLabel(225, 30, 150, 100, "");
		Label_D$W_Reminder = WCreate.setLabel(225, 150, 150, 100, "");
		TextField_D$W_Money = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);
		
		Ok.setBounds(225, 80, 100, 80);
		Ok.setVisible(false);
		//建立卡片
		Panel_D$W=WCreate.setPanel(0,0, 600, 400,Color.WHITE);
		
		Panel_D$W.add(Button_D$W_Back);
		Panel_D$W.add(Button_D$W_Confirm);
		Panel_D$W.add(Button_D$W_Exit);
		Panel_D$W.add(Label_D$W_Title);
		Panel_D$W.add(Label_D$W_Reminder);
		Panel_D$W.add(TextField_D$W_Money);
		Panel_D$W.add(Ok);
		
		Button_D$W_Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_D$W.setVisible(false);
				Panel_User_Function.setVisible(true);
			}
		});
		Button_D$W_Confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					 if(Label_D$W_Title.getText().equals("请输入取款金额")) {
						 if(Integer.parseInt(TextField_D$W_Money.getText())>20000) {
							 Label_D$W_Reminder.setText("金额不能超出限额");
						 }
						 else if(Integer.parseInt(TextField_D$W_Money.getText())>Integer.parseInt(balance)) {
							 Label_D$W_Reminder.setText("账户余额不足");
						 }
						 else if(Integer.parseInt(TextField_D$W_Money.getText())<0)
							 Label_D$W_Reminder.setText("金额不能为负数，请重新输入");
						 else {
							 sql_Models.Withdrawal(TextField_Login_Id.getText(), balance,TextField_D$W_Money.getText());
							 balance=String.valueOf(Integer.parseInt(balance)-Integer.parseInt(TextField_D$W_Money.getText()));
							 Label_D$W_Reminder.setText("您的取款金额为"+TextField_D$W_Money.getText());
							 Button_D$W_Confirm.setVisible(false);
							 Label_D$W_Title.setText("取款成功");
							 Ok.setVisible(true);
							 
							 sql_Models.SaveLog(TextField_Login_Id.getText(), "取出"+TextField_D$W_Money.getText()+"元");
							 
							 Label_D$W_Title.setBounds(260,120, 150, 100);
							 TextField_D$W_Money.setVisible(false);
						 }
					 }
					 else if(Label_D$W_Title.getText().equals("请输入存款金额")){
						 if(Integer.parseInt(TextField_D$W_Money.getText())<0)
							 Label_D$W_Reminder.setText("金额不能为负数，请重新输入");
						 else if(Integer.parseInt(TextField_D$W_Money.getText())>20000) {
							 Label_D$W_Reminder.setText("金额不能超出限额");
							 }
						 else {
							 sql_Models.Deposit(TextField_Login_Id.getText(), balance,TextField_D$W_Money.getText());
							 balance=String.valueOf(Integer.parseInt(balance)+Integer.parseInt(TextField_D$W_Money.getText()));
							 Label_D$W_Reminder.setText("您的存款金额为"+TextField_D$W_Money.getText());
							 Button_D$W_Confirm.setVisible(false);
							 Label_D$W_Title.setText("存款成功");
							 Ok.setVisible(true);
							 
							 sql_Models.SaveLog(TextField_Login_Id.getText(), "存入"+TextField_D$W_Money.getText()+"元");
							 
							 Label_D$W_Title.setBounds(260,120, 150, 100);
							 TextField_D$W_Money.setVisible(false);
						 }
					 }
					 }catch (Exception e1) {
						    Label_D$W_Reminder.setText("金额输入有误，请重新输入");
						    TextField_D$W_Money.setText("");
					}
			}
		});
		Button_D$W_Exit.addActionListener(this);
	}
	/**
	 *管理员开户界面1，为开户界面1加入组件并设置监听事件 
	 * @return: void
	 */
	//开户功能界面1
	public void Frame_Open1() {
		Button_Open1_Back = WCreate.setButton( 170,240,90,60,"返回");
		Button_Open1_Confirm = WCreate.setButton(380,240,90, 60, "确认");
		Label_Open1_Reminder = WCreate.setLabel(240, 200, 200, 60, " ");
		Label_Open1_Name = WCreate.setLabel(170, 20, 60, 40,"姓名");
		Label_Open1_Password = WCreate.setLabel(170, 60, 100, 40,"输入密码");
		Label_Open1_Password2 = WCreate.setLabel(170, 100, 100, 40,"再输入密码");
		Label_Open1_Money = WCreate.setLabel(170, 140, 100, 40,"预存");
		Label_Open1_IdNumber = WCreate.setLabel(170, 180, 100, 40,"身份证号");
		TextField_Open1_Name = WCreate.setFiled(250, 20, 200, 30,"",Color.white,true);
		PasswordField1_Open1 = WCreate.setPasswordFiled(250, 60, 200, 30,"",true);
		PasswordField2_Open1 = WCreate.setPasswordFiled(250, 100, 200, 30,"",true);
		TextField_Open1_Money = WCreate.setFiled(250, 140, 200, 30,"",Color.WHITE,true);
		TextField_Open1_IdNumber = WCreate.setFiled(250, 180, 200, 30,"",Color.WHITE,true);
		//建立卡片
		Panel_Open1 = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		
		Panel_Open1.add(Label_Open1_Reminder);
		Panel_Open1.add(Button_Open1_Back);
		Panel_Open1.add(Button_Open1_Confirm);
		Panel_Open1.add(Label_Open1_Name);
		Panel_Open1.add(Label_Open1_Password);
		Panel_Open1.add(Label_Open1_Password2);
		Panel_Open1.add(Label_Open1_Money);
		Panel_Open1.add(Label_Open1_IdNumber);
		Panel_Open1.add(TextField_Open1_Name);
		Panel_Open1.add(PasswordField1_Open1);
		Panel_Open1.add(PasswordField2_Open1);
		Panel_Open1.add(TextField_Open1_Money);
		Panel_Open1.add(TextField_Open1_IdNumber);
		
		Button_Open1_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Open1.setVisible(false);
				Panel_Administrator_Function.setVisible(true);
			}
		});
		Button_Open1_Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TextField_Open1_Name.getText().equals("")) {
					Label_Open1_Reminder.setText("姓名不能为空");
				}
				else {
					if(String.valueOf(PasswordField1_Open1.getPassword()).equals(String.valueOf(PasswordField2_Open1.getPassword()))) {
						if(String.valueOf(PasswordField1_Open1.getPassword()).equals("")) {
							Label_Open1_Reminder.setText("密码不能为空");
						}
						else {
							if(TextField_Open1_IdNumber.getText().equals("")) {
								Label_Open1_Reminder.setText("身份证号不能为空");
							}
							else {
								try {
										if(Integer.parseInt(TextField_Open1_Money.getText())<0) {
											Label_Open1_Reminder.setText("预存金额不能为负");
											TextField_Open1_Money.setText("");
										}
										else if(Integer.parseInt(TextField_Open1_Money.getText())>20000) {
												Label_Open1_Reminder.setText("预存金额超出限额<20000");
												TextField_Open1_Money.setText("");
										}
										else {
											   Label_Open1_Reminder.setText("");
								               Frame_Open2();
								               Panel_Open1.setVisible(false);
								               Cner.add(Panel_Open2);
								               sql_Models=new SQL_Models();
								               id=sql_Models.Create_ID();
								               if(id.equals("")) {
								            	   id="000001";
								            	   password=String.valueOf(PasswordField1_Open1.getPassword());
								            	   Label_Open2_Id.setText("账号   "+id);
								            	   name=TextField_Open1_Name.getText();
								            	   Label_Open2_Name.setText("姓名   "+name);
								            	   balance=TextField_Open1_Money.getText();
								            	   Label_Open2_Money.setText("预存   "+balance);
								            	   idnumber=TextField_Open1_IdNumber.getText();
								            	   Label_Open2_IdNumber.setText("身份证号   "+idnumber);
								            	   sql_Models.setFirstTime();
								            	   firsttime=sql_Models.getFirstTime();
								            	   Label_Open2_FistTime.setText("开户时间   "+firsttime);// new Date()为获取当前系统时间
								               	}
								               else {
								            	   password=String.valueOf(PasswordField1_Open1.getPassword());
								                   Label_Open2_Id.setText("账号   "+id);
								                   name=TextField_Open1_Name.getText();
								                   Label_Open2_Name.setText("姓名   "+name);
								                   balance=TextField_Open1_Money.getText();
								                   Label_Open2_Money.setText("预存   "+balance);
								                   idnumber=TextField_Open1_IdNumber.getText();
								                   Label_Open2_IdNumber.setText("身份证号   "+idnumber);
								                   sql_Models.setFirstTime();
								                   firsttime=sql_Models.getFirstTime();
								                   Label_Open2_FistTime.setText("开户时间   "+firsttime);// new Date()为获取当前系统时间
								               }
										}
									
								}catch(Exception e1) {
									Label_Open1_Reminder.setText("预存金额有误，请重新输入");
								}
							}
						}
					}
					else {
						Label_Open1_Reminder.setText("两次密码不一致，请重新输入");
					}
				}
				
			}
			
		});
	}
	/**
	 *  开户界面2 ， 为开户界面2加入组件并设置监听事件 
	 * @return: void
	 */
	//开户功能界面2
	public void Frame_Open2() {
		//标签
		 Label_Open2_Title = WCreate.setLabel(225, 30, 150, 100, "请确认您的开户信息");
		 Label_Open2_Id = WCreate.setLabel(225, 60, 150, 100, "" );
		 Label_Open2_Name = WCreate.setLabel(225, 90, 150, 100, "" );
		 Label_Open2_Money = WCreate.setLabel(225, 120, 150, 100, "");
		 Label_Open2_IdNumber = WCreate.setLabel(225, 150, 250, 100, "");
		 Label_Open2_FistTime = WCreate.setLabel(225, 180, 250, 100, "");
		 //按钮
		 Button_Open2_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		 Button_Open2_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		 Button_Open2_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		 //建立卡片
		 Panel_Open2 = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		 
		 Panel_Open2.add(Button_Open2_Back);
		 Panel_Open2.add(Button_Open2_Confirm);
		 Panel_Open2.add(Button_Open2_Exit);
		 Panel_Open2.add(Label_Open2_Title);
		 Panel_Open2.add(Label_Open2_Id);
		 Panel_Open2.add(Label_Open2_Name);
		 Panel_Open2.add(Label_Open2_Money);
		 Panel_Open2.add(Label_Open2_IdNumber);
		 Panel_Open2.add(Label_Open2_FistTime);	
		 
		 Button_Open2_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Label_Open2_Title.getText().equals("开户成功")) {
					 Panel_Open2.setVisible(false);
					 Panel_Administrator_Function.setVisible(true);
				}
				else {
						 Panel_Open2.setVisible(false);
						 Panel_Open1.setVisible(true);
				}   
				
			}
			 
		 });
		 Button_Open2_Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sql_Models.Open_Account(id, name, password, idnumber, balance);
				Label_Open2_FistTime.setText("");
				Label_Open2_Name.setText("");
				Label_Open2_Money.setText("");
				Label_Open2_IdNumber.setText("");
				Label_Open2_Id.setText("");
				Label_Open2_Title.setText("开户成功");
				Label_Open2_Title.setBounds(260,120, 150, 100);
				Button_Open2_Confirm.setVisible(false);	
				
			}	 
		 });
		 Button_Open2_Exit.addActionListener(this);
	}
	/**
     * 管理员销户界面， 为管理员销户界面添加组件并设置监听事件
	 * @return: void
	 */
	//销户功能界面
	public void Frame_Delete() {
		//建立文本框；
		TextField_Delete_Id = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);//位置，大小，文本，颜色，文本框编辑；
	    PasswordField_Delete_Password = WCreate.setPasswordFiled(180, 160, 200, 30,"", true);
		//建立按钮；
	    Button_Delete_Back = WCreate.setButton(200, 250, 60, 40,"返回");
		Button_Delete_Exit = WCreate.setButton(300, 250, 60, 40,"退出");
		Button_Delete_Confirm = WCreate.setButton(300, 250, 60, 40,"确认");
		//建立标签；
		Label_Delete_Title = WCreate.setLabel(210, 30, 150, 100, "请输入销户账户信息");
		Label_Delete_Id = WCreate.setLabel(113, 85, 100, 60, "账号");
		Label_Delete_Password = WCreate.setLabel(113, 145, 100, 60,"密码");
		Label_Delete_Reminder1 = WCreate.setLabel(190, 200, 200, 60, "");
		Label_Delete_Reminder2 = WCreate.setLabel(260,120, 150, 100, "");
		//创建卡片
		Panel_Delete = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		
		Panel_Delete.add(Button_Delete_Back);
		Panel_Delete.add(Button_Delete_Confirm);
		Panel_Delete.add(Button_Delete_Exit);
		Panel_Delete.add(Label_Delete_Title);
		Panel_Delete.add(Label_Delete_Id);
		Panel_Delete.add(Label_Delete_Password);
		Panel_Delete.add(Label_Delete_Reminder1);
		Panel_Delete.add(Label_Delete_Reminder2);
		Panel_Delete.add(TextField_Delete_Id);
		Panel_Delete.add(PasswordField_Delete_Password);
		
		Button_Delete_Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Delete.setVisible(false);
				 Panel_Administrator_Function.setVisible(true);
			}
		});
		Button_Delete_Confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					 sql_Models=new SQL_Models();
					 sql_Models.DriveLoad();
					 sql_Models.ConnectionCreate();
					 sql_Models.setID(TextField_Delete_Id.getText());
					 sql_Models.Data_Lookup();
					 password=sql_Models.getUserPassword();
					 if(password.equals(String.valueOf(PasswordField_Delete_Password.getPassword()))) {
						 sql_Models.AccountDelete(TextField_Delete_Id.getText());
						 Label_Delete_Reminder2.setText("销户成功");
						 Label_Delete_Id.setText("");
						 Label_Delete_Password.setText("");
						 Label_Delete_Title.setText("");
						 TextField_Delete_Id.setVisible(false);
						 PasswordField_Delete_Password.setVisible(false);
						 Button_Delete_Confirm.setVisible(false);
					 }
					 else {
						 Label_Delete_Reminder1.setText("密码错误，请重新输入");
						 PasswordField_Delete_Password.setText("");
					 }}catch (Exception n) {
						 Label_Delete_Reminder1.setText("账号有误，请重新输入");
						 TextField_Delete_Id.setText("");
						 PasswordField_Delete_Password.setText("");
					}	
			}
		});	
		Button_Delete_Exit.addActionListener(this);
	}
	/**
	 * 管理员查看用户信息功能，为管理员查看用户信息界面加入组件并设置监听功能
	 * @return: void
	 */
	//客户信息界面
	public void Frame_Select2() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		u = sql_Models.UserInfo() ;
		
		model = new DefaultTableModel(u,arr);
		Select2_Table = new JTable(model);
		

        //按比例设置单元格的列宽
		Select2_Table.getColumnModel().getColumn(0).setPreferredWidth(30);
		Select2_Table.getColumnModel().getColumn(1).setPreferredWidth(50);
		Select2_Table.getColumnModel().getColumn(2).setPreferredWidth(50);
		Select2_Table.getColumnModel().getColumn(3).setPreferredWidth(100);
		Select2_Table.getColumnModel().getColumn(4).setPreferredWidth(80);
		Select2_Table.getColumnModel().getColumn(5).setPreferredWidth(80);

		Select2_Table.getTableHeader().setReorderingAllowed(false); 
		Select2_Table.setEnabled(false);
		jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(Select2_Table);
		jScrollPane.setBounds(0, 0, 590,300);
		
		Select2_Back = WCreate.setButton(200, 300, 60, 40,"返回");
		Select2_Exit = WCreate.setButton(300, 300, 60, 40,"退出");
		Select2_Table.setBounds(0, 0, 600, 300);
		Select2_Table.setBackground(Color.white);;
		Panel_Select2 = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		
		Panel_Select2.add(jScrollPane,BorderLayout.CENTER);
		Panel_Select2.add(Select2_Back);
		Panel_Select2.add(Select2_Exit);
		
		Select2_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Select2.setVisible(false);
				Panel_Administrator_Function.setVisible(true);
			}
			
		});
		Select2_Exit.addActionListener(this);
	}
	/**
	 * 管理员查看日志功能， 为查看日志界面加载组件并设置监听事件 
	 * @return: void
	 */
	//日志功能界面
	public void Look_Log() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		Log2 = sql_Models.LogInfo() ;
		
		model1 = new DefaultTableModel(Log2,Log1);
		Log_Table = new JTable(model1);
		Log_Table.setGridColor(Color.BLACK);
		
		//按比例设置单元格的列宽
		Log_Table.getColumnModel().getColumn(0).setPreferredWidth(30);
		Log_Table.getColumnModel().getColumn(1).setPreferredWidth(110);
		Log_Table.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		Log_Table.getTableHeader().setReorderingAllowed(false); 
		Log_Table.setEnabled(false);
		Log_JS = new JScrollPane();
		Log_JS.setViewportView(Log_Table);
		Log_JS.setBounds(0, 0, 590,300);
		
		Log_Back = WCreate.setButton(200, 300, 60, 40,"返回");
		Log_Exit = WCreate.setButton(300, 300, 60, 40,"退出");
		Log_Table.setBounds(0, 0, 600, 300);
		Log_Table.setBackground(Color.white);;
		Panel_Log = WCreate.setPanel(0,0, 600, 400, Color.WHITE);
		
		Panel_Log.add(Log_JS,BorderLayout.CENTER);
		Panel_Log.add(Log_Back);
		Panel_Log.add(Log_Exit);
		
		Log_Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_Log.setVisible(false);
				Panel_Administrator_Function.setVisible(true);
				sql_Models.Resource_Shutdown();
			}
			
		});
		Log_Exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//退出按钮
		 if(e.getSource()==Button_Login_Exit||e.getSource()==Button_Transfer2_Exit
			||e.getSource()==Button_Select_Exit||e.getSource()==Button_D$W_Exit||e.getSource()==
			Button_Change_Exit||e.getSource()==Button_Delete_Exit||e.getSource()==Log_Exit
			||e.getSource()==Button_Open2_Exit||e.getSource()==Button_Manager_Exit||e.getSource()==Select2_Exit) {
			 
			 System.exit(0);
		 }
			 
	}
}
