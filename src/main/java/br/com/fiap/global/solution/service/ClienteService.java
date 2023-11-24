package br.com.fiap.global.solution.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import br.com.fiap.global.solution.data.ClienteDao;
import br.com.fiap.global.solution.beans.Cliente;

public class ClienteService {

	private final ClienteDao dao = new ClienteDao();

	public List<Cliente> findAll() throws ClassNotFoundException {
		try {
			return dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cliente findById(int id) throws ClassNotFoundException {
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Cliente cliente) throws ClassNotFoundException {
		try {
			dao.delete(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Cliente cliente) throws ClassNotFoundException {
		if (!validate(cliente))
			return false;
		try {
			dao.create(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Cliente cliente) throws ClassNotFoundException {
		if (!validate(cliente))
			return false;
		try {
			dao.update(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	private boolean validate(Cliente cliente) {
		return cliente.getNomeCliente() != null && !cliente.getNomeCliente().isEmpty() &&
                cliente.getEmailCliente() != null && !cliente.getEmailCliente().isEmpty() &&
                cliente.getCpf() != null && !cliente.getCpf().isEmpty() &&
                cliente.getDataNascimento() != null &&
                cliente.getNumeroCelular() != null && !cliente.getNumeroCelular().isEmpty() &&
                cliente.getCep() != null && !cliente.getCep().isEmpty() &&
                (cliente.getPossuiAlergia() == 'S' || cliente.getPossuiAlergia() == 'N') &&
                (cliente.getUtilizaMedicamentos() == 'S' || cliente.getUtilizaMedicamentos() == 'N') &&
        		(cliente.getGeneroCliente() == 'M' || cliente.getGeneroCliente() =='F');
	}
}
