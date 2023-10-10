package dao;

import models.ComponenteModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ComponenteDao {

    private JdbcTemplate con;
    private Conexao conexao;
    private List<ComponenteModel> dadosComponente = new ArrayList<>();

    public ComponenteDao() {
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

    public List<ComponenteModel> pegarComponentePorNome(String componente){
        dadosComponente = (con.query(
                "SELECT idComponenteServidor FROM componenteservidor JOIN " +
                        "componente ON fkComponente = idComponente WHERE nome = '"+componente+"' LIMIT 1",
                new BeanPropertyRowMapper<>(ComponenteModel.class)));

        return dadosComponente;
    }

    public List<ComponenteModel> pegarTodosComponente(){
        return (con.query(
                "SELECT idComponente FROM componente",
                new BeanPropertyRowMapper<>(ComponenteModel.class)));
    }

        public List<ComponenteModel> pegarComponenteServidor(int id){
        return (con.query(
                "SELECT * FROM componenteServidor WHERE idComponenteServidor = ?",
                new BeanPropertyRowMapper<>(ComponenteModel.class), id));
    }
}
