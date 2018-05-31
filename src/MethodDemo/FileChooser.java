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
        jfc.showDialog(new JLabel(), "閫夋嫨");  
        File file=jfc.getSelectedFile();  
        printFile(file,0);
          
    }  
  
    
    public static void printFile(File file,int l){
        String str = new String();  //鐢熸垚琛ュ厖绌烘牸
        for(int i=0;i<l;i++){
            str +=" " ;
        }
        //鍏堣緭鍑鸿嚜宸卞悗杈撳嚭瀛愮洰褰曟垨鏂囦欢
        formatPrint(file,str);
        format(file, Model);
        
        if(file.isDirectory()){  //鍒ゆ柇鏄惁涓虹洰褰�
            File[] files = file.listFiles();  //鑾峰彇鐩綍涓嬫枃浠跺垪琛�
            for(File f:files){//閫掑綊杈撳嚭鏂囦欢
                printFile(f,l+3);
            }
             
        }
    }
    
    public static void Print(File file,String str) {
    	System.out.println(file.getPath());
    }
    
    
    public static void formatPrint(File file,String str){
        //鍏堣緭鍑烘枃浠�
        String[] names = file.getName().split("[.]");
        long time = file.lastModified();//鑾峰彇鏂囦欢淇敼鏃堕棿
        String ctime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(time));
        
        System.out.println("鍚嶇О锛� "+str+file.getName()  
                + "       绫诲瀷锛�"+names[names.length-1]+"鏂囦欢"
                + "       "+"  澶у皬锛� "+file.length()+"  璺緞锛� "+file.getPath()+"  鏈�鍚庝慨鏀规椂闂达細"+ctime);
    }
    
    public static void format(File file,Data1 d){
    	String[] names = file.getName().split("[.]");
        long time = file.lastModified();//鑾峰彇鏂囦欢淇敼鏃堕棿
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