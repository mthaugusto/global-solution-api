package br.com.fiap.global.solution.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.global.solution.beans.Predicao;

public class PredicaoDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Predicao> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_PREDICOES";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Predicao> predicaoList = new ArrayList<>();

                    while (resultSet.next()) {
                        Predicao predicao = new Predicao(
                                resultSet.getInt("ID_PREDICAO"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getInt("T_CLIENTE_ID_CLIENTE"),
                                resultSet.getTimestamp("DT_CLASSIFICACAO").toLocalDateTime(),
                                resultSet.getString("DS_PREDICAO")
                        );
                        predicaoList.add(predicao);
                    }

                    return predicaoList;
                }
            }
        }
    }

    public Predicao findById(int idPredicao) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_PREDICOES WHERE ID_PREDICAO = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, idPredicao);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Predicao predicao = null;

                    if (resultSet.next()) {
                        predicao = new Predicao(
                                resultSet.getInt("ID_PREDICAO"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getInt("T_CLIENTE_ID_CLIENTE"),
                                resultSet.getTimestamp("DT_CLASSIFICACAO").toLocalDateTime(),
                                resultSet.getString("DS_PREDICAO")
                        );
                    }

                    return predicao;
                }
            }
        }
    }

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
