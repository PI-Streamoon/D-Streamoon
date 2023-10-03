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
            Boolean selecionadoCPU = false;
            Boolean selecionadoRAM = false;
            Boolean selecionadoDisco = false;
            Boolean selecionadoUpload = false;
            Boolean selecionadoDownload = false;
            login.menuMonitoramento(selecionadoCPU, selecionadoRAM, selecionadoDisco, selecionadoUpload, selecionadoDownload);
            opcaoEscolhida = leitor.nextInt();

            switch (opcaoEscolhida){
                case 1 -> selecionadoCPU = !selecionadoCPU;
                case 2 -> selecionadoRAM = !selecionadoRAM;
                case 3 -> selecionadoDisco = !selecionadoDisco;
                case 4 -> selecionadoUpload = !selecionadoUpload;
                case 5 -> selecionadoDownload = !selecionadoDownload;
                case 6 -> selecionadoCPU = !selecionadoCPU;
            }
        } while(opcaoEscolhida != 7);


    }
}
