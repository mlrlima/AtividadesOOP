import java.util.Scanner;

public class Lista3Q18{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        double base,altura,area;
        
        System.out.println("Digite o valor da base do retangulo: ");
        base=s.nextDouble();
        System.out.println("\nDigite o valor da altura: ");
        altura=s.nextDouble();
        
        area=base*altura;
        System.out.printf("\nA area do retangulo eh: %.2f.",area);
    }
}
