package sptech.school;

public class Usuario {
    private int id;
    private int empresa;
    private int admin;
    private String nome;
    private String senha;
    private String cpf;
    private String email;

    public Usuario() {}


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", admin=" + admin +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
