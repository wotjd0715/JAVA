import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class sign_up extends JFrame {

 private static final Color WHITE = null;
 private JPanel panel;
 private JTextField st;
 private JTextField pw;
 Image img;

 public sign_up() {
   setTitle("회원가입");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1000, 700);
    setBackground(Color.WHITE);
    panel = new JPanel();
    panel.setBackground(WHITE);
    setContentPane(panel);
    panel.setLayout(null);
    
    JLabel stlabel = new JLabel("학번");
    stlabel.setFont(new Font("굴림", Font.BOLD, 25));
    stlabel.setBounds(150, 340, 160, 45);
    panel.add(stlabel);
    
    JLabel pwlabel = new JLabel("비밀번호");
    pwlabel.setFont(new Font("굴림", Font.BOLD, 25));
    pwlabel.setBounds(150, 390, 160, 45);
    panel.add(pwlabel);
   
    
    st = new JTextField(); //학번 창
    st.setFont(new Font("굴림", Font.PLAIN, 25));
    st.setBounds(310, 340, 310, 45);
    panel.add(st);
    st.setColumns(10);
    
    pw = new JTextField(); //비밀번호 창
    pw.setFont(new Font("굴림", Font.PLAIN, 25));
    pw.setColumns(10);
    pw.setBounds(310, 390, 310, 45);
    panel.add(pw);
    
    JLabel warn=new JLabel("반드시 숫자나 영문자를 기입해주십시오");
    warn.setBounds(310,290,250,70);
    panel.add(warn);
  
    JButton signbutton = new JButton("회원가입");
    signbutton.setBackground(Color.WHITE);
    signbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
             String studentnumber = st.getText();
             String password = pw.getText();
             String student_infomation = null;
             
             try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("studentinformation.txt",true));
                student_infomation = studentnumber + "," + password;
                bw.write(student_infomation);
                if(bw != null)
                   { 
                   bw.newLine();
                   }
                bw.close(); 
                   
             }catch (Exception e1) { }
          
             if(student_infomation != null)
             {
                JOptionPane.showMessageDialog(panel, "회원가입 되었습니다.");
                panel.setVisible(false);
                login c = new login();
                c.setVisible(true);
             }
          }
    });
    
    signbutton.setFont(new Font("굴림", Font.BOLD, 25));
    signbutton.setBounds(650, 340, 160, 95);
    panel.add(signbutton);
    
    JButton loginbutton = new JButton("로그인");
    loginbutton.setBackground(Color.WHITE);
    loginbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          login a = new login();
           a.setVisible(true);
          panel.setVisible(false);
       }
    });
    loginbutton.setFont(new Font("굴림", Font.BOLD, 20));
    loginbutton.setBounds(650, 440, 160, 50);
    panel.add(loginbutton);
        
    ImageIcon img=new ImageIcon("logo2.png");
    JLabel image=new JLabel(img);
    image.setBounds(340, 35, 300,300);
    panel.add(image);
 }
 public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
       public void run() {
          try {
             sign_up frame = new sign_up();
             frame.setVisible(true);
             } catch (Exception e) {
                e.printStackTrace();
                }
          }
       });
    }
}