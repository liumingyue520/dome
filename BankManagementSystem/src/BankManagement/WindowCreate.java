package BankManagement;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * ��дJFrame��һЩ����   
 * @author: LMY
 * @date:   2021��1��8�� ����9:41:04
 */
@SuppressWarnings("serial")
public class WindowCreate extends JFrame{
	/**
	 * 
	 * ����JPanel����ʽ  
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height ��
	 * @param bg  ������ɫ    
	 * @return: JPanel
	 */
	public JPanel setPanel(int x,int y,int width,int height,Color bg) {
		//                     λ��                      ��С                    
		//���
		JPanel jPanel=new JPanel();
		jPanel.setBounds(x, y, width, height);
		jPanel.setBackground(bg);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		return jPanel;
		}
	/**
	 * 
	 * ����JTextField��ʽ  
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height ��
	 * @param bg  ������ɫ    
	 * @param a �༭����      
	 * @return: JTextField
	 */
	public JTextField setFiled(int x,int y,int width,int height,String text,Color bg,boolean a) {
		//��ţ�λ�ã���С���ı�����ɫ���ı���༭��
		//�ı���
		JTextField aField=new JTextField(text);
		aField.setBounds(x, y, width, height);
		aField.setBackground(bg);
		aField.setEditable(a);//�Ƿ������û��༭�ı���
		return aField;
		}
	/**
	 * 
	 * ����JPasswordFiled��ʽ  
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height �� 
	 * @param a �༭����       
	 * @return: JPasswordField
	 */
	public JPasswordField setPasswordFiled(int x,int y,int width,int height,String text,boolean a) {
		//                                    λ��                        ��С                            �ı�        �ı���༭
		//�ı���
		JPasswordField aField=new JPasswordField(text);
		aField.setBounds(x, y, width, height);
		aField.setEditable(a);//�Ƿ������û��༭�ı���
		return aField;
		}
	/**
	 * 
	 * ����JButton����ʽ 
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height �� 
	 * @param text ��ť�ϵ��ַ�      
	 * @return: JButton
	 */
	public JButton setButton(int x,int y,int width,int height,String text) {
		//��ť
		JButton aButton=new JButton(text);
		aButton.setBounds(x, y, width, height);
		aButton.setBackground(Color.WHITE);
		return aButton;
		}
	/**
	 * 
	 * ����JLabel����ʽ  
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height �� 
	 * @param text ��ǩ�ϵ��ַ�      
	 * @return: JLabel
	 */
	public JLabel setLabel(int x,int y,int width,int height,String text) {
		  JLabel jLabel=new JLabel(text);
		  jLabel.setBounds(x, y, width, height);
		  jLabel.setFont(new Font("����",Font.BOLD,15));
		  jLabel.setOpaque(false);
		  return jLabel;
		  }
	/**
	 * 
	 * ����JCheckBox����ʽ  
	 * @param x x��
	 * @param y y��
	 * @param width  ��
	 * @param height �� 
	 * @param text ��ѡ����ϵ��ַ�       
	 * @return: JCheckBox
	 */
	public JCheckBox setJCheckBox(int x,int y,int width,int height,String text) {
		 JCheckBox jCheckBox=new JCheckBox(text);
		 jCheckBox.setBounds(x,y,width,height);
		 jCheckBox.setOpaque(false);
		 return jCheckBox;
	}
}
