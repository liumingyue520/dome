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
 * 重写JFrame的一些方法   
 * @author: LMY
 * @date:   2021年1月8日 上午9:41:04
 */
@SuppressWarnings("serial")
public class WindowCreate extends JFrame{
	/**
	 * 
	 * 设置JPanel的样式  
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高
	 * @param bg  背景颜色    
	 * @return: JPanel
	 */
	public JPanel setPanel(int x,int y,int width,int height,Color bg) {
		//                     位置                      大小                    
		//面板
		JPanel jPanel=new JPanel();
		jPanel.setBounds(x, y, width, height);
		jPanel.setBackground(bg);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		return jPanel;
		}
	/**
	 * 
	 * 设置JTextField样式  
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高
	 * @param bg  背景颜色    
	 * @param a 编辑允许      
	 * @return: JTextField
	 */
	public JTextField setFiled(int x,int y,int width,int height,String text,Color bg,boolean a) {
		//序号，位置，大小，文本，颜色，文本框编辑；
		//文本框
		JTextField aField=new JTextField(text);
		aField.setBounds(x, y, width, height);
		aField.setBackground(bg);
		aField.setEditable(a);//是否允许用户编辑文本框；
		return aField;
		}
	/**
	 * 
	 * 设置JPasswordFiled样式  
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高 
	 * @param a 编辑允许       
	 * @return: JPasswordField
	 */
	public JPasswordField setPasswordFiled(int x,int y,int width,int height,String text,boolean a) {
		//                                    位置                        大小                            文本        文本框编辑
		//文本框
		JPasswordField aField=new JPasswordField(text);
		aField.setBounds(x, y, width, height);
		aField.setEditable(a);//是否允许用户编辑文本框；
		return aField;
		}
	/**
	 * 
	 * 设置JButton的样式 
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高 
	 * @param text 按钮上的字符      
	 * @return: JButton
	 */
	public JButton setButton(int x,int y,int width,int height,String text) {
		//按钮
		JButton aButton=new JButton(text);
		aButton.setBounds(x, y, width, height);
		aButton.setBackground(Color.WHITE);
		return aButton;
		}
	/**
	 * 
	 * 设置JLabel的样式  
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高 
	 * @param text 标签上的字符      
	 * @return: JLabel
	 */
	public JLabel setLabel(int x,int y,int width,int height,String text) {
		  JLabel jLabel=new JLabel(text);
		  jLabel.setBounds(x, y, width, height);
		  jLabel.setFont(new Font("楷体",Font.BOLD,15));
		  jLabel.setOpaque(false);
		  return jLabel;
		  }
	/**
	 * 
	 * 设置JCheckBox的样式  
	 * @param x x轴
	 * @param y y轴
	 * @param width  宽
	 * @param height 高 
	 * @param text 复选框边上的字符       
	 * @return: JCheckBox
	 */
	public JCheckBox setJCheckBox(int x,int y,int width,int height,String text) {
		 JCheckBox jCheckBox=new JCheckBox(text);
		 jCheckBox.setBounds(x,y,width,height);
		 jCheckBox.setOpaque(false);
		 return jCheckBox;
	}
}
