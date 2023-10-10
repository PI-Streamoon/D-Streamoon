package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.RegistroController;
import controllers.UsuarioController;

public class Login {
    private String email;
    private String senha;
    private Boolean selecionadoCPU;
    private Boolean selecionadoRAM;
    private Boolean selecionadoDisco;
    private Boolean selecionadoUpload;
    private Boolean selecionadoDownload;

    List<Usuario> usuarios;
    UsuarioController usuarioController = new UsuarioController();
    RegistroController registroController = new RegistroController();

    public Login() {
        this.email = null;
        this.senha = null;
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
                   1 - CPU           %s                \s
                   2 - Memória RAM   %s                \s
                   3 - Disco         %s                \s
                   4 - Upload        %s                \s
                   5 - Download      %s                \s
                   6 - Todos                           \s
                   7 - Iniciar Monitoramento           \s
                @======================================@
                """.formatted(selecionadoCPU ? "[selecionado]": "[não selecionado]",
                              selecionadoRAM ? "[selecionado]": "[não selecionado]",
                              selecionadoDisco ? "[selecionado]": "[não selecionado]",
                              selecionadoUpload ? "[selecionado]": "[não selecionado]",
                              selecionadoDownload ? "[selecionado]": "[não selecionado]"
                ));
    }

    public void menuDados(){
        String dados = registroController.getDados(selecionadoCPU, selecionadoRAM, selecionadoDisco, selecionadoUpload, selecionadoDownload);
        System.out.println("""
                @==================================@
                |         Dados Captados da:       |
                @==================================@
                %s
                @==================================@
                """.formatted(dados));
    }

    public void entrar() {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o seu e-mail:");
        String email = leitor.nextLine();
        this.email = email;

        System.out.println("Insira a sua senha:");
        String senha = leitor.nextLine();
        this.senha = senha;

        Boolean isEmpty = usuarioController.buscarUsuario(email, senha);

        if (isEmpty.equals(true)) {

            // System.out.println(usuarioBuscado);
            System.out.println("""
                    @--------------------------------------@
                    |   E-mail não cadastrado!             |
                    @--------------------------------------@
                    """);

        } else {
            System.out.println("O usuário informado não existe no sistema!");
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

    public Boolean getSelecionadoCPU() {
        return selecionadoCPU;
    }

    public Boolean getSelecionadoRAM() {
        return selecionadoRAM;
    }

    public Boolean getSelecionadoDisco() {
        return selecionadoDisco;
    }

    public Boolean getSelecionadoUpload() {
        return selecionadoUpload;
    }

    public Boolean getSelecionadoDownload() {
        return selecionadoDownload;
    }
}