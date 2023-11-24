package br.com.fiap.global.solution.service;

import br.com.fiap.global.solution.beans.Sintoma;
import br.com.fiap.global.solution.data.SintomaDao;

import java.sql.SQLException;
import java.util.List;

public class SintomaService {

    private final SintomaDao dao = new SintomaDao();

    public List<Sintoma> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sintoma findById(int id) throws ClassNotFoundException {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
