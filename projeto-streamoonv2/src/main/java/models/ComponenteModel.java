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

    public List<ComponenteModel> pegarComponentePorNome(String nome){
        return componenteDao.pegarComponentePorNome(nome);
    }

    public List<ComponenteModel> pegarTodosComponente(){
        return componenteDao.pegarTodosComponente();
    }

    public List<ComponenteModel> pegarComponenteServidor(int id){
        return componenteDao.pegarComponenteServidor(id);
    }

}
