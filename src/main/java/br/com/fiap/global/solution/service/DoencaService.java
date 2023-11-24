package br.com.fiap.global.solution.service;

import br.com.fiap.global.solution.data.DoencaDao;
import br.com.fiap.global.solution.beans.Doenca;

import java.sql.SQLException;
import java.util.List;

public class DoencaService {

    private final DoencaDao dao = new DoencaDao();

    public List<Doenca> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Doenca findById(int id) throws ClassNotFoundException {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}