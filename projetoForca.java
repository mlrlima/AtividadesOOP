//PROJETO 2 - JOGO DE PALAVRAS EM JAVA
//NOME: MARIA LUIZA RIBEIRO DE LIMA - RA: 848982
import java.util.*;

public class projetoForca{

    static class Cores{
        int tam=10;
        String[] a= new String[tam];
        Cores(){
        a[0]="AZUL";
        a[1]="VERMELHO";
        a[2]="VERDE";
        a[3]="ROSA";
        a[4]="AMARELO";
        a[5]="MARROM";
        a[6]="CINZA";
        a[7]="LARANJA";
        a[8]="PRETO";
        a[9]="BRANCO";
        }
    }

    static class Comidas{
        int tam=10;
        String[] a= new String[tam];
        Comidas(){
        a[0]="ARROZ";
        a[1]="FEIJAO";
        a[2]="PIZZA";
        a[3]="TAPIOCA";
        a[4]="LARANJA";
        a[5]="BRIGADEIRO";
        a[6]="SOPA";
        a[7]="SORVETE";
        a[8]="PASTEL";
        a[9]="COXINHA";
        }
    }

    static class Animais{
        int tam=10;
        String[] a= new String[tam];
        Animais(){
        a[0]="CACHORRO";
        a[1]="GATO";
        a[2]="CAVALO";
        a[3]="PASSARO";
        a[4]="BORBOLETA";
        a[5]="COBRA";
        a[6]="GIRAFA";
        a[7]="ORNITORRINCO";
        a[8]="TIGRE";
        a[9]="DINOSSAURO";
        }
    }

    public static void printar(char[] a, int tam){
        for(int i=0;i<tam;i++){
            System.out.printf("%c ",a[i]);
        }
        System.out.printf("\n");
    }
    
    public static void printarHangman(char[][] a){
        for(int i=0;i<6;i++){
                    for(int j=0;j<5;j++){
                        System.out.printf("%c",a[i][j]);
                    }
                    System.out.printf("\n");
                }
    }

    public static void main(String[] args){
        Scanner s= new Scanner (System.in);
        Random rand= new Random();
        Cores cores= new Cores();
        Comidas comidas= new Comidas();
        Animais animais= new Animais();
        int tamforca=15; //tamanho da maior palavra possivel
        char[] forca=new char[tamforca]; //jogo do usuario
        char[] jaJogadas= new char[26]; //tentativas erradas (26 eh o numero total de letras)
        
        /*
 0 1 2 3 4
0_ _ _ _
1|     |
2|     o
3|   / | \
4|   /   \
5|
*/
        char[][] hangman= new char[6][5]; //bonequinho
        for(int i=0;i<4;i++){
            hangman[0][i]='_';
        }
        for(int i=1;i<6;i++){
            hangman[i][0]='|';
        }
        for(int i=1;i<6;i++){
            for(int j=1;j<5;j++){
                hangman[i][j]=' ';
            }
        }
        hangman[1][3]='|';
        hangman[0][4]=' ';
        
        System.out.println("*** JOGO DA FORCA ***");
        char op;
        do{
            
            System.out.print("\nOpcoes: \nSair - 0 \nJogar - qualquer outro caractere\n");
            op=s.next().charAt(0);
            if(op=='0'){break;}

            char letra,l; 
            for(int i=0;i<tamforca;i++){
                forca[i]='_';
            }
            hangman[2][3]=' ';
            hangman[3][3]=' ';
            hangman[3][2]=' ';
            hangman[3][4]=' ';
            hangman[4][2]=' ';
            hangman[4][4]=' ';
            
            int erros=0,sn=0,completa;
            int tema=rand.nextInt(3); //escolhe um dos 3 temas
            int p,qual;
            String palavra="aaaa",dica="aaaa";

            switch(tema){
                case 0:
                    dica="Cor";
                    qual=cores.tam;
                    p=rand.nextInt(qual); //escolhe uma das palavras do tema
                    palavra=cores.a[p];
                    break;
                case 1:
                    dica="Comida";
                    qual=comidas.tam;
                    p=rand.nextInt(qual); //escolhe uma das palavras do tema
                    palavra=comidas.a[p];
                    break;
                case 2:
                    dica="Animal";
                    qual=animais.tam;
                    p=rand.nextInt(qual); //escolhe uma das palavras do tema
                    palavra=animais.a[p];
                    break;
            }

            int tamPalavra= palavra.length();
            
    
            while(true){
                System.out.printf("\n***************\n");
                
                System.out.printf("Dica: %s\n",dica);
                printar(forca,tamPalavra);
                printarHangman(hangman);
                
                System.out.printf("\nErros: %d/6\n",erros);
                if(erros>0){
                    System.out.printf("Tentativas erradas: \n");
                    printar(jaJogadas,erros);
                }

                do{
                    System.out.printf("\nDigite uma letra: ");
                    letra=s.next().charAt(0);
                    l=Character.toUpperCase(letra);
                }while(l<65 || l>90); //apenas aceita letras
                
                sn=0;
                if(erros>0){
                    for(int i=0;i<erros;i++){
                        if(jaJogadas[i]==l){
                            System.out.printf("Letra ja jogada.\n");
                            sn=1;
                            break;
                        }
                    }
                }
                if(sn==1){continue;}
    
                completa=0;
                sn=0;
                for(int i=0;i<tamPalavra;i++){
                    if(palavra.charAt(i)==l){
                        forca[i]=l;
                        sn=1;
                    }
                    if(forca[i]!='_'){completa++;}
                }
    
                if(sn==0){
                    jaJogadas[erros]=l;
                    erros++;
                    
                    switch(erros){
                        case 1:
                            hangman[2][3]='o';
                            break;
                        case 2:
                            hangman[3][3]='|';
                            break;
                        case 3:
                            hangman[3][2]='/';
                            break;
                        case 4:
                            hangman[3][4]=92;// \
                            break;
                        case 5:
                            hangman[4][2]='/';
                            break;
                        case 6:
                            hangman[4][4]=92;// \
                            break;
                    }
                }
                if(erros==6 || completa==tamPalavra){
                    break;
                }
    
            }
    
            if(erros==6){
                printarHangman(hangman);
                System.out.printf("\nVoce perdeu! A palavra era: %s \n",palavra);
            }
            else{
                printar(forca,tamPalavra);
                System.out.printf("\nVoce ganhou!!!\n",palavra);
            }
            
        }while(op!='0');
        System.out.print("*************** \n ***Jogo terminado*** \n");
    }
}