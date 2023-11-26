package dao;

import controllers.ServidorController;
import models.ComponenteModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ComponenteDao {

    private JdbcTemplate conMysql, conSQLServer;
    private ConexaoMySQL conexaoMySQL;
    private ConexaoSQLServer conexaoSQLServer;
    private List<ComponenteModel> dadosComponente = new ArrayList<>();


    public ComponenteDao() {
        this.conexaoMySQL = new ConexaoMySQL();
        this.conexaoSQLServer = new ConexaoSQLServer();
        this.conMysql = conexaoMySQL.getConexaoDoBanco();
        this.conSQLServer = conexaoSQLServer.getConexaoDoBanco();
    }

    public List<ComponenteModel> pegarComponentePorNome(String componente){
        dadosComponente = (conMysql.query(
                "SELECT idComponenteServidor FROM componenteServidor JOIN componente ON fkComponente = idComponente " +
                        "WHERE nome = ? AND fkServidor = ? LIMIT 1",
                new BeanPropertyRowMapper<>(ComponenteModel.class), componente, ServidorController.FK_SERVIDOR));

        return dadosComponente;
    }

    public List<ComponenteModel> pegarTodosComponentes(){
        dadosComponente = (conMysql.query(
                "SELECT * FROM componente",
                new BeanPropertyRowMapper<>(ComponenteModel.class)));

        return dadosComponente;
    }

    public void cadastrarComponentesDefault(){
        List<ComponenteModel> todosComponentes = pegarTodosComponentes();

        for (ComponenteModel componenteModel : todosComponentes){
            String insert = "INSERT INTO componenteServidor (fkServidor, fkComponente) VALUES (?, ?)";
            conMysql.update(insert, ServidorController.FK_SERVIDOR, componenteModel.getIdComponente());
            conSQLServer.update(insert, ServidorController.FK_SERVIDOR, componenteModel.getIdComponente());
        }


    }

}
