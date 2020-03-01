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
/*<변수정리>
 * S major:전공,교양,전공기반 / I grade:학년 / I mscore:과목학점 /S classname:과목이름
 *<class 정리>
 *AddClass:메모장에 class의 전공,학년,학점,이름을 불러온뒤 list배열형태로 classlist 배열에 저장
*/

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Recommand extends JFrame {
	ArrayList<ArrayList> class1 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class2 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class3 = new  ArrayList<ArrayList>();
	ArrayList<ArrayList> class4 = new  ArrayList<ArrayList>();
	String[] mn= {"공학전공","교양","전공기반","기본소양"};
	int[] m = {0,0,0,0};
	int count=0;	
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
		
	JPanel mainp,p1,p2,p3;
	JTextField search;
	JLabel title,p1l1,p1l2,p1l3,p1l4,p3l11,p3l22,p3l33,p3l44,p3ll;
	JLabel[] p2l,p3l;
	JButton searchb,searchb2,reco;
	String[] abeek = {"Y","N"};
	String[] age = {"1","2","3","4"};
	JComboBox abeekc,agec;
	
	public Recommand() {
		setBounds(0, 0, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("과목추천");
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
        title = new JLabel("수강과목입력");
        search = new JTextField();
        searchb2 = new JButton();
        searchb2.addActionListener(new Action2());
        searchb2.setText("과목명검색");
        title.setFont(new Font("굴림", Font.PLAIN, 32));
        search.setFont(new Font("굴림", Font.PLAIN, 15));
        abeekc = new JComboBox(abeek); 
        p1l1=new JLabel("ABEEK선택");
        
      //홈버튼
        JButton gohome = new JButton("홈으로");
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
  		gohome.setFont(new Font("굴림", Font.BOLD, 14));
  		gohome.setBackground(Color.WHITE);   
  		//홉버튼 끝
        p1.add(title); title.setBounds(420,5, 200, 40);
        p1.add(search); search.setBounds(320, 50, 300, 20);
        p1.add(searchb2); searchb2.setBounds(623, 50, 110, 20);
        search.setColumns(10);
        p1.add(p1l1).setBounds(190, 50, 70, 20);
        p1.add(abeekc).setBounds(260, 50, 40, 20);
        p1.add(gohome).setBounds(850, 15, 100, 40);
        
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(13,3));
        for(int i=0; i<39; i++) {
        	p2l[i].setText(null);
        	p2.add(p2l[i]);
        }
        
        
        p3 = new JPanel();
        p3.setLayout(null);
        p3l = new JLabel[4];
        p3l11 = new JLabel(mn[0]); p3l[0] = new JLabel(Integer.toString(m[0]));
        p3l22 = new JLabel(mn[1]); p3l[1] = new JLabel(Integer.toString(m[1]));
        p3l33 = new JLabel(mn[2]); p3l[2] = new JLabel(Integer.toString(m[2]));
        p3l44 = new JLabel(mn[3]); p3l[3] = new JLabel(Integer.toString(m[3]));
        p3.add(p3l11).setBounds(190, 10, 50, 20);p3.add(p3l22).setBounds(290, 10, 50, 20);
        p3.add(p3l33).setBounds(390, 10, 50, 20);p3.add(p3l44).setBounds(490, 10, 50, 20);
        p3.add(p3l[0]).setBounds(240, 10, 50, 20);p3.add(p3l[1]).setBounds(340, 10, 50, 20);
        p3.add(p3l[2]).setBounds(440, 10, 50, 20);p3.add(p3l[3]).setBounds(540, 10, 50, 20);
        reco = new JButton("추천받기"); p3.add(reco).setBounds(850, 10, 100, 40);
        p3ll = new JLabel("추천받을 학년선택");p3.add(p3ll).setBounds(740, 7, 150, 20);
        agec = new JComboBox(age); p3.add(agec).setBounds(750, 25, 80, 20);
        reco.addActionListener(new Action1());
    //--------------------------------------
        mainp.add(p1);
        p1.setBounds(0, 0, 1000, 100);
        p1.setBackground(Color.WHITE);
        mainp.add(p2).setBounds(0,100, 1000,500);
        p2.setBackground(Color.WHITE);
        mainp.add(p3).setBounds(0,600,1000,100);
        p3.setBackground(Color.WHITE);
        add(mainp);
        setVisible(true);
   
}
	 class Action1 implements ActionListener{
	      public void actionPerformed(ActionEvent e) { title.setText("추천과목목록");
	    	  String check2 = agec.getSelectedItem().toString();
	    	  String[] see = new String[39]; 
	    	  int count2=0,count3=0;
	    	  switch(check2) {
	    	  case"1": count2=0;count3=0;for(int i=0; i<39; i++) {see[i]=null;}
	    		  for(int i=0; i<14; i++) {
	    			  for(int k=0; k<39;k++) {
	    	  		  			if(class1.get(i).toString().equalsIgnoreCase(p2l[k].getText())) 
	    	  		  			{see[count2]=class1.get(i).toString(); count2+=1;}
	    	  		  			else {} }}
	    		  	for(int x=0; x<39; x++) {
	    		  		for(int y = (x+1) ; y<39; y++) {
	    		  			if(see[x]==see[y]) {see[y]=null;}
	    		  		}
	    		  	}
	    			
	    		  	 for(int i=0; i<14; i++) {
	    		  		
	    		  		loop1: for(int k = 0; k<count2; k++) {
	    	  			  if(class1.get(i).toString().equalsIgnoreCase(see[k])) {
	    	  			  }else {
	    	  				  p2l[count3].setText(class1.get(i).toString()); count3+=1; break loop1;}
	    	  				  }	 
	    	  		  }
	    		  	
	    		  	 if(count2==0) {for(int i=0; i<14; i++) {p2l[i].setText(class1.get(i).toString());}}
	    	  		  break;
	    	  case"2": count2=0;count3=0;for(int i=0; i<39; i++) {see[i]=null;}
	    	  for(int i=0; i<19; i++) {
    			  for(int k=0; k<39;k++) {
    	  		  			if(class2.get(i).toString().equalsIgnoreCase(p2l[k].getText())) 
    	  		  			{see[count2]=class2.get(i).toString(); count2+=1;}
    	  		  			else {} }}
    		  	for(int x=0; x<39; x++) {
    		  		for(int y = (x+1) ; y<39; y++) {
    		  			if(see[x]==see[y]) {see[y]=null;}
    		  		}
    		  	}
    		  	for(int x=0; x<39; x++) {
    		  		System.out.println(see[x]+"//"+class2.get(x).toString());
    		  		
    		  	}
    		  		
    		  	 for(int i=0; i<19; i++) {
    		  		 
    		  		loop2:for(int k = 0; k<count2; k++) {
    	  			  if(class2.get(i).toString().equalsIgnoreCase(see[k])) {
    	  			  }else {
    	  				  p2l[count3].setText(class2.get(i).toString()); count3+=1; break loop2;}
    	  				  }	 
    	  		  }
    		  	
    		  	 if(count2==0) {for(int i=0; i<19; i++) {p2l[i].setText(class2.get(i).toString());}}
    	  		  break;
	    	  case"3": count2=0;count3=0;for(int i=0; i<39; i++) {see[i]=null;}
	    	  for(int i=0; i<23; i++) {
    			  for(int k=0; k<39;k++) {
    	  		  			if(class3.get(i).toString().equalsIgnoreCase(p2l[k].getText())) 
    	  		  			{see[count2]=class3.get(i).toString(); count2+=1;}
    	  		  			else {} }}
    		  	for(int x=0; x<39; x++) {
    		  		for(int y = (x+1) ; y<39; y++) {
    		  			if(see[x]==see[y]) {see[y]=null;}
    		  		}
    		  	}
    			
    		  	 for(int i=0; i<23; i++) {
    		  		
    		  		loop3: for(int k = 0; k<count2; k++) {
    	  			  if(class3.get(i).toString().equalsIgnoreCase(see[k])) {
    	  			  }else {
    	  				  p2l[count3].setText(class3.get(i).toString()); count3+=1; break loop3;}
    	  				  }	 
    	  		  }
    		  	
    		  	 if(count2==0) {for(int i=0; i<23; i++) {p2l[i].setText(class3.get(i).toString());}}
    	  		  break;
	    	  case"4": count2=0;count3=0;for(int i=0; i<39; i++) {see[i]=null;}
	    	  for(int i=0; i<29; i++) {
    			  for(int k=0; k<39;k++) {
    	  		  			if(class4.get(i).toString().equalsIgnoreCase(p2l[k].getText())) 
    	  		  			{see[count2]=class4.get(i).toString(); count2+=1;}
    	  		  			else {} }}
    		  	for(int x=0; x<39; x++) {
    		  		for(int y = (x+1) ; y<39; y++) {
    		  			if(see[x]==see[y]) {see[y]=null;}
    		  		}
    		  	}
    			
    		  	 for(int i=0; i<29; i++) {
    		  		
    		  		loop4: for(int k = 0; k<count2; k++) {
    	  			  if(class4.get(i).toString().equalsIgnoreCase(see[k])) {
    	  			  }else {
    	  				  p2l[count3].setText(class4.get(i).toString()); count3+=1; break loop4;}
    	  				  }	 
    	  		  }
    		  	
    		  	 if(count2==0) {for(int i=0; i<29; i++) {p2l[i].setText(class4.get(i).toString());}}
    	  		  break;
	    	  
	    	  }
	    		}}
	 class Action2 implements ActionListener{
	      public void actionPerformed(ActionEvent e) { 
	    	  String check =search.getText(); 
	    		try {   for(int i=count; i<39; i++) {p2l[i].setText(null);}
	    		for(int i=0; i<14; i++) {
	    		if(check.equalsIgnoreCase(class1.get(i).get(3).toString())) {
	    			p2l[count].setText(class1.get(i).toString());
	    			count+=1;
	    			if(abeekc.getSelectedItem().toString().equalsIgnoreCase("Y")) {
	    				for(int k =0;k<4;k++) {
	    				if(class1.get(i).get(0).toString().equalsIgnoreCase(mn[k]))
	    				{
	    				m[k] += Integer.parseInt(class1.get(i).get(2).toString());
	    				p3l[k].setText(Integer.toString(m[k]));
	    				}
	    				}
	    			}
	    			else {
	    				if(class1.get(i).get(0).toString().equalsIgnoreCase(mn[0]))
	    				{
	    				m[0] += Integer.parseInt(class1.get(i).get(2).toString());
	    				p3l[0].setText(Integer.toString(m[0]));
	    				}else {
	    					m[1]+=Integer.parseInt(class1.get(i).get(2).toString());
	    					p3l[1].setText(Integer.toString(m[1]));
	    				}
	    				
	    			}	
	    		}}	
	    		for(int i=0; i<19; i++) {
	    		if(check.equalsIgnoreCase(class2.get(i).get(3).toString())) {
	    			p2l[count].setText(class2.get(i).toString());
	    			count+=1;
	    			if(abeekc.getSelectedItem().toString().equalsIgnoreCase("Y")) {
	    				for(int k =0;k<4;k++) {
	    				if(class2.get(i).get(0).toString().equalsIgnoreCase(mn[k]))
	    				{
	    				m[k] += Integer.parseInt(class2.get(i).get(2).toString());
	    				p3l[k].setText(Integer.toString(m[k]));
	    				}
	    				}
	    			}
	    			else {
	    				if(class2.get(i).get(0).toString().equalsIgnoreCase(mn[0]))
	    				{
	    				m[0] += Integer.parseInt(class2.get(i).get(2).toString());
	    				p3l[0].setText(Integer.toString(m[0]));
	    				}else {
	    					m[1]+=Integer.parseInt(class2.get(i).get(2).toString());
	    					p3l[1].setText(Integer.toString(m[1]));
	    				}
	    				
	    			}	
		    			
		    		
	    		}}	
	    		for(int i=0; i<23; i++) {
	    		if(check.equalsIgnoreCase(class3.get(i).get(3).toString())) {
	    			p2l[count].setText(class3.get(i).toString());
	    			count+=1;
	    			if(abeekc.getSelectedItem().toString().equalsIgnoreCase("Y")) {
	    				for(int k =0;k<4;k++) {
	    				if(class3.get(i).get(0).toString().equalsIgnoreCase(mn[k]))
	    				{
	    				m[k] += Integer.parseInt(class3.get(i).get(2).toString());
	    				p3l[k].setText(Integer.toString(m[k]));
	    				}
	    				}
	    			}
	    			else {
	    				if(class3.get(i).get(0).toString().equalsIgnoreCase(mn[0]))
	    				{
	    				m[0] += Integer.parseInt(class3.get(i).get(2).toString());
	    				p3l[0].setText(Integer.toString(m[0]));
	    				}else {
	    					m[1]+=Integer.parseInt(class3.get(i).get(2).toString());
	    					p3l[1].setText(Integer.toString(m[1]));
	    				}
	    				
	    			}	
	    		}}	
	    		for(int i=0; i<29; i++) {
	    		if(check.equalsIgnoreCase(class4.get(i).get(3).toString())) {
	    			p2l[count].setText(class4.get(i).toString());
	    			count+=1;
	    			if(abeekc.getSelectedItem().toString().equalsIgnoreCase("Y")) {
	    				for(int k =0;k<4;k++) {
	    				if(class4.get(i).get(0).toString().equalsIgnoreCase(mn[k]))
	    				{
	    				m[k] += Integer.parseInt(class4.get(i).get(2).toString());
	    				p3l[k].setText(Integer.toString(m[k]));
	    				}
	    				}
	    			}
	    			else {
	    				if(class4.get(i).get(0).toString().equalsIgnoreCase(mn[0]))
	    				{
	    				m[0] += Integer.parseInt(class4.get(i).get(2).toString());
	    				p3l[0].setText(Integer.toString(m[0]));
	    				}else {
	    					m[1]+=Integer.parseInt(class4.get(i).get(2).toString());
	    					p3l[1].setText(Integer.toString(m[1]));
	    				}
	    				
	    			}	
	    		}}
	    		}
	    		catch(Exception e1) {e1.printStackTrace();}
	      }}
	 
public static void main(String args[]) throws Exception{
	ArrayList<ArrayList> classlist = new ArrayList<ArrayList>();
	
	
	Recommand t =  new Recommand();
}
}
