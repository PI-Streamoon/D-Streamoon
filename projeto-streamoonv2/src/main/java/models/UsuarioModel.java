package models;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private List<views.Usuario> usuarios;

    public UsuarioModel() {
        this.usuarios = new ArrayList<>();
    }

    public String exibirUsuario() {

        return "SELECT nome,senha,cpf,email  FROM usuario WHERE email = ? AND senha = ?;";
    }
}
