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
 * ����һ��GUI����  
 * @author: LMY
 * @date:   2021��1��8�� ����10:36:36
 */
@SuppressWarnings("serial")
class Frame extends JFrame implements ActionListener {
	WindowCreate WCreate;// ���������ʼ��
	Container Cner;// ����������
	SQL_Models sql_Models;
	String arr[]= {"�˺�","����","�û�����","����ʱ��","���֤��","���"};
	Object[][] u=null;
	String Log1[] = {"�˺�","ʱ��","�¼�"};
	Object Log2[][] = null;
	ImageIcon img1 = new ImageIcon("G:\\ͼƬ\\ok.png");
	ImageIcon img2 = new ImageIcon("G:\\ͼƬ\\yh.psd");
	ImageIcon img3 = new ImageIcon("G:\\ͼƬ\\M.png");
	JLabel Ok = new JLabel(img1);
	JLabel HY = new JLabel("���л�ӭ��");
	JLabel Manager = new JLabel("Manager");
	Icon icon = new ImageIcon("G:\\ͼƬ\\20101.jpg");
	JLabel bg = new JLabel(icon);
	
	// ��¼�������
	JTextField TextField_Login_Id;// �˺��ı���
	JPasswordField PasswordField_Login_Password; // �����ı���
	JButton Button_Login_Login; // ��¼��ť
	JButton Button_Login_Exit; // �˳���ť
	JLabel Label_Login_Title; // ��¼�����ǩ
	JLabel Label_Login_Id; // �˺ű�ǩ
	JLabel Label_Login_Password; // �����ǩ
	JLabel Label_Login_Reminder; // ��ʾ��ǩ
	JCheckBox jCheckBox1; // ��ѡ��
	JMenuBar Bar = new JMenuBar();
	JMenu Help = new JMenu("����");
	JMenu About = new JMenu("����");
	// ����Ա�������
	JButton Button_Manager_Open;// ������ť
	JButton Button_Manager_Delete;// ������ť
	JButton Button_Manager_Back;// ���ذ�ť
	JButton Button_Manager_Exit;// �˳���ť
	JButton Button_Manager_Select;
	JButton Button_Manager_Log;
	JButton Button_Manager_Select1;
	JLabel Label_Manager_Title1;
	// �û��������
	JButton Button_User_Select;// ��ѯ
	JButton Button_User_Deposit;// ���
	JButton Button_User_Withdrawal;// ȡ��
	JButton Button_User_Transfer;// ת��
	JButton Button_User_ChangePassword;// ����
	JButton Button_User_Back;// ����
	JLabel Label_User_Icon;// ��ǩ1
	// ��ѯ�������
	JLabel Label_Select_Id;// �˻���ǩ
	JLabel Label_Select_Name;// ������ǩ
	JLabel Label_Select_Balance;// ����ǩ
	JLabel Label_Select_IdNumber;// ���֤�ű�ǩ
	JLabel Label_Select_FirstTime;// ����ʱ���ǩ
	JButton Button_Select_Back;// ���ذ�ť
	JButton Button_Select_Exit;// �˳���ť
	// ��ȡ��������
	JTextField TextField_D$W_Money;// �������ı���
	JButton Button_D$W_Back;// ���ذ�ť
	JButton Button_D$W_Confirm;// �˳���ť
	JButton Button_D$W_Exit;// �˳���ť
	JLabel Label_D$W_Title;// ����ǩ
	JLabel Label_D$W_Reminder;// ��ȡ����ʾ��Ϣ��ǩ
	// ���ܽ������
	JButton Button_Change_Back;// ���ذ�ť
	JButton Button_Change_Exit;// �˳���ť
	JButton Button_Change_Confirm;// ȷ����ť
	JPasswordField NewPassword1;// �����ı���1
	JPasswordField NewPassword2;// �����ı���2
	JLabel Label_Change1;// ������ʾ��ǩ1
	JLabel Label_Change2;// ������ʾ��ǩ2
	JLabel Label_Change_Reminder;// �޸���ʾ
	// ת�˽���1���
	JTextField TextField_Transfer_Id;// ת���˺��ı���
	JTextField TextField_Transfer_Money;// ת�˽���ı���
	JButton Button_Transfer_Back;// ���ذ�ť
	JButton Button_Transfer_Confirm;// ȷ����ť
	JLabel Label_Transfer_Id;// ת���˺ű�ǩ
	JLabel Label_Transfer_Money;// ת�˽���ǩ
	// ת�˽���2���
	JButton Button_Transfer2_Back;// ���ذ�ť
	JButton Button_Transfer2_Confirm;// ȷ�ϰ�ť
	JButton Button_Transfer2_Exit;// �˳���ť
	JLabel Label_Transfer2_Title;// ��ǩ
	JLabel Label_Transfer2_Name;// �˻�������ǩ
	JLabel Label_Transfer2_Id;// �˻�ID��ǩ
	JLabel Label_Transfer2_Money;// ת�˽���ǩ
	JLabel Label_Transfer2_Reminder;// ת����ʾ��ǩ
	// ��������1���
	JButton Button_Open1_Back;// ���ذ�ť
	JButton Button_Open1_Confirm;// ȷ�ϰ�ť
	JLabel Label_Open1_Name;// ������ǩ
	JLabel Label_Open1_Password;// �����ǩ1
	JLabel Label_Open1_Password2;// �����ǩ2
	JLabel Label_Open1_Money;// Ԥ�����ǩ
	JLabel Label_Open1_IdNumber;// ���֤�ű�ǩ
	JLabel Label_Open1_Reminder;// ������ʾ��ǩ
	JTextField TextField_Open1_Name;// �����ı���
	JPasswordField PasswordField1_Open1;// �����ı���1
	JPasswordField PasswordField2_Open1;// �����ı���2
	JTextField TextField_Open1_Money;// ����ı���
	JTextField TextField_Open1_IdNumber;// ���֤���ı���
	// ��������2���
	JLabel Label_Open2_Title;// ��ǩ
	JLabel Label_Open2_Id;// �˺ű�ǩ
	JLabel Label_Open2_Name;// ������ǩ
	JLabel Label_Open2_Money;// ����ǩ
	JLabel Label_Open2_IdNumber;// ���֤�ű�ǩ
	JLabel Label_Open2_FistTime;// ����ʱ���ǩ
	JButton Button_Open2_Back;// ���ذ�ť
	JButton Button_Open2_Confirm;// ȷ�ϰ�ť
	JButton Button_Open2_Exit;// �˳���ť
	// �����������
	JButton Button_Delete_Back;// ���ذ�ť
	JButton Button_Delete_Confirm;// ȷ�ϰ�ť
	JButton Button_Delete_Exit;// �˳���ť
	JLabel Label_Delete_Title;
	JLabel Label_Delete_Id;// ID��ǩ
	JLabel Label_Delete_Password;// �����ǩ
	JLabel Label_Delete_Reminder1;// ������ʾ��ǩ
	JLabel Label_Delete_Reminder2;// ������ʾ��ǩ
	JTextField TextField_Delete_Id;// ID�ı���
	JPasswordField PasswordField_Delete_Password;// �����ı���
	//����Ա�鿴�û��������
	JTable Select2_Table;
	JScrollPane Select2_Scroll;
	DefaultTableModel model;//ģ��
	JButton Select2_Back;
	JButton Select2_Exit;
	JScrollPane jScrollPane;
	//��־�������
	JTable Log_Table;
	JScrollPane Log_JS;
	DefaultTableModel model1;//ģ��
	JButton Log_Back;
	JButton Log_Exit;
	JScrollPane jScrollPane2;
	//��������
	JPanel Panel_Login;// ��¼����
	JPanel Panel_User_Function;// �û����ܽ���
	JPanel Panel_Administrator_Function;// ����Ա���ܽ���
	JPanel Panel_Transfer;// ת�˽���1
	JPanel Panel_Transfer2;// ת�˽���2
	JPanel Panel_Select;//��ѯ����
	JPanel Panel_D$W;//��ȡ�����
	JPanel Panel_Change;//�û����ܽ���
	JPanel Panel_Open1;//��������1
	JPanel Panel_Open2;//��������2
	JPanel Panel_Delete;//��������
	JPanel Panel_Select2;//�û���Ϣ����
	JPanel Panel_Log;//��־����
	JPanel Panel_bg = new JPanel();
	// �˻�����
	String id;
	String firsttime;
	String name;
	String balance;
	String idnumber;
	String password;
	//���췽��
	/**
	 * ����frame�ĸ�ʽ
	 */
	public Frame() {
		super("���й���ϵͳ");
		//�˵���
		Bar.add(Help);
		Bar.add(About);
		Bar.setOpaque(false);
		this.setJMenuBar(Bar);
		Frame_Login();
		Cner = super.getContentPane();
		Cner.setLayout(null);// �ղ���
		//����Frame�ı���ͼ
		((JPanel)this.getContentPane()).setOpaque(false);
	    bg=new JLabel(icon);
	    this.add(bg);
	    this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE)); //�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
	    bg.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
	     		
		this.setBackground(Color.WHITE);
		this.setBounds(520, 170, 600, 400);// λ�üӴ�С��
		this.setResizable(false);// �̶����ڴ�С��
		this.setVisible(true);// ���ô���Ϊ�ɼ��ģ�
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// �رհ�ť��
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
	 * ��¼����,���ص�¼�����������������еļ������� 
	 * @return: void
	 */
	// ����¼�����������������
	public void Frame_Login() {
		WCreate = new WindowCreate();
		// �����ı���
		TextField_Login_Id = WCreate.setFiled(180, 100, 200, 30, "", Color.WHITE, true);
		PasswordField_Login_Password = WCreate.setPasswordFiled(180, 160, 200, 30, "", true);
		// ������ť
		Button_Login_Login = WCreate.setButton(200, 250, 60, 40, "��¼");
		Button_Login_Exit = WCreate.setButton(300, 250, 60, 40, "�˳�");
		// ������ǩ
		Label_Login_Title = WCreate.setLabel(210, 30, 150, 100, "�����˻���¼����");
		Label_Login_Id = WCreate.setLabel(113, 85, 100, 60, "�˺�");
		Label_Login_Password = WCreate.setLabel(113, 145, 100, 60, "����");
		Label_Login_Reminder = WCreate.setLabel(210, 200, 200, 60, "");
		// ������ѡ��
		jCheckBox1 = WCreate.setJCheckBox(225, 300, 119, 20, "����Ա�˻���¼");
		
		
		
		Panel_Login = WCreate.setPanel(0, 0, 600, 400,Color.WHITE);
		// ���¼�����м������
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
				  if(jCheckBox1.isSelected()==true) {//����Ա��¼
					  if(String.valueOf(PasswordField_Login_Password.getPassword()).equals("999999")) {
						  Frame_Administrator();
						  Panel_Login.setVisible(false); 
						  Cner.add(Panel_Administrator_Function);
					  }
					  else {
						  Label_Login_Reminder.setText("�����������������");
						  PasswordField_Login_Password.setText("");
					  }
					  
				  }else {//�û���¼
					  sql_Models = new SQL_Models(); 
					  sql_Models.DriveLoad();//����������
					  sql_Models.ConnectionCreate();//��������
					  sql_Models.setID(TextField_Login_Id.getText()); 
					  sql_Models.Data_Lookup();//ȡ���û���Ϣ������ֵ��sql_Models����
					  if(String.valueOf(PasswordField_Login_Password.getPassword()).equals(sql_Models.getUserPassword())) {
						  Label_Login_Reminder.setText("��¼�ɹ�����ӭ��Ĺ��٣�"); 
						  name=sql_Models.getUserName();
						  password=String.valueOf(PasswordField_Login_Password.getPassword());
						  firsttime=sql_Models.getFirstTime(); 
						  idnumber=sql_Models.getIdNumber();
						  balance=sql_Models.getAccountBalance(); 
						  
						  sql_Models.SaveLog(TextField_Login_Id.getText(), "��¼ϵͳ");
						  
						  Panel_Login.setVisible(false);
						  Frame_User();
						  Cner.add(Panel_User_Function);
						  
					  }
					  else if(sql_Models.getID().equals("null")) {
						  Label_Login_Reminder.setText("�˺Ŵ�������������");
						  TextField_Login_Id.setText("");
						  PasswordField_Login_Password.setText("");
					  }
					  else {
						  Label_Login_Reminder.setText("�����������������");
						  PasswordField_Login_Password.setText("");
					  }
					  }
				 

			}

		});
		jCheckBox1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(e.getSource()==jCheckBox1) {//��ѡ���ж�����Ա���û�
					if(jCheckBox1.isSelected()==true) {
						Label_Login_Reminder.setText("");
						TextField_Login_Id.setText("007");
						//PasswordField_Login.setText("123456");
						Label_Login_Title.setText("����Ա�˻���¼����");
						TextField_Login_Id.setEditable(false);
						PasswordField_Login_Password.setEditable(true);
					}
					else{
						if(Label_Login_Title.getText().equals("�����˻���¼����")) {
							
						}
						else {
						Label_Login_Title.setText("�����˻���¼����");
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
	 * �����û�������������ü�������     
	 * @return: void
	 */
	//�û����ܽ���
	public void Frame_User() {
		//��ť
		Button_User_Select = WCreate.setButton(50, 40, 90, 60, "��ѯ");// ��ѯ
		Button_User_Deposit = WCreate.setButton( 50,140,90,60,"���");;// ���
		Button_User_Withdrawal = WCreate.setButton( 450,138,90,60,"ȡ��");// ȡ��
		Button_User_Transfer = WCreate.setButton(450,238,90,60,"ת��");// ת��
		Button_User_ChangePassword = WCreate.setButton(450,38,90,60,"����");// ����
		Button_User_Back = WCreate.setButton(50,240,90,60,"����");// ����
		HY = WCreate.setLabel(180,120,300,100,"���л�ӭ��");
		HY.setFont(new Font("Dialog", 1, 45));
		//������Ƭ
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
				Label_Select_Id.setText("�˻��ţ�"+TextField_Login_Id.getText());
			    Label_Select_Name.setText("�˻����ƣ�"+name);
			    Label_Select_Balance.setText("�˻���"+balance);
			    Label_Select_IdNumber.setText("���֤�ţ�"+idnumber);
			    Label_Select_FirstTime.setText("�������ڣ�"+firsttime);
			}
			
		});
		Button_User_Deposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_D$W();
				Panel_User_Function.setVisible(false);				
				Cner.add(Panel_D$W);
				Label_D$W_Title.setText("����������");
			}
		});
		Button_User_Withdrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_User_Function.setVisible(false);
				Frame_D$W();
				Cner.add(Panel_D$W);
				Label_D$W_Title.setText("������ȡ����");
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
	 *  ����Ա���� �� ���ع���Ա���沢���ü������� 
	 * @return: void
	 */
	//����Ա���ܽ���
	public void Frame_Administrator() {
		//��ť
		Button_Manager_Back = WCreate.setButton( 50,240,90,60,"����");
		Button_Manager_Exit = WCreate.setButton(450,240,90, 60, "�˳�");
		Button_Manager_Delete = WCreate.setButton( 450,140,90,60, "����");
		Button_Manager_Open = WCreate.setButton(50,140,90,60, "����");
		Button_Manager_Select = WCreate.setButton(50, 40, 90, 60, "�ͻ���Ϣ");
		Button_Manager_Log = WCreate.setButton(450,38,90,60,"��ѯ��־");
		//��ǩ
		Label_Manager_Title1 = WCreate.setLabel(190,20,300,100,"��ӭ�������Ա����");
		Label_Manager_Title1.setFont(new Font("Dialog", 1, 22));
		Manager.setBounds(170, 120, 280, 80);
		Manager.setFont(new Font("Dialog", 1, 60));
		//������Ƭ
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
	 *�û��鿴��Ϣ���ܣ� �����û��鿴��Ϣ���ܲ����ü�������  
	 * @return: void
	 */
	//��ѯ���ܽ���
	public void Frame_Select() {
		//��ť
		Button_Select_Back = WCreate.setButton(200, 250, 60, 40,"����");
		Button_Select_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		//��ǩ
		Label_Select_Id = WCreate.setLabel(200, 30, 300, 100, "");
		Label_Select_Name = WCreate.setLabel(200, 60, 300, 100, "");
		Label_Select_Balance = WCreate.setLabel(200, 90, 300, 100, "");
		Label_Select_IdNumber = WCreate.setLabel(200, 120, 300, 100, "");
		Label_Select_FirstTime = WCreate.setLabel(200, 150, 300, 100, "");
		//������Ƭ	
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
	 *�û����ܽ��棬�����û��޸�������沢���ü�������  
	 * @return: void
	 */
	//���ܹ��ܽ���
	public void Frame_Change() {
		 //��ť
		 Button_Change_Back = WCreate.setButton(200, 250, 60, 40,"����");
		 Button_Change_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		 Button_Change_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		 //��ǩ
		 Label_Change1 = WCreate.setLabel(200, 30, 150, 100, "����������������");
		 Label_Change2 = WCreate.setLabel(200, 100, 150, 100, "�����ٴ�����������");
		 Label_Change_Reminder = WCreate.setLabel(200, 170, 200, 100, "");
		 //�ı���
		 NewPassword1 = WCreate.setPasswordFiled(180, 100, 200, 30,"",true);
		 NewPassword2 = WCreate.setPasswordFiled(180, 170, 200, 30,"",true);
		 //������Ƭ
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
						Label_Change_Reminder.setText("�������뵱ǰ������ͬ");
					}
					else {
						
						sql_Models.Change_Password(TextField_Login_Id.getText(),String.valueOf(NewPassword1.getText()));
						Label_Change_Reminder.setText("�����޸ĳɹ�");
						password = String.valueOf(NewPassword1.getPassword());
						
						sql_Models.SaveLog(TextField_Login_Id.getText(), "�������޸�Ϊ��"+password);
						
						Button_Change_Confirm.setVisible(false);
						Label_Change1.setVisible(false);
						Label_Change2.setVisible(false);
						NewPassword1.setVisible(false);
						NewPassword2.setVisible(false);
					}
				}
				else {
					Label_Change_Reminder.setText("�����������벻һ�£���˶�");
				}
			}
			 
		 });
		 Button_Change_Exit.addActionListener(this);
	}
	/**
	 * ת�˹���1����  �� �����û�ת�˹���1���沢���ü������� 
	 * @return: void
	 */
	//ת�˹��ܽ���1
	public void Frame_Transfer1() {
		//�ı���
		 TextField_Transfer_Id = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);
		 TextField_Transfer_Money = WCreate.setFiled(180, 200, 200, 30,"", Color.WHITE,true);
		 //��ǩ
		 Label_Transfer_Id = WCreate.setLabel(200, 30, 150, 100, "���������ת���˺�" );
		 Label_Transfer_Money = WCreate.setLabel(200, 130, 150, 100, "����������ת�˽��");
		 //��ť
		 Button_Transfer_Back = WCreate.setButton(200, 250, 60, 40,"����");
		 Button_Transfer_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		 //������Ƭ
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
						Label_Transfer2_Reminder.setText("�˻����󣬷��غ˶�");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())>20000) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("ת�˽���");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())>Integer.parseInt(balance)) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("����");
					}
					else if(Integer.parseInt(TextField_Transfer_Money.getText())<0) {
						Label_Transfer2_Title.setVisible(false);
						Button_Transfer2_Confirm.setVisible(false);
						Label_Transfer2_Reminder.setText("����Ϊ����");
					}
					else {
						String name = sql_Models.getUserName();
						if(name.length()>=2&&name.length()<4) {
							Label_Transfer2_Name.setText("ת��������"+name.replace(name.charAt(1),'*'));
						}
						else if(name.length()>=4) {
							Label_Transfer2_Name.setText("ת��������"+name.replace(name.charAt(2),'*'));
						}
						else {
							Label_Transfer2_Name.setText("ת��������"+name);
						}
						Label_Transfer2_Id.setText("ת���˺ţ� "+TextField_Transfer_Id.getText());
						Label_Transfer2_Money.setText("ת��� "+TextField_Transfer_Money.getText());
					}
				}catch(Exception n) {
					Label_Transfer2_Title.setVisible(false);
					 Button_Transfer2_Confirm.setVisible(false);
					 Label_Transfer2_Reminder.setText("ת�˽����������");
				}
			} 
		 });
	} 
	/**
	 *  ת�˹���2���棬 Ϊת�˹���2���������������ü����¼�
	 * @return: void
	 */
	//ת�˹��ܽ���2
	public void Frame_Transfer2() {
		 //��ǩ
		 Label_Transfer2_Title = WCreate.setLabel(225, 30, 150, 100, "��ȷ������ת����Ϣ" );
		 Label_Transfer2_Name = WCreate.setLabel(225, 60, 150, 100, "" );
		 Label_Transfer2_Id = WCreate.setLabel(225, 90, 150, 100, "");
		 Label_Transfer2_Money = WCreate.setLabel(225, 120, 150, 100, "");
		 Label_Transfer2_Reminder = WCreate.setLabel(225, 150, 150, 100, "");
		 //��ť
		 Button_Transfer2_Back = WCreate.setButton(200, 250, 60, 40,"����");
		 Button_Transfer2_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		 Button_Transfer2_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		//������Ƭ
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
				if(Label_Transfer2_Reminder.getText().equals("ת�˳ɹ�")) {
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
				Label_Transfer2_Reminder.setText("ת�˳ɹ�");
				
				sql_Models.SaveLog(TextField_Login_Id.getText(),"���˺ţ�"+TextField_Transfer_Id.getText()+"ת��"+TextField_Transfer_Money.getText()+"Ԫ");
				
				balance=String.valueOf(Integer.parseInt(balance)-Integer.parseInt(TextField_Transfer_Money.getText()));
				Button_Transfer2_Confirm.setVisible(false);
			} 
		 });
		 Button_Transfer2_Exit.addActionListener(this);
	}
	/**
	 * ��ȡ��ܽ��� �� Ϊ��ȡ����������������ü����¼�
	 * @return: void
	 */
	//��ȡ��ܽ���
	public void Frame_D$W() {
		Button_D$W_Back = WCreate.setButton(200, 250, 60, 40,"����");
		Button_D$W_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		Button_D$W_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		Label_D$W_Title = WCreate.setLabel(225, 30, 150, 100, "");
		Label_D$W_Reminder = WCreate.setLabel(225, 150, 150, 100, "");
		TextField_D$W_Money = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);
		
		Ok.setBounds(225, 80, 100, 80);
		Ok.setVisible(false);
		//������Ƭ
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
					 if(Label_D$W_Title.getText().equals("������ȡ����")) {
						 if(Integer.parseInt(TextField_D$W_Money.getText())>20000) {
							 Label_D$W_Reminder.setText("���ܳ����޶�");
						 }
						 else if(Integer.parseInt(TextField_D$W_Money.getText())>Integer.parseInt(balance)) {
							 Label_D$W_Reminder.setText("�˻�����");
						 }
						 else if(Integer.parseInt(TextField_D$W_Money.getText())<0)
							 Label_D$W_Reminder.setText("����Ϊ����������������");
						 else {
							 sql_Models.Withdrawal(TextField_Login_Id.getText(), balance,TextField_D$W_Money.getText());
							 balance=String.valueOf(Integer.parseInt(balance)-Integer.parseInt(TextField_D$W_Money.getText()));
							 Label_D$W_Reminder.setText("����ȡ����Ϊ"+TextField_D$W_Money.getText());
							 Button_D$W_Confirm.setVisible(false);
							 Label_D$W_Title.setText("ȡ��ɹ�");
							 Ok.setVisible(true);
							 
							 sql_Models.SaveLog(TextField_Login_Id.getText(), "ȡ��"+TextField_D$W_Money.getText()+"Ԫ");
							 
							 Label_D$W_Title.setBounds(260,120, 150, 100);
							 TextField_D$W_Money.setVisible(false);
						 }
					 }
					 else if(Label_D$W_Title.getText().equals("����������")){
						 if(Integer.parseInt(TextField_D$W_Money.getText())<0)
							 Label_D$W_Reminder.setText("����Ϊ����������������");
						 else if(Integer.parseInt(TextField_D$W_Money.getText())>20000) {
							 Label_D$W_Reminder.setText("���ܳ����޶�");
							 }
						 else {
							 sql_Models.Deposit(TextField_Login_Id.getText(), balance,TextField_D$W_Money.getText());
							 balance=String.valueOf(Integer.parseInt(balance)+Integer.parseInt(TextField_D$W_Money.getText()));
							 Label_D$W_Reminder.setText("���Ĵ����Ϊ"+TextField_D$W_Money.getText());
							 Button_D$W_Confirm.setVisible(false);
							 Label_D$W_Title.setText("���ɹ�");
							 Ok.setVisible(true);
							 
							 sql_Models.SaveLog(TextField_Login_Id.getText(), "����"+TextField_D$W_Money.getText()+"Ԫ");
							 
							 Label_D$W_Title.setBounds(260,120, 150, 100);
							 TextField_D$W_Money.setVisible(false);
						 }
					 }
					 }catch (Exception e1) {
						    Label_D$W_Reminder.setText("���������������������");
						    TextField_D$W_Money.setText("");
					}
			}
		});
		Button_D$W_Exit.addActionListener(this);
	}
	/**
	 *����Ա��������1��Ϊ��������1������������ü����¼� 
	 * @return: void
	 */
	//�������ܽ���1
	public void Frame_Open1() {
		Button_Open1_Back = WCreate.setButton( 170,240,90,60,"����");
		Button_Open1_Confirm = WCreate.setButton(380,240,90, 60, "ȷ��");
		Label_Open1_Reminder = WCreate.setLabel(240, 200, 200, 60, " ");
		Label_Open1_Name = WCreate.setLabel(170, 20, 60, 40,"����");
		Label_Open1_Password = WCreate.setLabel(170, 60, 100, 40,"��������");
		Label_Open1_Password2 = WCreate.setLabel(170, 100, 100, 40,"����������");
		Label_Open1_Money = WCreate.setLabel(170, 140, 100, 40,"Ԥ��");
		Label_Open1_IdNumber = WCreate.setLabel(170, 180, 100, 40,"���֤��");
		TextField_Open1_Name = WCreate.setFiled(250, 20, 200, 30,"",Color.white,true);
		PasswordField1_Open1 = WCreate.setPasswordFiled(250, 60, 200, 30,"",true);
		PasswordField2_Open1 = WCreate.setPasswordFiled(250, 100, 200, 30,"",true);
		TextField_Open1_Money = WCreate.setFiled(250, 140, 200, 30,"",Color.WHITE,true);
		TextField_Open1_IdNumber = WCreate.setFiled(250, 180, 200, 30,"",Color.WHITE,true);
		//������Ƭ
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
					Label_Open1_Reminder.setText("��������Ϊ��");
				}
				else {
					if(String.valueOf(PasswordField1_Open1.getPassword()).equals(String.valueOf(PasswordField2_Open1.getPassword()))) {
						if(String.valueOf(PasswordField1_Open1.getPassword()).equals("")) {
							Label_Open1_Reminder.setText("���벻��Ϊ��");
						}
						else {
							if(TextField_Open1_IdNumber.getText().equals("")) {
								Label_Open1_Reminder.setText("���֤�Ų���Ϊ��");
							}
							else {
								try {
										if(Integer.parseInt(TextField_Open1_Money.getText())<0) {
											Label_Open1_Reminder.setText("Ԥ�����Ϊ��");
											TextField_Open1_Money.setText("");
										}
										else if(Integer.parseInt(TextField_Open1_Money.getText())>20000) {
												Label_Open1_Reminder.setText("Ԥ������޶�<20000");
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
								            	   Label_Open2_Id.setText("�˺�   "+id);
								            	   name=TextField_Open1_Name.getText();
								            	   Label_Open2_Name.setText("����   "+name);
								            	   balance=TextField_Open1_Money.getText();
								            	   Label_Open2_Money.setText("Ԥ��   "+balance);
								            	   idnumber=TextField_Open1_IdNumber.getText();
								            	   Label_Open2_IdNumber.setText("���֤��   "+idnumber);
								            	   sql_Models.setFirstTime();
								            	   firsttime=sql_Models.getFirstTime();
								            	   Label_Open2_FistTime.setText("����ʱ��   "+firsttime);// new Date()Ϊ��ȡ��ǰϵͳʱ��
								               	}
								               else {
								            	   password=String.valueOf(PasswordField1_Open1.getPassword());
								                   Label_Open2_Id.setText("�˺�   "+id);
								                   name=TextField_Open1_Name.getText();
								                   Label_Open2_Name.setText("����   "+name);
								                   balance=TextField_Open1_Money.getText();
								                   Label_Open2_Money.setText("Ԥ��   "+balance);
								                   idnumber=TextField_Open1_IdNumber.getText();
								                   Label_Open2_IdNumber.setText("���֤��   "+idnumber);
								                   sql_Models.setFirstTime();
								                   firsttime=sql_Models.getFirstTime();
								                   Label_Open2_FistTime.setText("����ʱ��   "+firsttime);// new Date()Ϊ��ȡ��ǰϵͳʱ��
								               }
										}
									
								}catch(Exception e1) {
									Label_Open1_Reminder.setText("Ԥ������������������");
								}
							}
						}
					}
					else {
						Label_Open1_Reminder.setText("�������벻һ�£�����������");
					}
				}
				
			}
			
		});
	}
	/**
	 *  ��������2 �� Ϊ��������2������������ü����¼� 
	 * @return: void
	 */
	//�������ܽ���2
	public void Frame_Open2() {
		//��ǩ
		 Label_Open2_Title = WCreate.setLabel(225, 30, 150, 100, "��ȷ�����Ŀ�����Ϣ");
		 Label_Open2_Id = WCreate.setLabel(225, 60, 150, 100, "" );
		 Label_Open2_Name = WCreate.setLabel(225, 90, 150, 100, "" );
		 Label_Open2_Money = WCreate.setLabel(225, 120, 150, 100, "");
		 Label_Open2_IdNumber = WCreate.setLabel(225, 150, 250, 100, "");
		 Label_Open2_FistTime = WCreate.setLabel(225, 180, 250, 100, "");
		 //��ť
		 Button_Open2_Back = WCreate.setButton(200, 250, 60, 40,"����");
		 Button_Open2_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		 Button_Open2_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		 //������Ƭ
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
				if(Label_Open2_Title.getText().equals("�����ɹ�")) {
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
				Label_Open2_Title.setText("�����ɹ�");
				Label_Open2_Title.setBounds(260,120, 150, 100);
				Button_Open2_Confirm.setVisible(false);	
				
			}	 
		 });
		 Button_Open2_Exit.addActionListener(this);
	}
	/**
     * ����Ա�������棬 Ϊ����Ա�������������������ü����¼�
	 * @return: void
	 */
	//�������ܽ���
	public void Frame_Delete() {
		//�����ı���
		TextField_Delete_Id = WCreate.setFiled(180, 100, 200, 30,"",Color.WHITE,true);//λ�ã���С���ı�����ɫ���ı���༭��
	    PasswordField_Delete_Password = WCreate.setPasswordFiled(180, 160, 200, 30,"", true);
		//������ť��
	    Button_Delete_Back = WCreate.setButton(200, 250, 60, 40,"����");
		Button_Delete_Exit = WCreate.setButton(300, 250, 60, 40,"�˳�");
		Button_Delete_Confirm = WCreate.setButton(300, 250, 60, 40,"ȷ��");
		//������ǩ��
		Label_Delete_Title = WCreate.setLabel(210, 30, 150, 100, "�����������˻���Ϣ");
		Label_Delete_Id = WCreate.setLabel(113, 85, 100, 60, "�˺�");
		Label_Delete_Password = WCreate.setLabel(113, 145, 100, 60,"����");
		Label_Delete_Reminder1 = WCreate.setLabel(190, 200, 200, 60, "");
		Label_Delete_Reminder2 = WCreate.setLabel(260,120, 150, 100, "");
		//������Ƭ
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
						 Label_Delete_Reminder2.setText("�����ɹ�");
						 Label_Delete_Id.setText("");
						 Label_Delete_Password.setText("");
						 Label_Delete_Title.setText("");
						 TextField_Delete_Id.setVisible(false);
						 PasswordField_Delete_Password.setVisible(false);
						 Button_Delete_Confirm.setVisible(false);
					 }
					 else {
						 Label_Delete_Reminder1.setText("�����������������");
						 PasswordField_Delete_Password.setText("");
					 }}catch (Exception n) {
						 Label_Delete_Reminder1.setText("�˺���������������");
						 TextField_Delete_Id.setText("");
						 PasswordField_Delete_Password.setText("");
					}	
			}
		});	
		Button_Delete_Exit.addActionListener(this);
	}
	/**
	 * ����Ա�鿴�û���Ϣ���ܣ�Ϊ����Ա�鿴�û���Ϣ���������������ü�������
	 * @return: void
	 */
	//�ͻ���Ϣ����
	public void Frame_Select2() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		u = sql_Models.UserInfo() ;
		
		model = new DefaultTableModel(u,arr);
		Select2_Table = new JTable(model);
		

        //���������õ�Ԫ����п�
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
		
		Select2_Back = WCreate.setButton(200, 300, 60, 40,"����");
		Select2_Exit = WCreate.setButton(300, 300, 60, 40,"�˳�");
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
	 * ����Ա�鿴��־���ܣ� Ϊ�鿴��־���������������ü����¼� 
	 * @return: void
	 */
	//��־���ܽ���
	public void Look_Log() {
		sql_Models = new SQL_Models();
		sql_Models.DriveLoad();
		sql_Models.ConnectionCreate();
		Log2 = sql_Models.LogInfo() ;
		
		model1 = new DefaultTableModel(Log2,Log1);
		Log_Table = new JTable(model1);
		Log_Table.setGridColor(Color.BLACK);
		
		//���������õ�Ԫ����п�
		Log_Table.getColumnModel().getColumn(0).setPreferredWidth(30);
		Log_Table.getColumnModel().getColumn(1).setPreferredWidth(110);
		Log_Table.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		Log_Table.getTableHeader().setReorderingAllowed(false); 
		Log_Table.setEnabled(false);
		Log_JS = new JScrollPane();
		Log_JS.setViewportView(Log_Table);
		Log_JS.setBounds(0, 0, 590,300);
		
		Log_Back = WCreate.setButton(200, 300, 60, 40,"����");
		Log_Exit = WCreate.setButton(300, 300, 60, 40,"�˳�");
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
		//�˳���ť
		 if(e.getSource()==Button_Login_Exit||e.getSource()==Button_Transfer2_Exit
			||e.getSource()==Button_Select_Exit||e.getSource()==Button_D$W_Exit||e.getSource()==
			Button_Change_Exit||e.getSource()==Button_Delete_Exit||e.getSource()==Log_Exit
			||e.getSource()==Button_Open2_Exit||e.getSource()==Button_Manager_Exit||e.getSource()==Select2_Exit) {
			 
			 System.exit(0);
		 }
			 
	}
}
