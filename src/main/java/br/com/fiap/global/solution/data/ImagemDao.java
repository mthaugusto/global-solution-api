package br.com.fiap.global.solution.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.global.solution.beans.Imagem;

public class ImagemDao {

    private final String USER = "rm99697";
    private final String PASS = "111294";
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public List<Imagem> findAll() throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_IMAGENS";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    List<Imagem> imagemList = new ArrayList<>();

                    while (resultSet.next()) {
                        Imagem imagem = new Imagem(
                                resultSet.getInt("ID_IMAGEM"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getBytes("IMAGEM")
                        );
                        imagemList.add(imagem);
                    }

                    return imagemList;
                }
            }
        }
    }

    public Imagem findById(int idImagem) throws SQLException, ClassNotFoundException {
        classForName();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM T_IMAGENS WHERE ID_IMAGEM = ?";
            try (PreparedStatement instrucao = con.prepareStatement(sql)) {
                instrucao.setInt(1, idImagem);
                try (ResultSet resultSet = instrucao.executeQuery()) {
                    Imagem imagem = null;

                    if (resultSet.next()) {
                        imagem = new Imagem(
                                resultSet.getInt("ID_IMAGEM"),
                                resultSet.getInt("T_DOENCAS_ID_DOENCA"),
                                resultSet.getBytes("IMAGEM")
                        );
                    }

                    return imagem;
                }
            }
        }
    }

    private void classForName() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
}
