package models;

public class ComponenteModel {

    public String todosComponentes() {
        return "SELECT * FROM componente;";
    }

    public String componentePorNome(){
        return "SELECT * FROM componente WHERE nome = '?';";
    }

    public String componentePorUnidadeMedida(){
        return "SELECT * FROM componente WHERE fkUnidadeMedida = ?;";
    }
}
