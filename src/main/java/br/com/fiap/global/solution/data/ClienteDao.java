package br.com.fiap.global.solution.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.global.solution.beans.Cliente;

public class ClienteDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Cliente> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_CLIENTE";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Cliente> clienteList = new ArrayList<>();

                    while (resultSet.next()) {
                        Cliente cliente = new Cliente(
                                resultSet.getInt("ID_CLIENTE"),
                                resultSet.getString("NM_CLIENTE"),
                                resultSet.getString("ML_CLIENTE"),
                                resultSet.getString("NR_CPF"),
                                resultSet.getString("DT_NASCIMENTO"),
                                resultSet.getString("GN_CLIENTE").charAt(0),
                                resultSet.getString("NR_CELULAR"),
                                resultSet.getString("NR_CEP"),
                                resultSet.getString("ST_ALERGIA").charAt(0),
                                resultSet.getString("DS_ALERGIA"),
                                resultSet.getString("ST_MEDICAMENTOS").charAt(0),
                                resultSet.getString("DS_MEDICAMENTOS")
                        );
                        clienteList.add(cliente);
                    }

                    return clienteList;
                }
            }
        }
    }

    public Cliente findById(int id) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_CLIENTE WHERE ID_CLIENTE = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, id);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Cliente cliente = null;

                    if (resultSet.next()) {
                        cliente = new Cliente(
                                resultSet.getInt("ID_CLIENTE"),
                                resultSet.getString("NM_CLIENTE"),
                                resultSet.getString("ML_CLIENTE"),
                                resultSet.getString("NR_CPF"),
                                resultSet.getString("DT_NASCIMENTO"),
                                resultSet.getString("GN_CLIENTE").charAt(0),
                                resultSet.getString("NR_CELULAR"),
                                resultSet.getString("NR_CEP"),
                                resultSet.getString("ST_ALERGIA").charAt(0),
                                resultSet.getString("DS_ALERGIA"),
                                resultSet.getString("ST_MEDICAMENTOS").charAt(0),
                                resultSet.getString("DS_MEDICAMENTOS")
                        );
                    }

                    return cliente;
                }
            }
        }
    }

    public void delete(Cliente cliente) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "DELETE FROM T_CLIENTE WHERE ID_CLIENTE = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, cliente.getIdCliente());
                instrucao.executeUpdate();
            }
        }
    }

    public void create(Cliente cliente) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO T_CLIENTE (NM_CLIENTE, ML_CLIENTE, NR_CPF, DT_NASCIMENTO, GN_CLIENTE, NR_CELULAR, NR_CEP, ST_ALERGIA, DS_ALERGIA, ST_MEDICAMENTOS, DS_MEDICAMENTOS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setString(1, cliente.getNomeCliente());
                instrucao.setString(2, cliente.getEmailCliente());
                instrucao.setString(3, cliente.getCpf());
                instrucao.setString(4, cliente.getDataNascimento().toString());
                instrucao.setString(5, String.valueOf(cliente.getGeneroCliente()));
                instrucao.setString(6, cliente.getNumeroCelular());
                instrucao.setString(7, cliente.getCep());
                instrucao.setString(8, String.valueOf(cliente.getPossuiAlergia()));
                instrucao.setString(9, cliente.getDescricaoAlergia());
                instrucao.setString(10, String.valueOf(cliente.getUtilizaMedicamentos()));
                instrucao.setString(11, cliente.getDescricaoMedicamentos());
                instrucao.executeUpdate();
          
            }
        } 
    } 

    public void update(Cliente cliente) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "UPDATE T_CLIENTE SET NM_CLIENTE=?, ML_CLIENTE=?, NR_CPF=?, DT_NASCIMENTO=?, GN_CLIENTE=?, NR_CELULAR=?, NR_CEP=?, ST_ALERGIA=?, DS_ALERGIA=?, ST_MEDICAMENTOS=?, DS_MEDICAMENTOS=? WHERE ID_CLIENTE=?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setString(1, cliente.getNomeCliente());
                instrucao.setString(2, cliente.getEmailCliente());
                instrucao.setString(3, cliente.getCpf());
                instrucao.setString(4, cliente.getDataNascimento().toString());
                instrucao.setString(5, String.valueOf(cliente.getGeneroCliente()));
                instrucao.setString(6, cliente.getNumeroCelular());
                instrucao.setString(7, cliente.getCep());
                instrucao.setString(8, String.valueOf(cliente.getPossuiAlergia()));
                instrucao.setString(9, cliente.getDescricaoAlergia());
                instrucao.setString(10, String.valueOf(cliente.getUtilizaMedicamentos()));
                instrucao.setString(11, cliente.getDescricaoMedicamentos());
                instrucao.setInt(12, cliente.getIdCliente());
                instrucao.executeUpdate();
            }
        }
    }
    

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
