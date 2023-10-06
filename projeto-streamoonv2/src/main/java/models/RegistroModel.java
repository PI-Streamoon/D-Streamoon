package models;

import dao.RegistroDao;

import java.time.LocalDateTime;
import java.util.List;

public class RegistroModel {
    private LocalDateTime dataHora;
    private Double registro;
    private Integer fkComponenteServidor;

    private RegistroDao registroDao;

    public RegistroModel() {
        this.registroDao  = new RegistroDao();
    }

    public List<RegistroModel> pegarUltimosCemDados(){
        return registroDao.pegarUltimosCemDados();
    }

    public List<RegistroModel> pegarDadosporComponente(String componente){
        return registroDao.pegarDadosporComponente(componente);
    }
}