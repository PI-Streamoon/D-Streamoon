package sptech.school;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private String email;
    private String senha;
    Conexao conexao;
    JdbcTemplate con;
    List<Usuario>usuarios;

    public Login() {
        this.email = null;
        this.senha = null;
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
    }

    public void menuLogin() {
        System.out.println("""
                @======================================@
                |   Bem vindo de volta!                |
                @--------------------------------------@
                |   1 - Login                          |
                |   2 - Sair                           |
                @======================================@
                """);
    }

    public void menuMonitoramento() {
        System.out.println("""
                @======================================@
                |  Escolha o que deseja monitorar      |
                @--------------------------------------@
                |   1 - CPU                            |
                |   2 - Memória RAM                    |
                |   3 - Disco                          |
                |   4 - Upload                         |
                |   5 - Download                       |
                |   6 - Todos                          |
                |   7 - Iniciar Monitoramento          |
                @======================================@
                """);
    }

    public Usuario entrar() {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o seu e-mail:");
        String email = leitor.nextLine();
        this.email = email;

        System.out.println("Insira a sua senha:");
        String senha = leitor.nextLine();
        this.senha = senha;

        List<Usuario> usuarioBuscado = buscarUsuario(email, senha);

        if (usuarioBuscado.isEmpty()) {

            System.out.println(usuarioBuscado);
            System.out.println("""
                    @--------------------------------------@
                    |   E-mail não cadastrado!             |
                    @--------------------------------------@
                    """);
            return null;

        } else {
            System.out.println(usuarioBuscado.get(0));
            return usuarioBuscado.get(0);
        }
    }

    public List<Usuario> buscarUsuario(String email, String senha){
        this.usuarios = con.query(
                "SELECT * FROM usuario WHERE email = ? AND senha = ?",
                new BeanPropertyRowMapper<>(Usuario.class), email, senha);
        return usuarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

