package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class LocaisDao {
    private JdbcTemplate conMysql, conSQLServer;
    private ConexaoMySQL conexaoMySQL;
    private ConexaoSQLServer conexaoSQLServer;

    public LocaisDao() {
        this.conexaoMySQL = new ConexaoMySQL();
        this.conexaoSQLServer = new ConexaoSQLServer();
        this.conMysql = conexaoMySQL.getConexaoDoBanco();
        this.conSQLServer = conexaoSQLServer.getConexaoDoBanco();
    }

   public int cadastrarLocal(int fkEmpresa, String cep, String descricao){
       KeyHolder keyHolder = new GeneratedKeyHolder();
       String insert = "INSERT INTO locais (fkEmpresa, cep, descricao) VALUES (?, ?, ?)";

       conMysql.update(getPreparedStatement(fkEmpresa, cep, descricao, insert), keyHolder);
       conSQLServer.update(getPreparedStatement(fkEmpresa, cep, descricao, insert), keyHolder);


       // Recupera o ID gerado
       return Objects.requireNonNull(keyHolder.getKey()).intValue();
   }

    private static PreparedStatementCreator getPreparedStatement(int fkEmpresa, String cep, String descricao, String insert) {
        return new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // Especifica que a coluna "id" é gerada automaticamente e deve ser retornada
                PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, fkEmpresa);
                ps.setString(2, cep);
                ps.setString(3, descricao);
                return ps;
            }
        };
    }
}
