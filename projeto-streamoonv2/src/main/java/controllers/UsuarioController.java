package controllers;

import org.springframework.jdbc.core.JdbcTemplate;

import views.Usuario;
import models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import dao.Conexao;


public class UsuarioController {

    private UsuarioModel usuarioModel;
    private Conexao conexao;
    private JdbcTemplate con;

    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarioModel = new UsuarioModel();
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
    }

    public void buscarUsuario(String email, String senha){
        usuarioModel.buscarUsuario();
    }
}
