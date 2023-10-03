package views;

// Necessita de import pois estão em pacotes diferetes

import java.util.Scanner;
import views.Login;

public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        Integer opcaoEscolhida;
        Scanner leitor = new Scanner(System.in);

        do {
            login.menuLogin();
            opcaoEscolhida = leitor.nextInt();

            if (opcaoEscolhida == 1) {
                login.entrar();
                break;
            }

        } while (opcaoEscolhida != 2);

        do {

            login.menuMonitoramento();
            opcaoEscolhida = leitor.nextInt();

            switch (opcaoEscolhida){
                case 1 -> login.selecionarCPU();
                case 2 -> login.selecionarRAM();
                case 3 -> login.selecionarDisco();
                case 4 -> login.selecionarUpload();
                case 5 -> login.selecionarDownload();
                case 6 -> login.selecionarTodos();
            }

        } while(opcaoEscolhida != 7);


    }
}
