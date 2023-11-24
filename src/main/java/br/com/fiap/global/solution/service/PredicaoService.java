package br.com.fiap.global.solution.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.global.solution.data.PredicaoDao;
import br.com.fiap.global.solution.beans.Predicao;

public class PredicaoService {

    private final PredicaoDao dao = new PredicaoDao();

    public List<Predicao> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Predicao findById(int idPredicao) throws ClassNotFoundException {
        try {
            return dao.findById(idPredicao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
