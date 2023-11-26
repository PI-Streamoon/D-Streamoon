package utils;

import com.github.britooo.looca.api.core.Looca;
import controllers.ServidorController;
import dao.ComponenteDao;
import models.ServidorModel;

import java.util.Objects;
import java.util.Scanner;

public class CheckServer {
    public CheckServer() {
        String enderecoMAC = getMacAddress();
        ServidorModel serverWithMac = getServerInDB(enderecoMAC);

        if (Objects.nonNull(serverWithMac)){
            ServidorController.FK_SERVIDOR = serverWithMac.getIdServidor();
        }else{
            Scanner in = new Scanner(System.in);

            System.out.println("Servidor Não cadastrado!");
            System.out.println("Digite o CEP do Local do Servidor");
            String cep = in.nextLine();
            System.out.println("Digite a Descricão do Local");
            String desc = in.nextLine();

            ServidorController servidorController = new ServidorController();
            servidorController.cadastrarServidor(cep, desc, enderecoMAC);

            System.out.println("Servidor Cadastrado!");
        }
    }

    public void cadastrarServer(){

    }

    public String getMacAddress(){
        Looca looca = new Looca();
        return looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac();
    }

    public ServidorModel getServerInDB(String enderecoMAC){
        ServidorController servidorController = new ServidorController();
        return servidorController.pegarServidorPMac(enderecoMAC);
    }
}
