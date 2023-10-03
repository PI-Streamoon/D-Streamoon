package views;

import org.springframework.jdbc.core.JdbcTemplate;
import dao.Conexao;
import views.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controllers.UsuarioController;

public class Login {
    private String email;
    private String senha;
    private Boolean selecionadoCPU;
    private Boolean selecionadoRAM;
    private Boolean selecionadoDisco;
    private Boolean selecionadoUpload;
    private Boolean selecionadoDownload;

    Conexao conexao;
    JdbcTemplate con;
    List<Usuario> usuarios;
    UsuarioController usuarioController = new UsuarioController();

    public Login() {
        this.email = null;
        this.senha = null;
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
        this.selecionadoCPU = false;
        this.selecionadoRAM = false;
        this.selecionadoDisco = false;
        this.selecionadoUpload = false;
        this.selecionadoDownload = false;
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
                @======================================@\s
                |  Escolha o que deseja monitorar      |
                @--------------------------------------@
                   1 - CPU       %s                     \s
                   2 - Memória RAM    %s                \s
                   3 - Disco      %s                    \s
                   4 - Upload     %s                    \s
                   5 - Download   %s                    \s
                   6 - Todos                            \s
                   7 - Iniciar Monitoramento            \s
                @======================================@
                """.formatted(selecionadoCPU ? "[selecionado]": "[não selecionado]",
                              selecionadoRAM ? "[selecionado]": "[não selecionado]",
                              selecionadoDisco ? "[selecionado]": "[não selecionado]",
                              selecionadoUpload ? "[selecionado]": "[não selecionado]",
                              selecionadoDownload ? "[selecionado]": "[não selecionado]"
                ));
    }

    public views.Usuario entrar() {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o seu e-mail:");
        String email = leitor.nextLine();
        this.email = email;

        System.out.println("Insira a sua senha:");
        String senha = leitor.nextLine();
        this.senha = senha;

        List<views.Usuario> usuarioBuscado = usuarioController.buscarUsuario(email, senha);

        if (usuarioBuscado.isEmpty()) {

            System.out.println(usuarioBuscado);
            System.out.println("""
                    @--------------------------------------@
                    |   E-mail não cadastrado!             |
                    @--------------------------------------@
                    """);
            return null;

        } else {
            System.out.println(usuarioBuscado);
            return usuarioBuscado.get(0);
        }
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

    public void selecionarCPU(){
        this.selecionadoCPU = !selecionadoCPU;
    }

    public void selecionarRAM(){
        this.selecionadoRAM = !selecionadoRAM;
    }

    public void selecionarDisco(){
        this.selecionadoDisco = !selecionadoDisco;
    }

    public void selecionarUpload(){
        this.selecionadoUpload = !selecionadoUpload;
    }

    public void selecionarDownload(){
        this.selecionadoDownload = !selecionadoDownload;
    }

    public void selecionarTodos(){
        this.selecionadoCPU = true;
        this.selecionadoRAM = true;
        this.selecionadoDisco = true;
        this.selecionadoUpload = true;
        this.selecionadoDownload = true;
    }

}
