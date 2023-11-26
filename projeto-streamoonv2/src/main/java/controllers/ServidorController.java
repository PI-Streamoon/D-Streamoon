package controllers;

import dao.ComponenteDao;
import dao.LocaisDao;
import models.ServidorModel;

import java.util.List;

public class ServidorController {

    public static Integer FK_SERVIDOR;


    public List<ServidorModel> pegarServidores(){
        ServidorModel servidorModel = new ServidorModel();
        return servidorModel.pegarServidores();
    }

    public ServidorModel pegarServidorPMac(String MAC){
        List<ServidorModel> servidoresBD = pegarServidores();

        for (ServidorModel servidorModel: servidoresBD){
            if (MAC.equalsIgnoreCase(servidorModel.getEnderecoMAC())) return servidorModel;
        }

        return null;
    }

    public void cadastrarServidor(String cep, String descricao, String enderecoMAC){
        LocaisDao locaisDao = new LocaisDao();
        int fkLocal = locaisDao.cadastrarLocal(UsuarioController.usuarioLogado.getFkEmpresa(), cep, descricao);
        ServidorModel servidorModel = new ServidorModel();
        servidorModel.cadastrarServidor(fkLocal, enderecoMAC);
        ComponenteDao componenteDao = new ComponenteDao();
        componenteDao.cadastrarComponentesDefault();
    }
}
