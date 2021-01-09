/**

*/
package BankManagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**   
 * @ClassName:  about   
 * @Description:关于界面   
 * @author: LMY
 * @date:   2021年1月9日 下午3:08:59       
 */
class about extends JFrame{
	JTextArea area = new JTextArea();
	public about() {
		this.setBounds(550, 170,260, 260);
		this.setLayout(null);
		area.setBounds(0, 0, 260, 260);
		area.setEditable(false);
		read();
		this.add(area);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void read() {
		try { 
            /* 读入TXT文件 */
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\12608\\Desktop\\程序\\bank.txt"),"utf-8"));
            String line = "";
            line = br.readLine();
            while ((line=br.readLine())!=null) {
                area.append(line);
                area.append("\n");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}