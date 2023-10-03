package models;

public class RegistroModel {
    public String SelectAllRegistrosFromView() {
        return "SELECT * FROM tabelaRegistros LIMIT 100;";
    }

    public String SelectAllRegistrosOrderByComponente() {
        return "SELECT * FROM tabelaRegistros WHERE Componente = '?' LIMIT 100;";
    }

    public String SelectRegistrosFiltrados(){
        return "SELECT r.idRegistro, r.registro, r.dtHora, c.nome AS nomeComponente, um.nomeMedida\n" +
                "FROM registro r\n" +
                "LEFT JOIN componenteServidor cs ON r.fkComponenteServidor = cs.idComponenteServidor\n" +
                "LEFT JOIN componente c ON cs.fkComponente = c.idComponente\n" +
                "LEFT JOIN unidadeMedida um ON c.fkUnidadeMedida = um.idUnidadeMedida\n" +
                "ORDER BY um.nomeMedida, c.nome;";
    }

    public String SelectAllRegistrosOrderByServidor(){
        return "SELECT * FROM tabelaRegistros WHERE idServidor = ? LIMIT 100;";
    }
}