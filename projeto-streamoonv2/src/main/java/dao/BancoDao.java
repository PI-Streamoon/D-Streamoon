package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sptech.school.Conexao;

import java.util.List;

public class BancoDao {
    Conexao conexao;
    JdbcTemplate con;


    public BancoDao() {
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

    public Integer emailEncontrado(String email) {
        List<Integer> emailBusca = con.query(
                "SELECT idUsuario FROM usuario WHERE email = ?",
                new BeanPropertyRowMapper<>(Integer.class), email);

        if (emailBusca.isEmpty()) {
            System.out.println("""
                    @--------------------------------------@
                    |   E-mail não cadastrado!             |
                    @--------------------------------------@
                    """);
            return null;
        } else {
            return 1;
        }
    }
}

