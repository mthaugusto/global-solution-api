package br.com.fiap.global.solution.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.global.solution.data.ImagemDao;
import br.com.fiap.global.solution.beans.Imagem;

public class ImagemService {

    private final ImagemDao dao = new ImagemDao();

    public List<Imagem> findAll() throws ClassNotFoundException {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Imagem findById(int idImagem) throws ClassNotFoundException {
        try {
            return dao.findById(idImagem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
