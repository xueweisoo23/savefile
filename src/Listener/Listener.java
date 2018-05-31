package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import MethodDemo.FileChooser;
import Util.SqlLite;
import Util.SqliteDao;
import view1.View;



//监听器类
public class Listener implements ActionListener {
	
	private View view;
	
	public Listener(View v){
		this.view=v;
		
	}

	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();//获得按钮上的文字
		System.out.println(str);
		if(str.equals("OPEN")){
			JFileChooser jfc=new JFileChooser();  
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	        jfc.showDialog(new JLabel(), "选择");  
	        File file=jfc.getSelectedFile();
			SqlLite.createTable();
	        FileChooser.printFile(file, 0);
	        
		}else if(str.equals("确认")){
			JFileChooser jfc=new JFileChooser();  
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	        jfc.showDialog(new JLabel(), "选择");  
	        File file=jfc.getSelectedFile(); 
			
			
			
		}else if(str.equals("显示文件信息")){
			SqlLite.query();
			
		}else if(str.equals("显示重复文件信息")){
			SqlLite.Check();
		}
	}
	
}
