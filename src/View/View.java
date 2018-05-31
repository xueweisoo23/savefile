package View;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class View {

	public static void main(String[] args) {
		 new View();
	}
	
	public View(){
		
		JFrame jf = new JFrame("小程序");         
        jf.setSize(350, 250);                       
        jf.setLocationRelativeTo(null);            
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        
        
        JPanel panel = new JPanel();                

        
        JTextArea path = new JTextArea("		");
        JLabel emptyLable = new JLabel("路径：");
        JButton btn = new JButton("选择路径");
        JButton btn1 = new JButton("显示所有文件信息");
        JButton btn2 = new JButton("显示重复文件信息");
        panel.add(emptyLable);
        panel.add(path);
        panel.add(btn);
        panel.add(btn1);
        panel.add(btn2);
        
        
        String[] columnNames = {"名称","类型","大小","路径","创建时间"};// 定义表格列名数组

        String[][] tableValues = {{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
        // 创建指定列名和数据的表格
        JTable table = new JTable(tableValues,columnNames);
        // 创建显示表格的滚动面板
        JScrollPane scrollPane = new JScrollPane(table);
        // 将滚动面板添加到边界布局的中间
        panel.add(scrollPane, BorderLayout.CENTER);
        
}
}
