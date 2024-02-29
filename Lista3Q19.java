import java.util.Scanner;

public class Lista3Q19{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        
        System.out.println("Digite o nome da sua cidade: ");
        String cidade=s.nextLine();
        
        if(cidade.charAt(0)=='s' || cidade.charAt(0)=='S'){
            System.out.println("\nO nome da sua cidade comeca com S.");
        }
        else{
            System.out.println("\nO nome da sua cidade nao comeca com S.");
        }
    }
}
