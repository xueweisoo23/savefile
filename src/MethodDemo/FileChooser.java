package MethodDemo;

  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import Model.Data1;
import Util.SqlLite;
import view1.View;  
  
public class FileChooser extends JFrame implements ActionListener{  
    private static final Model.Data1 Model = null;
	
    
    public static void main(String[] args) {
    	new FileChooser();  
        
    }  
    
    
    public FileChooser(){  
    	View view = new View();
         
        
		 
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        JFileChooser jfc=new JFileChooser();  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
        jfc.showDialog(new JLabel(), "选择");  
        File file=jfc.getSelectedFile();  
        printFile(file,0);
          
    }  
  
    
    public static void printFile(File file,int l){
        String str = new String();  //生成补充空格
        for(int i=0;i<l;i++){
            str +=" " ;
        }
        //先输出自己后输出子目录或文件
        formatPrint(file,str);
        format(file, Model);
        
        if(file.isDirectory()){  //判断是否为目录
            File[] files = file.listFiles();  //获取目录下文件列表
            for(File f:files){//递归输出文件
                printFile(f,l+3);
            }
             
        }
    }
    
    public static void Print(File file,String str) {
    	System.out.println(file.getPath());
    }
    
    
    public static void formatPrint(File file,String str){
        //先输出文件
        String[] names = file.getName().split("[.]");
        long time = file.lastModified();//获取文件修改时间
        String ctime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(time));
        
        System.out.println("名称： "+str+file.getName()  
                + "       类型："+names[names.length-1]+"文件"
                + "       "+"  大小： "+file.length()+"  路径： "+file.getPath()+"  最后修改时间："+ctime);
    }
    
    public static void format(File file,Data1 d){
    	String[] names = file.getName().split("[.]");
        long time = file.lastModified();//获取文件修改时间
        String ctime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(time));
        String s1 = file.getName();
        String s2 = names[names.length-1];
        long s3 = file.length();
        String s4 = file.getPath();
        String s5 = ctime;   
        Data1 d1=new Data1(s1, s2,s3 , s4, s5);
        SqlLite.insertData(d1);    
        
    }
}  