package br.com.fiap.global.solution.service;

import br.com.fiap.global.solution.beans.Causa;
import br.com.fiap.global.solution.data.CausaDao;

import java.sql.SQLException;
import java.util.List;

public class CausaService {

    private final CausaDao dao = new CausaDao();

    public List<Causa> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Causa findById(int id) throws ClassNotFoundException {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
