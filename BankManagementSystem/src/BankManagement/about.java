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
 * @Description:���ڽ���   
 * @author: LMY
 * @date:   2021��1��9�� ����3:08:59       
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
            /* ����TXT�ļ� */
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\12608\\Desktop\\����\\bank.txt"),"utf-8"));
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