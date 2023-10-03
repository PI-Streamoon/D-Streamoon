package sptech.school;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private JdbcTemplate conexaoDoBanco;
    public Conexao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("streamoon");
        dataSource.setUser("root");
        dataSource.setPassword("Kevyn@9566784062@");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
