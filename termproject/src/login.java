//로그인
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class login extends JFrame {
   private JPanel panel;
   private JTextField st_g;
   private JPasswordField pw_g;
   Image img;
   protected Object length;

 public login() {
   setTitle("로그인");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1000, 700);
    setBackground(Color.WHITE);
    panel = new JPanel();
    panel.setBounds(700, 60, 300, 700);
    panel.setBackground(Color.WHITE);
    setContentPane(panel);
    panel.setLayout(null);
   
    JLabel st_label = new JLabel("학번");
    st_label.setBounds(150, 340, 160, 45);
    st_label.setFont(new Font("굴림", Font.BOLD, 25));
    panel.add(st_label);
    
    JLabel label = new JLabel("비밀번호");
    label.setBounds(150, 390, 160, 45);
    label.setFont(new Font("굴림", Font.BOLD, 25));
    panel.add(label);
    
    st_g = new JTextField(); // 학번 입력
    st_g.setBounds(310, 340, 310, 45);
    st_g.setFont(new Font("굴림", Font.PLAIN, 25));
    panel.add(st_g);
    st_g.setColumns(10);
    
    pw_g = new JPasswordField(); // 비밀번호 입력 받는 창
    pw_g.setBounds(310, 390, 310, 45);
    pw_g.setFont(new Font("굴림", Font.PLAIN, 25));
    panel.add(pw_g);
    
    JLabel warn=new JLabel("반드시 로그인 전, 회원가입을 먼저 해주십시오");
    warn.setBounds(310,290,300,70);
    panel.add(warn);
    
    JButton backbutton = new JButton("뒤로가기");
    backbutton.setBackground(Color.WHITE);
    backbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          sign_up a = new sign_up();
           a.setVisible(true);
          panel.setVisible(false);
          
       }
    });
    backbutton.setFont(new Font("굴림", Font.BOLD, 20));
    backbutton.setBounds(750, 20, 130, 40);
    panel.add(backbutton);
    
    JButton loginbutton = new JButton("로그인");
    loginbutton.setBackground(Color.WHITE);
    loginbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          
          String stn = st_g.getText();
          String pw = pw_g.getText();
          
          try {
             BufferedReader br = new BufferedReader(new FileReader("studentinformation.txt"));
             String line =null; //파일을 한줄씩 읽어 넣기 위한 변수
             String[] splitedStr=null; //하나의 line을 split하여 넣을 배열 splitedStr
             
             while( (line = br.readLine()) != null)
             {
                splitedStr=line.split("\n"); //엔터키를 기준으로 잘라서 splitedStr에 넣는다
                for(int i=0; i<(splitedStr.length); i++) {
                   if((stn+","+pw).equals(splitedStr[i]))
                   {
                         JOptionPane.showMessageDialog(panel, "로그인 되었습니다.");
                         setVisible(true);
                         Gui_base a = new Gui_base();
                         a.setVisible(true);
                         panel.setVisible(false);
                         break;
                      }
                      
                }
               
                   /* JOptionPane.showMessageDialog(panel,"로그인에 실패하였습니다.");
                    setVisible(true);
                    panel.setVisible(false);
                    login a = new login();
                    a.setVisible(true);
                    break;   
                 */
             }
             br.close();
          } catch (IOException e1) {e1.printStackTrace();}
       }
    });
    
    loginbutton.setBounds(650, 340, 160, 95);
    loginbutton.setFont(new Font("굴림", Font.BOLD, 25));
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
             login frame = new login();
             frame.setVisible(true);
             } catch (Exception e) {
                e.printStackTrace();
                }
          }
       });
    }
 }