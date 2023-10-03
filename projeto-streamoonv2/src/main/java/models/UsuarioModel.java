package models;

import views.Usuario;

import javax.swing.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private List<views.Usuario> usuarios;

    public UsuarioModel() {
        this.usuarios = new ArrayList<>();
    }

    public String exibirUsuario() {

        return "SELECT nome,senha,cpf,email  FROM usuario WHERE email = ? AND senha = ?";
    }



}
