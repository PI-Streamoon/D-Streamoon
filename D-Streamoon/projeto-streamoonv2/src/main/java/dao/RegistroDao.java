package dao;

import models.RegistroModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegistroDao {
    private JdbcTemplate con;
    private Conexao conexao = new Conexao();
    private LocalDateTime horario;
    private DateTimeFormatter formatter;
    private Locale local;
    private ComponenteDao componenteDao;

    public RegistroDao(){
        this.con = conexao.getConexaoDoBanco();
        this.horario = LocalDateTime.now();
        this.local = new Locale("pt","BR");
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm",local);
        this.componenteDao = new ComponenteDao();
    }

    public List<RegistroModel> pegarUltimosCemDados(){
        return con.query(
                "SELECT * FROM tabelaRegistros LIMIT 100;",
                new BeanPropertyRowMapper<>(RegistroModel.class));
    }

    public List<RegistroModel> pegarDadosporComponente(String componente){
        return con.query(
                "SELECT * FROM tabelaRegistros WHERE Componente = '?' LIMIT 100;",
                new BeanPropertyRowMapper<>(RegistroModel.class), componente);
    }

    public Integer inserirCPU(Double cpu, Integer fkComponente) {
        String insert = "INSERT INTO registro (registro, dtHora, fkComponenteServidor) VALUES (?, ?, ?)";
        return con.update(insert, cpu, formatter.format(horario), fkComponente);
    }

    public Integer inserirRAM(Double ram, Integer fkComponente) {
        String insert = "INSERT INTO registro (registro, dtHora, fkComponenteServidor) VALUES (?, ?, ?)";
        return con.update(insert, ram, formatter.format(horario), fkComponente);
    }

    public Integer inserirDisco(Double disco, Integer fkComponente) {
        String insert = "INSERT INTO registro (registro, dtHora, fkComponenteServidor) VALUES (?, ?, ?)";
        return con.update(insert, disco, formatter.format(horario), fkComponente);
    }

    public Integer inserirUpload(Double upload, Integer fkComponente) {
        String insert = "INSERT INTO registro (registro, fkComponenteServidor, dtHora) VALUES (?, ?, ?)";
        return con.update(insert, upload, formatter.format(horario), fkComponente);

    }

    public Integer inserirDownload(Double download, Integer fkComponente) {
        String insert = "INSERT INTO registro (registro, dtHora, fkComponenteServidor) VALUES (?, ?, ?)";
        return con.update(insert, download, formatter.format(horario), fkComponente);
    }

    public String getFormatter() {
        return formatter.format(horario);
    }

}
