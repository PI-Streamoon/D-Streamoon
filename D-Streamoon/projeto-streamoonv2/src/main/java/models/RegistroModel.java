package models;

import dao.ComponenteDao;
import dao.RegistroDao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroModel {
    private LocalDateTime dataHora;
    private Double registro;
    private Integer fkComponenteServidor;
    private RegistroDao registroDao;
    private ComponenteDao componenteDao;

    public RegistroModel() {
        this.registroDao  = new RegistroDao();
        this.componenteDao = new ComponenteDao();
    }

    public List<RegistroModel> pegarUltimosCemDados(){
        return registroDao.pegarUltimosCemDados();
    }

    public List<RegistroModel> pegarDadosporComponente(String componente){
        return registroDao.pegarDadosporComponente(componente);
    }

    public Integer inserirCPU(Double cpu, Integer fkComponente){
        return registroDao.inserirCPU(cpu, fkComponente);
    }

    public Integer inserirRAM(Double ram,Integer fkComponente) {
        return registroDao.inserirRAM(ram, fkComponente);
    }

    public Integer inserirDisco(Double disco, Integer fkComponente) {
        return registroDao.inserirDisco(disco, fkComponente);
    }

    public Integer inserirUpload(Double upload, Integer fkComponente) {
        return registroDao.inserirUpload(upload, fkComponente);
    }

    public Integer inserirDownload(Double download, ComponenteModel componente) {
        return registroDao.inserirDownload(download, componente.getIdComponente());
    }

    @Override
    public String toString() {
        return "RegistroModel{" +
                "dataHora=" + registroDao.getFormatter() +
                ", registro=" + registro +
                ", registroDao=" + registroDao +
                '}';
    }
}