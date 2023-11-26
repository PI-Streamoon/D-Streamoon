package controllers;


import models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioController {
    private List<UsuarioModel> usuarios;
    public static UsuarioModel usuarioLogado;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public Boolean buscarUsuario(String email, String senha){
        UsuarioModel usuarioModel = new UsuarioModel();
        List<UsuarioModel> listaUsers = usuarioModel.buscarUsuario(email);

        Boolean validacao = false;


        if(!listaUsers.isEmpty()){
            for (UsuarioModel usuarios: listaUsers) {
//                if (usuarios.getEmail().equals(email)){

                    if (BCrypt.checkpw(senha, usuarios.getSenha())){
                        validacao = true;
                        usuarioLogado = usuarios;
                    }
//                }
            }
        }

        return validacao;
    }

}
