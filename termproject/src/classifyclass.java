//����˻�
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/*<��������>
 * S major:����,����,������� / I grade:�г� / I mscore:�������� /S classname:�����̸�
 *<class ����>
 *AddClass:�޸��忡 class�� ����,�г�,����,�̸��� �ҷ��µ� list�迭���·� classlist �迭�� ����
*/

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class classifyclass extends JFrame {
	ArrayList<ArrayList> class1 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class2 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class3 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class4 = new  ArrayList<ArrayList>();
	
	public  void addclass() {
		File f = new File("class.txt");
		if(f.exists()) {System.out.println(f.getAbsolutePath());
						}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("class.txt","r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			raf.seek(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line=null;
		try {
			while((line= raf.readLine())!= null) {
			ArrayList<String> clas = new  ArrayList<String>();
			String[] saveline ;
			String save;
			byte[] tmp = line.getBytes("iso-8859-1");
			line=new String(tmp,"utf-8");
			saveline= line.split(" ");
			String major = saveline[0]; String grade = saveline[1];
			String mscore = saveline[2]; String classname = saveline[3]; String classcode = saveline[4];
			clas.add(major);clas.add(grade);clas.add(mscore);clas.add(classname);clas.add(classcode);
			if(grade.equalsIgnoreCase("1")) {class1.add(clas);}
			if(grade.equalsIgnoreCase("2")) {class2.add(clas);}
			if(grade.equalsIgnoreCase("3")) {class3.add(clas);}
			else if(grade.equalsIgnoreCase("4")){class4.add(clas);}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	JPanel mainp,p1,p2,panel;
	JTextField search;
	JLabel title,p1l1,p1l2,p1l3,p1l4;
	JLabel[] p2l;
	JButton searchb,searchb2;
	String[] major = {"��������","�������","�⺻�Ҿ�"};
	String[] age = {"1","2","3","4"};
	String[] majors = {"3","5"};
	JComboBox majorc,agec,majorsc;
	
	public classifyclass() {
		setBounds(0, 0, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("����˻�");
        p2l = new JLabel[39];
        for(int i = 0; i<39; i++) {
        	p2l[i] = new JLabel();
        }
        try {
			addclass();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
        //main panel
        mainp = new JPanel();
        mainp.setBackground(Color.WHITE);
        mainp.setLayout(null);
        p1 = new JPanel();
        p1.setLayout(null);
        title = new JLabel("����˻�");
        search = new JTextField();
        searchb = new JButton();
        searchb2 = new JButton();
        searchb.addActionListener(new Action1());
        searchb2.addActionListener(new Action2());
        searchb.setText("�з��˻�");
        searchb2.setText("�����˻�");
        title.setFont(new Font("����", Font.PLAIN, 32));
        search.setFont(new Font("����", Font.PLAIN, 15));
        majorc = new JComboBox(major); agec = new JComboBox(age); majorsc = new JComboBox(majors);
        p1l1=new JLabel("����"); p1l2=new JLabel("�г�"); p1l3=new JLabel("��������");
        p1l4=new JLabel("[�����з�,�г�,��������,�����,�����ڵ�]");
      //Ȩ��ư
        JButton gohome = new JButton("Ȩ����");
  		gohome.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				Gui_base a = new Gui_base();
  				a.setVisible(true);
  				classifyclass b = null;
				try {
					b = new classifyclass();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
  				b.setVisible(false);
  			}
  		});
  		gohome.setFont(new Font("����", Font.BOLD, 14));
  		gohome.setBackground(Color.WHITE);   
  		//ȩ��ư ��
        p1.add(title); title.setBounds(420,5, 200, 40);
        p1.add(search); search.setBounds(320, 50, 300, 20);
        p1.add(searchb2); searchb2.setBounds(623, 50, 110, 20);
        p1.add(searchb); searchb.setBounds(645, 90, 90, 20);
        search.setColumns(10);
        p1.add(p1l1).setBounds(310, 90, 30, 20);
        p1.add(majorc).setBounds(340, 90, 80, 20);
        p1.add(p1l2).setBounds(440, 90, 30, 20);
        p1.add(agec).setBounds(470, 90, 50, 20);
        p1.add(p1l3).setBounds(540, 90, 50, 20);
        p1.add(majorsc).setBounds(590, 90, 50, 20);
        p1.add(gohome).setBounds(850, 15, 100, 40);
        p1.add(p1l4).setBounds(370, 112, 300, 20);
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(13,3));
        for(int i=0; i<39; i++) {
        	p2l[i].setText(null);
        	p2.add(p2l[i]);
        }
        
    //--------------------------------------
        mainp.add(p1);
        p1.setBounds(0, 0, 1000, 135);
        p1.setBackground(Color.WHITE);
        mainp.add(p2).setBounds(0,135, 1000, 545);
        p2.setBackground(Color.WHITE);
        add(mainp);
        setVisible(true);
   
}
	 class Action1 implements ActionListener{
	      public void actionPerformed(ActionEvent e) { 
	    	  String check =agec.getSelectedItem().toString();
	    		try {   for(int i=0; i<39; i++) {
	            	p2l[i].setText(null);
	            }
	    	  switch(check) {
	    		 case "1":
	    			 int count =0;
	    		 		for(int i = 0; i<14; i++) { 
	    			 if( majorc.getSelectedItem().toString().equalsIgnoreCase(class1.get(i).get(0).toString())&&
	    			 majorsc.getSelectedItem().toString().equalsIgnoreCase(class1.get(i).get(2).toString()) ){
	    		 p2l[count].setText(class1.get(i).toString());
	    		 count+=1;}
	    		 		}
	    		 		break;
	    		 case "2":
	    			 int count1 =0; for(int i = 0; i<19; i++) { 
	    			 if( majorc.getSelectedItem().toString().equalsIgnoreCase(class2.get(i).get(0).toString())&&
		    			 majorsc.getSelectedItem().toString().equalsIgnoreCase(class2.get(i).get(2).toString()) ){
		    		 p2l[count1].setText(class2.get(i).toString());count1+=1;}
	    			 }
	    		 break;
	    		 case "3":
	    			 int count11 =0; for(int i = 0; i<23; i++) { 
	    			 if( majorc.getSelectedItem().toString().equalsIgnoreCase(class3.get(i).get(0).toString())&&
		    			 majorsc.getSelectedItem().toString().equalsIgnoreCase(class3.get(i).get(2).toString()) ){
		    		 p2l[count11].setText(class3.get(i).toString());count11+=1;}
	    			}
	    		 break;
	    		 case "4":
	    			int count111 =0; for(int i = 0; i<29; i++) { 
	    			 if( majorc.getSelectedItem().toString().equalsIgnoreCase(class4.get(i).get(0).toString())&&
		    			 majorsc.getSelectedItem().toString().equalsIgnoreCase(class4.get(i).get(2).toString()) ){
		    		 p2l[count111].setText(class4.get(i).toString());count111+=1;}
	    			}
	    		 break;
	    		 				
	    		}}catch(Exception e1) {e1.printStackTrace();}
	    		}}
	 class Action2 implements ActionListener{
	      public void actionPerformed(ActionEvent e) { 
	    	  String check =search.getText();
	    		try {   for(int i=0; i<39; i++) {p2l[i].setText(null);}
	    		for(int i=0; i<14; i++) {
	    		if(check.equalsIgnoreCase(class1.get(i).get(3).toString())) {
	    			p2l[0].setText(class1.get(i).toString());
	    		}}	
	    		for(int i=0; i<19; i++) {
	    		if(check.equalsIgnoreCase(class2.get(i).get(3).toString())) {
	    			p2l[0].setText(class2.get(i).toString());
	    		}}	
	    		for(int i=0; i<23; i++) {
	    		if(check.equalsIgnoreCase(class3.get(i).get(3).toString())) {
	    			p2l[0].setText(class3.get(i).toString());
	    		}}	
	    		for(int i=0; i<29; i++) {
	    		if(check.equalsIgnoreCase(class4.get(i).get(3).toString())) {
	    			p2l[0].setText(class4.get(i).toString());
	    		}}}
	    		catch(Exception e1) {e1.printStackTrace();}
	    		}}
	 
public static void main(String args[]) throws Exception{
	ArrayList<ArrayList> classlist = new ArrayList<ArrayList>();
	
	
	classifyclass t =  new classifyclass();
}
}
