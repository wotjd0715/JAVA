//�α���
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
   setTitle("�α���");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1000, 700);
    setBackground(Color.WHITE);
    panel = new JPanel();
    panel.setBounds(700, 60, 300, 700);
    panel.setBackground(Color.WHITE);
    setContentPane(panel);
    panel.setLayout(null);
   
    JLabel st_label = new JLabel("�й�");
    st_label.setBounds(150, 340, 160, 45);
    st_label.setFont(new Font("����", Font.BOLD, 25));
    panel.add(st_label);
    
    JLabel label = new JLabel("��й�ȣ");
    label.setBounds(150, 390, 160, 45);
    label.setFont(new Font("����", Font.BOLD, 25));
    panel.add(label);
    
    st_g = new JTextField(); // �й� �Է�
    st_g.setBounds(310, 340, 310, 45);
    st_g.setFont(new Font("����", Font.PLAIN, 25));
    panel.add(st_g);
    st_g.setColumns(10);
    
    pw_g = new JPasswordField(); // ��й�ȣ �Է� �޴� â
    pw_g.setBounds(310, 390, 310, 45);
    pw_g.setFont(new Font("����", Font.PLAIN, 25));
    panel.add(pw_g);
    
    JLabel warn=new JLabel("�ݵ�� �α��� ��, ȸ�������� ���� ���ֽʽÿ�");
    warn.setBounds(310,290,300,70);
    panel.add(warn);
    
    JButton backbutton = new JButton("�ڷΰ���");
    backbutton.setBackground(Color.WHITE);
    backbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          sign_up a = new sign_up();
           a.setVisible(true);
          panel.setVisible(false);
          
       }
    });
    backbutton.setFont(new Font("����", Font.BOLD, 20));
    backbutton.setBounds(750, 20, 130, 40);
    panel.add(backbutton);
    
    JButton loginbutton = new JButton("�α���");
    loginbutton.setBackground(Color.WHITE);
    loginbutton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          
          String stn = st_g.getText();
          String pw = pw_g.getText();
          
          try {
             BufferedReader br = new BufferedReader(new FileReader("studentinformation.txt"));
             String line =null; //������ ���پ� �о� �ֱ� ���� ����
             String[] splitedStr=null; //�ϳ��� line�� split�Ͽ� ���� �迭 splitedStr
             
             while( (line = br.readLine()) != null)
             {
                splitedStr=line.split("\n"); //����Ű�� �������� �߶� splitedStr�� �ִ´�
                for(int i=0; i<(splitedStr.length); i++) {
                   if((stn+","+pw).equals(splitedStr[i]))
                   {
                         JOptionPane.showMessageDialog(panel, "�α��� �Ǿ����ϴ�.");
                         setVisible(true);
                         Gui_base a = new Gui_base();
                         a.setVisible(true);
                         panel.setVisible(false);
                         break;
                      }
                      
                }
               
                   /* JOptionPane.showMessageDialog(panel,"�α��ο� �����Ͽ����ϴ�.");
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
    loginbutton.setFont(new Font("����", Font.BOLD, 25));
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