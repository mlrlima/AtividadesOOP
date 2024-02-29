import java.util.Scanner;

public class Lista3Q32{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        
        System.out.println("Digite o raio do circulo: ");
        double raio=s.nextDouble();
        
        double perimetro=2*raio*Math.PI;
        System.out.printf("\nO perimetro do circulo eh: %.3f.",perimetro);
    }
}
