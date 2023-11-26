package dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoMySQL {
    private JdbcTemplate conexaoDoBanco;
    public ConexaoMySQL() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("streamoon");
        dataSource.setUser("StreamoonUser");
        dataSource.setPassword("Moon2023");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
