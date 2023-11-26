package models;

import java.util.List;
import dao.ServidorDao;

public class ServidorModel {
    private Integer idServidor;
    private Integer fkLocal;

    private String enderecoMAC;
    private ServidorDao servidorDao = new ServidorDao();

    public ServidorModel() {
        this.servidorDao = new ServidorDao();
    }

    public List<ServidorModel> pegarServidores(){
        return servidorDao.pegarServidores();
    }

    public List<ServidorModel> pegarServidoresPorId(int id){
        return servidorDao.pegarServidoresPorId(id);
    }

    public void cadastrarServidor(Integer fkLocal, String enderecoMAC){
        servidorDao.cadastrarServidor(fkLocal, enderecoMAC);
    }


    public List<ServidorModel> pegarServidoresPorLocal(int idLocal){
        return servidorDao.pegarServidoresPorId(idLocal);
    }

    public Integer getIdServidor() {
        return idServidor;
    }

    public Integer getFkLocal() {
        return fkLocal;
    }

    public String getEnderecoMAC() {
        return enderecoMAC;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public void setFkLocal(Integer fkLocal) {
        this.fkLocal = fkLocal;
    }

    public void setEnderecoMAC(String enderecoMAC) {
        this.enderecoMAC = enderecoMAC;
    }
}
