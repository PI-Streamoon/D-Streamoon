package controllers;

import models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<UsuarioModel> usuarios;

    public UsuarioController() {
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
