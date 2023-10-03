package models;

public class LoginModel {

    public String exibirUsuario() {
        return "SELECT nome,senha,cpf,email  FROM usuario WHERE email = ? AND senha = ?";
    }
    //
}
