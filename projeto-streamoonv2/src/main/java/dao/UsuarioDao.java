package dao;

import models.UsuarioModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private JdbcTemplate con;
    private ConexaoSQLServer conexaoSQLServer = new ConexaoSQLServer();

    private List<UsuarioModel> usuarios;
    public UsuarioDao(){
        this.con = conexaoSQLServer.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
    }

    public List<UsuarioModel> buscarUsuario(String email){

        usuarios = (con.query(
                "SELECT * FROM usuario WHERE email= ?",
                new BeanPropertyRowMapper<>(UsuarioModel.class), email));

        return usuarios;
    }

}
