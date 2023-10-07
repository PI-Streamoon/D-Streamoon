package dao;

import models.ComponenteModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ComponenteDao {

    private JdbcTemplate con;
    private Conexao conexao;

    public ComponenteDao() {
        this.con = conexao.getConexaoDoBanco();
        this.conexao = new Conexao();
    }

    public List<ComponenteModel> pegarComponentePorNome(String componente){
        return (con.query(
                "SELECT idComponente FROM componente WHERE nome = '?';",
                new BeanPropertyRowMapper<>(ComponenteModel.class), componente));
    }

    public List<ComponenteModel> pegarTodosComponente(){
        return (con.query(
                "SELECT idComponente FROM componente;",
                new BeanPropertyRowMapper<>(ComponenteModel.class)));
    }

        public List<ComponenteModel> pegarComponenteServidor(int id){
        return (con.query(
                "SELECT * FROM componenteServidor WHERE idComponenteServidor = ?",
                new BeanPropertyRowMapper<>(ComponenteModel.class), id));
    }
}
