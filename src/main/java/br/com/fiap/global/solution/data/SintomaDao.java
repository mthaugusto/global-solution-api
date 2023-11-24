package br.com.fiap.global.solution.data;

import br.com.fiap.global.solution.beans.Sintoma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SintomaDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Sintoma> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_SINTOMAS";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Sintoma> sintomaList = new ArrayList<>();

                    while (resultSet.next()) {
                        Sintoma sintoma = new Sintoma(
                                resultSet.getInt("ID_SINTOMA"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_SINTOMA")
                        );
                        sintomaList.add(sintoma);
                    }

                    return sintomaList;
                }
            }
        }
    }

    public Sintoma findById(int id) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_SINTOMAS WHERE ID_SINTOMA = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, id);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Sintoma sintoma = null;

                    if (resultSet.next()) {
                        sintoma = new Sintoma(
                                resultSet.getInt("ID_SINTOMA"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_SINTOMA")
                        );
                    }

                    return sintoma;
                }
            }
        }
    }

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
