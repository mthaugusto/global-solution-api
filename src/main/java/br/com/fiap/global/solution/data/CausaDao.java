package br.com.fiap.global.solution.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.global.solution.beans.Causa;

public class CausaDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Causa> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_CAUSAS";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Causa> causaList = new ArrayList<>();

                    while (resultSet.next()) {
                        Causa causa = new Causa(
                                resultSet.getInt("ID_CAUSA"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_CAUSA")
                        );
                        causaList.add(causa);
                    }

                    return causaList;
                }
            }
        }
    }

    public Causa findById(int id) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_CAUSAS WHERE ID_CAUSA = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, id);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Causa causa = null;

                    if (resultSet.next()) {
                        causa = new Causa(
                                resultSet.getInt("ID_CAUSA"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_CAUSA")
                        );
                    }

                    return causa;
                }
            }
        }
    }


    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
