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
   setTitle("ȸ������");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1000, 700);
    setBackground(Color.WHITE);
    panel = new JPanel();
    panel.setBackground(WHITE);
    setContentPane(panel);
    panel.setLayout(null);
    
    JLabel stlabel = new JLabel("�й�");
    stlabel.setFont(new Font("����", Font.BOLD, 25));
    stlabel.setBounds(150, 340, 160, 45);
    panel.add(stlabel);
    
    JLabel pwlabel = new JLabel("��й�ȣ");
    pwlabel.setFont(new Font("����", Font.BOLD, 25));
    pwlabel.setBounds(150, 390, 160, 45);
    panel.add(pwlabel);
   
    
    st = new JTextField(); //�й� â
    st.setFont(new Font("����", Font.PLAIN, 25));
    st.setBounds(310, 340, 310, 45);
    panel.add(st);
    st.setColumns(10);
    
    pw = new JTextField(); //��й�ȣ â
    pw.setFont(new Font("����", Font.PLAIN, 25));
    pw.setColumns(10);
    pw.setBounds(310, 390, 310, 45);
    panel.add(pw);
    
    JLabel warn=new JLabel("�ݵ�� ���ڳ� �����ڸ� �������ֽʽÿ�");
    warn.setBounds(310,290,250,70);
    panel.add(warn);
  
    JButton signbutton = new JButton("ȸ������");
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
                JOptionPane.showMessageDialog(panel, "ȸ������ �Ǿ����ϴ�.");
                panel.setVisible(false);
                login c = new login();
                c.setVisible(true);
             }
          }
    });
    
    signbutton.setFont(new Font("����", Font.BOLD, 25));
    signbutton.setBounds(650, 340, 160, 95);
    panel.add(signbutton);
    
    JButton loginbutton = new JButton("�α���");
    loginbutton.setBackground(Color.WHITE);
    loginbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          login a = new login();
           a.setVisible(true);
          panel.setVisible(false);
       }
    });
    loginbutton.setFont(new Font("����", Font.BOLD, 20));
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