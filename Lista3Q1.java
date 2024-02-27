import java.util.Scanner;

public class Lista3Q1{
    public static void main(String[] args){
        String nome;
        Scanner s= new Scanner(System.in);
        
        System.out.println("Digite seu nome: ");
        nome=s.nextLine();
        
        System.out.println("Seja bem vindo(a), "+nome+"!");
    }
}
