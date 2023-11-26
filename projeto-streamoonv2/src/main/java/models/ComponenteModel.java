package models;

import dao.ComponenteDao;

import java.util.List;

public class ComponenteModel {

    private Integer idComponenteServidor;
    private Integer fkServidor;
    private String nome;
    private Integer fkUnidadeMedida;
    private Integer idComponente;
    private ComponenteDao componenteDao;

    public ComponenteModel() {
        componenteDao = new ComponenteDao();
    }

    public List<ComponenteModel> pegarComponentePorNome(String nome){
        return componenteDao.pegarComponentePorNome(nome);
    }

    public Integer getIdComponenteServidor() {
        return idComponenteServidor;
    }

    public void setIdComponenteServidor(Integer idComponenteServidor) {
        this.idComponenteServidor = idComponenteServidor;
    }


    public Integer getFkServidor() {
        return fkServidor;
    }

    public void setFkServidor(Integer fkServidor) {
        this.fkServidor = fkServidor;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }
    @Override
    public String toString() {
        return "ComponenteModel{" +
                "idComponenteServidor=" + idComponenteServidor +
                '}';
    }
}
