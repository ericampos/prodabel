package br.gov.pbh.prefeitura.cadastroCarros.dao;

import java.sql.SQLException;
import java.util.List;

import br.gov.pbh.prefeitura.cadastroCarros.model.Carro;

public interface CarroDao {

	void insertCarro(Carro todo) throws SQLException;

	Carro selectCarro(Long id);

	List<Carro> selectAllCarro();

	boolean deleteCarro(Long id) throws SQLException;

	void updateCarro(Carro carro) throws SQLException;

}