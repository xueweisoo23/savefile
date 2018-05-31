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



//鐩戝惉鍣ㄧ被
public class Listener implements ActionListener {
	
	private View view;
	
	public Listener(View v){
		this.view=v;
		
	}

	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();//鑾峰緱鎸夐挳涓婄殑鏂囧瓧
		System.out.println(str);
		if(str.equals("OPEN")){
			JFileChooser jfc=new JFileChooser();  
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	        jfc.showDialog(new JLabel(), "閫夋嫨");  
	        File file=jfc.getSelectedFile();
			SqlLite.createTable();
	        FileChooser.printFile(file, 0);
	        refreshWithAl(SqlLite.query());
	        
		}else if(str.equals("纭")){

			JTextArea path = view.path;
			String text = path.getText();
			refreshWithAl(SqlLite.singleQuery(text.replace("\t", "")));
		}else if(str.equals("鏄剧ず鏂囦欢淇℃伅")){
			refreshWithAl(SqlLite.query());
			
		}else if(str.equals("鏄剧ず閲嶅鏂囦欢淇℃伅")){
			refreshWithAl(SqlLite.Check());
		}
	}
	
	
	private void refreshWithAl(ArrayList<Data1> al){
		//先清空前面的数据
		View.getModel().setRowCount(0);
		for(int i=0;i<al.size();i++){
			Data1 d=al.get(i);
			//循环一次生成一行数据
			Object[] rowData={d.getName(),d.getType(),d.getSize(),d.getPath(),d.getTime()};
			View.getModel().addRow(rowData);//放到表格中
		}
	}
}
