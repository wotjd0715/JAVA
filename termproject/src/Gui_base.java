//메인페이지
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	public class Gui_base extends JFrame{
		public Gui_base(){
			setBounds(0, 0, 1000, 700);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("에브리타임");
	        
	        //main panel
	        JPanel mainp = new JPanel();
	        mainp.setBackground(Color.WHITE);
	        mainp.setLayout(null);
	        JButton mainb1 = new JButton("과목검색");
	        JButton mainb2 = new JButton("학점계산");
	        JButton mainb3 = new JButton("시간표");
	        JButton mainb4 = new JButton("과목추천");
	        mainb1.setBounds(250,50,200,100); mainb2.setBounds(500,50,200,100);
	        mainb3.setBounds(250,200,200,100); mainb4.setBounds(500,200,200,100);
	        mainb1.setBackground(Color.WHITE);mainb2.setBackground(Color.WHITE);
	        mainb3.setBackground(Color.WHITE);mainb4.setBackground(Color.WHITE);
	        JLabel mainl1 = new JLabel();
	        mainl1.add(mainb1); mainl1.add(mainb2); mainl1.add(mainb3); mainl1.add(mainb4);
	        mainl1.setBounds(0,0,1000,700);
	        mainb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					classifyclass a = new classifyclass();
					a.setVisible(true);
					mainp.setVisible(false);
				}
			});
	        mainb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CalculateGPA a = new CalculateGPA();
					a.setVisible(true);
					mainp.setVisible(false);
				}
			});
	        mainb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Timetable a = new Timetable();
					a.setVisible(true);
					mainp.setVisible(false);
				}
			});
	        mainb4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Recommand a = new Recommand();
					a.setVisible(true);
					mainp.setVisible(false);
				}
			});
	        mainp.add(mainl1);
	        
	        //사진추가
	        JLabel mainl2 = new JLabel();
	        ImageIcon knuicon = new ImageIcon("knu.jpeg");
	        mainl2.setIcon(knuicon);
	        mainp.add(mainl2);
	        mainl2.setBounds(500,0,1000,700);
	        add(mainp);
	        setVisible(true);
	        
	    }
	    public static void main(String[] args){
	      Gui_base t =  new Gui_base();
	    }
	}

