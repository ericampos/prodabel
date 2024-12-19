package br.gov.pbh.prefeitura.cadastroCarros.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.gov.pbh.prefeitura.cadastroCarros.model.Carro;
import br.gov.pbh.prefeitura.cadastroCarros.util.HibernateUtil;

public class CarroDaoImpl implements CarroDao {

	public CarroDaoImpl() {
	}

	@Override
	public void insertCarro(Carro carro) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(carro);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Carro selectCarro(Long id) {
		Transaction transaction = null;
		Carro carro = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			carro = session.get(Carro.class, id);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return carro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> selectAllCarro() {

		Transaction transaction = null;
		List<Carro> carros = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			carros = session.createQuery("from Carro").getResultList();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return carros;
	}

	@Override
	public boolean deleteCarro(Long id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			Carro carro = session.get(Carro.class, id);
			if (carro != null) {
				session.delete(carro);
				System.out.println("Carro excluído");
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateCarro(Carro carro) throws SQLException {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.saveOrUpdate(carro);
			transaction.commit();

		} catch (Exception e) {
		
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
