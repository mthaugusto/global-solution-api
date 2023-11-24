package br.com.fiap.global.solution.data;

import br.com.fiap.global.solution.beans.Doenca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoencaDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Doenca> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_DOENCAS";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Doenca> doencaList = new ArrayList<>();

                    while (resultSet.next()) {
                        Doenca doenca = new Doenca(
                                resultSet.getInt("ID_DOENCA"),
                                resultSet.getString("NM_DOENCA"),
                                resultSet.getString("DS_DOENCA")
                        );
                        doencaList.add(doenca);
                    }

                    return doencaList;
                }
            }
        }
    }

    public Doenca findById(int id) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_DOENCAS WHERE ID_DOENCA = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, id);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Doenca doenca = null;

                    if (resultSet.next()) {
                        doenca = new Doenca(
                                resultSet.getInt("ID_DOENCA"),
                                resultSet.getString("NM_DOENCA"),
                                resultSet.getString("DS_DOENCA")
                        );
                    }

                    return doenca;
                }
            }
        }
    }

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
