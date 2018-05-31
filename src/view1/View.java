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
import javax.swing.table.TableModel;

import Listener.Listener;
import MethodDemo.FileChooser;
import Model.Data1;
import Util.SqlLite;


public class View implements ActionListener {

	public JTextArea path = new JTextArea("			");

	
	public View(){
		JFrame jf = new JFrame("小程序");         
        jf.setSize(470, 500);                       
        jf.setLocationRelativeTo(null);            
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 

        
        JPanel panel = new JPanel();                

        
        JLabel emptyLable1 = new JLabel("选择要查看所有文件的路径：");
        JTextArea path1 = new JTextArea("		");
        
//        path1 = FileChooser.Print(file, str);
        JButton btn3 = new JButton("OPEN");
        

        
        JButton btn = new JButton("确认");
        JButton btn1 = new JButton("显示所有文件信息");
        JButton btn2 = new JButton("显示重复文件信息");
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
        
        
        Model model = new Model();
        Panel parent = new Panel();
        JTable table = new JTable();
        table.setModel(model);// 为table 分配model
        JScrollPane jPane = new JScrollPane(table);// 将table放进滚动条 放进滚动条后可显示列名
        // getContentPane()得到JFrame最底层的JPanel 默认拥有一个不可直接向JFrame添加 需向JPanel添加
        panel.add(jPane);
        table.setVisible(true);
        
        
        
        
        
        
        jf.setContentPane(panel);
        jf.setVisible(true);
        }
	
	public class Model implements TableModel {
	     List<Data1> List;

	     Object[][] p = { { "1", "11", 1,"1","1"}, { "1", "11", 1,"1","1"} }; // 表格数据
	     String n[] = {"名称","类型","大小","路径","创建时间"}; // 属性名
	 
	     @Override
	     public Class<Object> getColumnClass(int columnIndex) {
	         return Object.class;
	     }
	 
	     
//			 为表格传入列数
	
	     public int getColumnCount() {
	 
	         return n.length;
	     }
	 
	   
//			为表格传入属性名
	
	     public String getColumnName(int columnIndex) {
	         return n[columnIndex];
	     }
	 
	    
//			 为表格传入行数
	
	     public int getRowCount() {
	         return p.length;
	     }
	     
//	 		将数组中的数据传入表格
	
	     @Override
	     public Object getValueAt(int rowIndex, int columnIndex) {
	 
	        return p[rowIndex][columnIndex];
	     } 
	    
//			设置表格是否可编辑
	
	     public boolean isCellEditable(int rowIndex, int columnIndex) {
	         return true;
	     }
	 
	    
//	  		   每当数据模型发生更改时，就将一个侦听器添加到被通知的列表中。
	
	     public void addTableModelListener(TableModelListener l) {
	 
	     }
	 
	   
//	  		     每当数据模型发生更改时，就从被通知的列表中移除一个侦听器。
	
	     public void removeTableModelListener(TableModelListener l) {
	 
	     }
	 
	

	    
	     public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	         p[rowIndex][columnIndex] = aValue;
	 
	     }
	 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
