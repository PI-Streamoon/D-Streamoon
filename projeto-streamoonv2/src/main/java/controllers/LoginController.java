package controllers;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import views.Usuario;
import models.LoginModel;
import java.util.ArrayList;
import java.util.List;
import dao.Conexao;

public class LoginController {

    private LoginModel loginModel;
    private Conexao conexao;
    private JdbcTemplate con;

    private List<Usuario> usuarios;

    public LoginController() {
        this.loginModel = new LoginModel();
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList();
    }

    public List<Usuario> buscarUsuario(String email, String senha){
        this.usuarios = con.query(
                loginModel.exibirUsuario(),
                new BeanPropertyRowMapper<>(Usuario.class), email, senha);

        return usuarios;
    }

}
