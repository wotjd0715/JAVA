//시간표
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Timetable extends JFrame {
	JRadioButton[] colorb;
	JButton[] timeb;
	JLabel nowcolor;
	private JPanel timetablep1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timetable frame = new Timetable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Timetable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		setLayout(null);
		timetablep1 = new JPanel();
		timetablep1.setBounds(0, 0, 1000, 80);
		timetablep1.setBackground(Color.WHITE);
		timetablep1.setLayout(null);
		//홈버튼
		JButton gohome = new JButton("홈으로");
		gohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gui_base a = new Gui_base();
				a.setVisible(true);
				timetablep1.setVisible(false);
			}
		});
		gohome.setFont(new Font("굴림", Font.BOLD, 14));
		gohome.setBounds(850, 25, 100, 40);
		gohome.setBackground(Color.WHITE);
		timetablep1.add(gohome);
		JLabel p1l1 =new JLabel("시간표");
		p1l1.setFont(new Font("굴림", Font.BOLD, 32));
		p1l1.setBounds(400,25,150,60);
		timetablep1.add(p1l1);
		add(timetablep1);
		
		JPanel timetablep2 = new JPanel();
		timetablep2.setBounds(0, 80, 1000, 580);
		timetablep2.setBackground(Color.WHITE);
		timetablep2.setLayout(null);
		//시간나열
		JLabel l1 = new JLabel(" 09:00~09:30");JLabel l2 = new JLabel(" 09:30~10:00");JLabel l3 = new JLabel(" 10:00~10:30");
		JLabel l4 = new JLabel(" 10:30~11:00");JLabel l5 = new JLabel(" 11:00~11:30");JLabel l6 = new JLabel(" 11:30~12:00");
		JLabel l7 = new JLabel(" 12:00~12:30");JLabel l8 = new JLabel(" 12:30~13:00");JLabel l9 = new JLabel(" 13:00~13:30");
		JLabel l10 = new JLabel(" 13:30~14:00");JLabel l11 = new JLabel(" 14:00~14:30");JLabel l12 = new JLabel(" 14:30~15:00");
		JLabel l13 = new JLabel(" 15:00~15:30");JLabel l14 = new JLabel(" 15:30~16:00");JLabel l15 = new JLabel(" 16:00~16:30");
		JLabel l16 = new JLabel(" 16:30~17:00");JLabel l17 = new JLabel(" 17:00~17:30");JLabel l18 = new JLabel(" 17:30~18:00");
		JPanel p2p1 = new JPanel();
		p2p1.setLayout(new GridLayout(18,1));
		p2p1.add(l1);p2p1.add(l2);p2p1.add(l3);p2p1.add(l4);p2p1.add(l5);p2p1.add(l6);p2p1.add(l7);p2p1.add(l8);p2p1.add(l9);
		p2p1.add(l10);p2p1.add(l11);p2p1.add(l12);p2p1.add(l13);p2p1.add(l14);p2p1.add(l15);p2p1.add(l16);p2p1.add(l17);p2p1.add(l18);
		timetablep2.add(p2p1);
		p2p1.setBackground(Color.WHITE);
		p2p1.setBounds(120, 50, 80, 500);
		//시간표 클릭버튼
		JPanel p2p2 = new JPanel();
		p2p2.setLayout(new GridLayout(18,5,5,0));
		timeb = new JButton[90];
		for(int i = 0;i<90;i++) {
			timeb[i]=new JButton();
			p2p2.add(timeb[i]);
			timeb[i].setBackground(Color.WHITE);
			timeb[i].addActionListener(new action2());
		}
		timetablep2.add(p2p2);
		p2p2.setBackground(Color.WHITE);
		p2p2.setBounds(200, 50, 500, 500);
		//요일
		JPanel p2p3 = new JPanel();
		p2p3.setLayout(new GridLayout(1,5,5,0));
		JLabel[] dayl = new JLabel[5];
		dayl[0]=new JLabel("월요일");dayl[1]=new JLabel("화요일");dayl[2]=new JLabel("수요일");
		dayl[3]=new JLabel("목요일");dayl[4]=new JLabel("금요일");
		for(int i = 0;i<5;i++) {
			p2p3.add(dayl[i]);
			dayl[i].setBackground(Color.WHITE);
		}
		timetablep2.add(p2p3);
		p2p3.setBackground(Color.WHITE);
		p2p3.setBounds(228,20, 500, 50);

		//색깔선택
		JPanel p2p4 = new JPanel();
		p2p4.setLayout(new GridLayout(9,1,5,0));
		JLabel p2p4l1= new JLabel(" 칠할색을 선택해주세요");
		p2p4l1.setFont(new Font("굴림", Font.BOLD, 14));
		p2p4l1.setBackground(Color.WHITE);
		p2p4.add(p2p4l1);
		colorb = new JRadioButton[8];
		colorb[0]=new JRadioButton("RED");colorb[1]=new JRadioButton("GRAY");colorb[2]=new JRadioButton("PINK");
		colorb[3]=new JRadioButton("GREEN");colorb[4]=new JRadioButton("BULE");colorb[5]=new JRadioButton("YELLOW");
		colorb[6]=new JRadioButton("ORANGE");colorb[7]=new JRadioButton("CYAN");
		ButtonGroup group = new ButtonGroup();
		for(int i = 0;i<8;i++) {
			group.add(colorb[i]);
			p2p4.add(colorb[i]);
			colorb[i].setBackground(Color.WHITE);
			
			colorb[i].addActionListener(new action1());
		}
		nowcolor = new JLabel();
		p2p4.setBackground(Color.WHITE);
		timetablep2.add(p2p4);
		
		p2p4.setBounds(750,90, 150, 300);
		
		
		add(timetablep2);
	}
	class action1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String[] colors = {"RED","GRAY","PINK","GREEN","BULE","YELLOW","ORANGE","CYAN"};
			for(int i = 0; i<8;i++) {
			if(e.getSource() == colorb[i]) {
				nowcolor.setText(colors[i]);
			}
		}}
	}
	class action2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<90;i++) {
			if(e.getSource() == timeb[i]) {
			
					if(timeb[i].getBackground()==Color.WHITE) {
						if(nowcolor.getText()=="RED") {timeb[i].setBackground(Color.RED);}
						else if(nowcolor.getText()=="GRAY") {timeb[i].setBackground(Color.GRAY);}
						else if(nowcolor.getText()=="PINK") {timeb[i].setBackground(Color.PINK);}
						else if(nowcolor.getText()=="GREEN") {timeb[i].setBackground(Color.GREEN);}
						else if(nowcolor.getText()=="BULE") {timeb[i].setBackground(Color.BLUE);}
						else if(nowcolor.getText()=="YELLOW") {timeb[i].setBackground(Color.YELLOW);}
						else if(nowcolor.getText()=="ORANGE") {timeb[i].setBackground(Color.ORANGE);}
						else if(nowcolor.getText()=="CYAN") {timeb[i].setBackground(Color.CYAN);}
					}else {timeb[i].setBackground(Color.WHITE);}
				
			}}
		
		}}
	}

