package dao;

import models.RegistroModel;
import models.UsuarioModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegistroDao {
    private JdbcTemplate con;
    private Conexao conexao = new Conexao();

    public RegistroDao(){
        this.con = conexao.getConexaoDoBanco();
    }

    public List<RegistroModel> pegarUltimosCemDados(){
        return con.query(
                "SELECT * FROM tabelaRegistros LIMIT 100;",
                new BeanPropertyRowMapper<>(RegistroModel.class));
    }

    public List<RegistroModel> pegarDadosporComponente(String componente){
        return con.query(
                "SELECT * FROM tabelaRegistros WHERE Componente = '?' LIMIT 100;",
                new BeanPropertyRowMapper<>(RegistroModel.class), componente);
    }
}
