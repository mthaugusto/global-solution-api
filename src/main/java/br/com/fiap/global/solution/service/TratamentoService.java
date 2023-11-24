package br.com.fiap.global.solution.service;

import br.com.fiap.global.solution.beans.Tratamento;
import br.com.fiap.global.solution.data.TratamentoDao;

import java.sql.SQLException;
import java.util.List;

public class TratamentoService {

    private final TratamentoDao dao = new TratamentoDao();

    public List<Tratamento> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Tratamento findById(int id) throws ClassNotFoundException {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
