package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import MethodDemo.FileChooser;
import Model.Data1;
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
	        refresh();
	        
		}else if(str.equals("确认")){

			JTextArea path = view.path;
			String text = path.getText();
			SqlLite.singleQuery(text.replace("\t", ""));
			
		}else if(str.equals("显示文件信息")){
			SqlLite.query();
			refresh();
			
		}else if(str.equals("显示重复文件信息")){
			SqlLite.Check();
			refresh();
		}
	}
	
	
	private void refresh(){
		//�����ǰ�������
		View.getModel().setRowCount(0);
		
		ArrayList<Data1> al=SqlLite.query();
		for(int i=0;i<al.size();i++){
			Data1 d=al.get(i);
			//ѭ��һ������һ������
			Object[] rowData={d.getName(),d.getType(),d.getSize(),d.getPath(),d.getTime()};
			View.getModel().addRow(rowData);//�ŵ������
		}
	}
}
