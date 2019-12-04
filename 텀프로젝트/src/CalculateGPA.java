//학점계산
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateGPA extends JFrame {
   int count=0;
	private JButton button, plus,minus;
   private JTextField name; //과목명, 학점, 성적
   JTextField[] score2;
   JComboBox[]  gradelist2;
   JPanel[] addclassp2;
   JPanel mainp,panel1,panel3;
   JLabel classnum,result,p3l1,l1;
   String[] grades = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","D0","D-","F","PASS","FAIL"};
public CalculateGPA() {
	  setBounds(0, 0, 1000, 700);
	  setBackground(Color.WHITE);
      setTitle("학점 계산");
      setLayout(null);
      
      mainp = new JPanel();
      mainp.setLayout(null);
      //객체초기화
      panel1=new JPanel();
      panel3 = new JPanel();
      panel1.setLayout(new GridLayout(9,2,5,5));
      addclassp2 = new JPanel[17];
      for(int j=0; j<17;j++) {
    	  addclassp2[j]= new JPanel();
      }
      score2 = new JTextField[17];
      for(int j=0; j<17;j++) {
    	  score2[j]= new JTextField();
      }
      gradelist2=new JComboBox[17];
      for(int j=0; j<17;j++) {
    	  gradelist2[j]= new JComboBox(grades);
      }
      //맨위 학점계산기
      p3l1=new JLabel("학점계산기");
     
      panel3.add(p3l1);
      p3l1.setFont(new Font("굴림", Font.BOLD, 32));
      mainp.add(panel3);
      panel3.setLayout(null);
      p3l1.setBounds(400,15,300,35);
      panel3.setBackground(Color.white);
      panel3.setBounds(0, 0, 1000, 60);
      //홈버튼
      JButton gohome = new JButton("홈으로");
		gohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui_base a = new Gui_base();
				a.setVisible(true);
				CalculateGPA b = new CalculateGPA();
				b.setVisible(false);
			}
		});
		gohome.setFont(new Font("굴림", Font.BOLD, 14));
		gohome.setBounds(850, 15, 100, 40);
		gohome.setBackground(Color.WHITE);   
		panel3.add(gohome);
		//홉버튼 끝
      //결과표출panel
      JPanel panel2 = new JPanel();
      panel2.setLayout(null);
      panel2.setBounds(700, 60, 300, 700);
      panel2.setBackground(Color.white);
      JLabel p2l1 = new JLabel("과목추가하기");
      JLabel p2l2 = new JLabel("과목빼기");
      panel2.add(p2l1);
      panel2.add(p2l2);
      p2l1.setBounds(10,0, 100, 30);
      p2l2.setBounds(120,0, 100, 30);
      //과목추가
      plus=new JButton("+");
      minus = new JButton("-");
      plus.addActionListener(new Action1());
      minus.addActionListener(new Action3());
      panel2.add(plus);
      panel2.add(minus);
      plus.setBackground(Color.WHITE);
      plus.setBounds(10, 30, 100, 30);
      plus.setFont(new Font("굴림", Font.BOLD, 14));
      minus.setBackground(Color.WHITE);
      minus.setBounds(120, 30, 100, 30);
      minus.setFont(new Font("굴림", Font.BOLD, 14));
      //계산
      button=new JButton("계산");
      button.addActionListener(new Action2());
      panel2.add(button);
      button.setBounds(70,100, 100, 30);
      button.setBackground(Color.WHITE);
      
      //결과표시
      classnum = new JLabel("수강 과목수: ");
      l1 = new JLabel("수강학점");
      result = new JLabel("평균: 0/4.3");
      panel2.add(classnum);
      panel2.add(l1);
      classnum.setBounds(10,130,100,30);
      classnum.setFont(new Font("굴림", Font.BOLD, 14));
      l1.setBounds(10,150,100,30);
      l1.setFont(new Font("굴림", Font.BOLD, 14));
      panel2.add(result);
      result.setBounds(10,170,200,30);
      result.setFont(new Font("굴림", Font.BOLD, 14));
      
      //패널입력
      mainp.add(panel2);
      mainp.add(panel1);
      panel1.setBackground(Color.white);
      panel1.setBounds(0, 60, 700, 620);
      add(mainp);
      mainp.setBounds(0, 0, 1000, 700);
      mainp.setBackground(Color.WHITE);
      setVisible(true);
   }
   class Action1 implements ActionListener{// 과목입력버튼 추가
      public void actionPerformed(ActionEvent e) {
    	  if(count<16) {
    			  addclassp2[count] = new JPanel();
    			  addclassp2[count].setLayout(new FlowLayout());
    			  addclassp2[count].add(new JLabel("과목명"));
    			  name=new JTextField(20);
    			  addclassp2[count].add(name);
          
    			  addclassp2[count].add(new JLabel("학점"));
    			  score2[count]=new JTextField(5);
    			  addclassp2[count].add(score2[count]);
          
    			  addclassp2[count].add(new JLabel("성적"));
    			  gradelist2[count]=new JComboBox(grades);
    			  addclassp2[count].add(gradelist2[count]);
    			  panel1.add(addclassp2[count]);
    			  addclassp2[count].setSize(700, 150);
    			  addclassp2[count].setBackground(Color.LIGHT_GRAY);
    			  count=count+1;
    			  classnum.setText("수강 과목수: "+Integer.toString(count));
    	  } 
    		  }
   }
   class Action2 extends Exception implements ActionListener{//학점계산
	      public void actionPerformed(ActionEvent e) {
	    	  float totalscore=0,totalmajorscore=0;
	    	  int total=0;
	    	  for(int k = 0; k<count; k++) {
	    	try {
	    	totalscore = totalscore + Float.parseFloat(score2[k].getText())*change(gradelist2[k].getSelectedItem().toString());
	    	  if(gradelist2[k].getSelectedItem().toString()=="PASS") {
	    		  total +=Integer.parseInt(score2[k].getText());
    		  }else {
    			  totalmajorscore= totalmajorscore+Float.parseFloat(score2[k].getText());
    			  total +=Integer.parseInt(score2[k].getText());
    		  }  
	    	  float result2=(totalscore/totalmajorscore);
	    	  l1.setText(String.format("수강학점: "+total));
	    	  result.setText(String.format("평균: "+"%.2f", result2)+"/4.30");
	    	  }catch(Exception e1) {e1.printStackTrace();}
	      }}
	      public float change(String a){
		    	float score = 0;
		    	switch(a){
		    		case"A+":score=(float) 4.3; break;
		    		case"A0":score=(float) 4.0;   break;
		    		case"A-":score=(float) 3.7;   break;
		    		case"B+":score=(float) 3.3;  break;
		    		case"B0":score=(float) 3.0;  break;
		    		case"B-":score=(float) 2.7;   break;
		    		case"C+":score=(float) 2.3;  break;
		    		case"C0":score=(float) 2.0; break;
		    		case"C-":score=(float) 1.7;  break;
		    		case"D+":score=(float) 1.3;   break;
		    		case"D0":score=(float) 1.0;  break;
		    		case"D-":score=(float) 0.7;   break;
		    		case"F":score=(float) 0;   break;
		    		case"FAIL":score=(float) 0;   break;
		    		case"PASS":score=(float) 0;   break;
		    	}
		    	return  score;
		    }      
   
   }
   class Action3 implements ActionListener{//GridLayout에서 9,2로 행렬로했는데 remove써도 열일떄만 줄어들고 행은 줄어들지 않음
	      public void actionPerformed(ActionEvent e) {
	    	  if(count>1) {
	    		count -=1;
	    		panel1.remove(0);
	    		classnum.setText("계산 과목수:"+Integer.toString(count));
	    	  } 
	    		  }
	   }
   public static void main(String[] args) {
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateGPA frame = new CalculateGPA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
   
}