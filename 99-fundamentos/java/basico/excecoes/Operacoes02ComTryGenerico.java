package basico.excecoes;
import java.util.Scanner;

public class Operacoes02ComTryGenerico {

    public static void main(String[] args) {
        System.out.println("Programa que divide números");
        System.out.print("Digite o numerador: ");
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            System.out.print("Digite o denominador: ");
            int d = sc.nextInt();       
            float resultado = (float) n / d;
            System.out.format("%d dividido por %d é %.2f", n, d, resultado);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
        }
    }
}