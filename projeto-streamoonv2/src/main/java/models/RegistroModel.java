package models;

import java.util.List;

public class RegistroModel {
    public String SelectAllRegistrosFromView() {
        return "SELECT * FROM tabelaRegistros LIMIT 100;";
    }

    public String SelectAllRegistrosOrderByComponente() {
        return "SELECT * FROM tabelaRegistros WHERE Componente = '?' LIMIT 100";
    }
}