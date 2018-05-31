package view1;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Listener.Listener;
import MethodDemo.FileChooser;
import Model.Data1;
import Util.SqlLite;


public class View implements ActionListener {

	public JTextArea path = new JTextArea("			");
	private static DefaultTableModel model;
	private JTable table;
	public static DefaultTableModel getModel() {
		return model;
	}
	public static void main(String[] args) {
		 new View();
	}
	
	public View(){
		JFrame jf = new JFrame("灏忕▼搴�");         
        jf.setSize(470, 500);                       
        jf.setLocationRelativeTo(null);            
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 

        
        JPanel panel = new JPanel();                

        
        JLabel emptyLable1 = new JLabel("閫夋嫨瑕佹煡鐪嬫墍鏈夋枃浠剁殑璺緞锛�");
        JTextArea path1 = new JTextArea("		");
        
//        path1 = FileChooser.Print(file, str);
        JButton btn3 = new JButton("OPEN");
        

        
        JButton btn = new JButton("纭");
        JButton btn1 = new JButton("鏄剧ず鎵�鏈夋枃浠朵俊鎭�");
        JButton btn2 = new JButton("鏄剧ず閲嶅鏂囦欢淇℃伅");
        panel.add(emptyLable1);
        panel.add(path1);
        panel.add(btn3);
        
        Listener ml=new Listener(this);
        btn.addActionListener(ml);
		btn1.addActionListener(ml);
		btn2.addActionListener(ml);
		btn3.addActionListener(ml);
        		
        		
        panel.add(path);
        panel.add(btn);
        panel.add(btn1);
        panel.add(btn2);
        
        
       
//        JTable table = new JTable();
//        table.setModel(model);// 涓簍able 鍒嗛厤model
//        JScrollPane jPane = new JScrollPane(table);// 灏唗able鏀捐繘婊氬姩鏉� 鏀捐繘婊氬姩鏉″悗鍙樉绀哄垪鍚�
//        // getContentPane()寰楀埌JFrame鏈�搴曞眰鐨凧Panel 榛樿鎷ユ湁涓�涓笉鍙洿鎺ュ悜JFrame娣诲姞 闇�鍚慗Panel娣诲姞
//        panel.add(jPane);
//        table.setVisible(true);
        
        String[] s = {"鍚嶇О","绫诲瀷","澶у皬","璺緞","鍒涘缓鏃堕棿"};// 瀹氫箟琛ㄦ牸鍒楀悕鏁扮粍

        // 鍒涘缓鎸囧畾鍒楀悕鍜屾暟鎹殑琛ㄦ牸
        model = new DefaultTableModel(s, 0);
		setTable(new JTable(model));
		JScrollPane pane = new JScrollPane(getTable());
		panel.add(pane);
        
        
        
        
        jf.setContentPane(panel);
        jf.setVisible(true);
        }
	
	
		public JTable getTable(){
			return table;
		}
		public void setTable(JTable table){
			this.table = table;

		}
	 
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
