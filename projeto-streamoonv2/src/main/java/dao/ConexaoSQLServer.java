package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoSQLServer {
    private JdbcTemplate conexaoDoBanco;
    public ConexaoSQLServer() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setTrustServerCertificate(true);
        dataSource.setDatabaseName("streamoon");
        dataSource.setUser("StreamoonUser");
        dataSource.setPassword("Moon2023");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
