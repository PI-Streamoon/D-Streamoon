package dao;

import models.UsuarioModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsuarioDao {
    private JdbcTemplate con;
    private Conexao conexao = new Conexao();

    public UsuarioDao(){
        this.con = conexao.getConexaoDoBanco();
    }
    public List<UsuarioModel> buscarUsuario(UsuarioModel usuarioModel){
        String email = usuarioModel.getEmail();
        String senha = usuarioModel.getSenha();


        con.query(
                "SELECT nome,senha,cpf,email  FROM usuario WHERE email = ? AND senha = ?;",
                new BeanPropertyRowMapper<>(UsuarioModel.class), email, senha).toString();

        return null;
    }
}
