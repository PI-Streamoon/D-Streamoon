package dao;

import controllers.ServidorController;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import models.ServidorModel;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class ServidorDao {
    private JdbcTemplate conMysql, conSQLServer;
    private ConexaoMySQL conexaoMySQL;
    private ConexaoSQLServer conexaoSQLServer;

    public ServidorDao(){
        this.conexaoMySQL = new ConexaoMySQL();
        this.conexaoSQLServer = new ConexaoSQLServer();
        this.conMysql = conexaoMySQL.getConexaoDoBanco();
        this.conSQLServer = conexaoSQLServer.getConexaoDoBanco();
    }

    public List<ServidorModel> pegarServidores(){
        return conMysql.query(
                "SELECT * FROM servidor;",
                new BeanPropertyRowMapper<>(ServidorModel.class));
    }

    public List<ServidorModel> pegarServidoresPorId(int id){
        return conMysql.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
                new BeanPropertyRowMapper<>(ServidorModel.class), id);
    }

    public List<ServidorModel> pegarServidoresPorLocal(int idLocal){
        return conMysql.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
                new BeanPropertyRowMapper<>(ServidorModel.class), idLocal);
    }

    public void cadastrarServidor(Integer fkLocal, String enderecoMAC) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insert = "INSERT INTO servidor (fkLocais, fkOrigem, enderecoMAC) VALUES (?, NULL, ?)";

        conMysql.update(getPreparedStatement(fkLocal, enderecoMAC, insert), keyHolder);
        conSQLServer.update(getPreparedStatement(fkLocal, enderecoMAC, insert), keyHolder);

        ServidorController.FK_SERVIDOR = Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    private static PreparedStatementCreator getPreparedStatement(Integer fkLocal, String enderecoMAC, String insert) {
        return new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // Especifica que a coluna "id" é gerada automaticamente e deve ser retornada
                PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, fkLocal);
                ps.setString(2, enderecoMAC);
                return ps;
            }
        };
    }
}
