import java.util.*;

public class practice {
public static void main(String[] args){
  Scanner s= new Scanner(System.in);
    System.out.print("단수를 입력하세요");
    int a = s.nextInt();
    for(int i=0;i<a;i++){
        for(int j=0+i;j<2*a;j++){
            if(j%2==1){
                System.out.print("#");
            }
            else{
                System.out.print("+");
            }
           System.out.println(""); 
        }
    }
    
    
    
}

}
