package models;

import dao.ComponenteDao;

import java.util.List;

public class ComponenteModel {
    private String nome;
    private Integer fkMedida;
    private Integer idComponente;
    private ComponenteDao componenteDao;

    public ComponenteModel() {
        componenteDao = new ComponenteDao();
    }

    public ComponenteModel pegarComponentePorNome(String nome){
        ComponenteModel fk = componenteDao.pegarComponentePorNome(nome).get(0);
        return fk;
    }

    public List<ComponenteModel> pegarTodosComponente(){
        return componenteDao.pegarTodosComponente();
    }

    public List<ComponenteModel> pegarComponenteServidor(int id){
        return componenteDao.pegarComponenteServidor(id);
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }
}
