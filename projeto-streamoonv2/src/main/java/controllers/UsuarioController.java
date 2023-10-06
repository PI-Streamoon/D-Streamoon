package controllers;

import org.springframework.jdbc.core.JdbcTemplate;

import views.Usuario;
import models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import dao.Conexao;


public class UsuarioController {
    private List<UsuarioModel> usuarios;

    public UsuarioController() {
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
    }

    public Boolean buscarUsuario(String email, String senha){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setEmail(email);
        usuarioModel.setEmail(senha);
        List<UsuarioModel> listaUsers = usuarioModel.buscarUsuario(usuarioModel);

        Boolean validacao = false;



        return validacao;
    }

}
