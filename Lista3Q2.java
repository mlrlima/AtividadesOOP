import java.util.Scanner;
import static java.lang.Integer.*;

public class Lista3Q2{
    public static void main(String[] args){
        String idadeStr;
        
        Scanner s= new Scanner(System.in);
        System.out.println("Digite sua idade: ");
        idadeStr= s.next();
        
        int idade= Integer.parseInt(idadeStr);
        
        System.out.println("Sua idade eh: "+idade);
    }
}
