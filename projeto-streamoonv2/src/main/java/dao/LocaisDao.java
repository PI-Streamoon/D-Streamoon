package dao;

import models.ComponenteModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class LocalDao {
    private JdbcTemplate con;
    private Conexao conexao;

    public LocalDao() {
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

   public int cadastrarLocal(int fkEmpresa, String cep, String descricao){
       String insert = "INSERT INTO locais (fkEmpresa, cep, descricao) VALUES (?, ?, ?)";
       return con.update(insert, fkEmpresa, cep, descricao);
   }
}
