package br.com.fiap.global.solution.data;

import br.com.fiap.global.solution.beans.Tratamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TratamentoDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Tratamento> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_TRATAMENTOS";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Tratamento> tratamentoList = new ArrayList<>();

                    while (resultSet.next()) {
                        Tratamento tratamento = new Tratamento(
                                resultSet.getInt("ID_TRATAMENTO"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_TRATAMENTO")
                        );
                        tratamentoList.add(tratamento);
                    }

                    return tratamentoList;
                }
            }
        }
    }

    public Tratamento findById(int id) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_TRATAMENTOS WHERE ID_TRATAMENTO = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, id);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Tratamento tratamento = null;

                    if (resultSet.next()) {
                        tratamento = new Tratamento(
                                resultSet.getInt("ID_TRATAMENTO"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getString("DS_TRATAMENTO")
                        );
                    }

                    return tratamento;
                }
            }
        }
    }

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
