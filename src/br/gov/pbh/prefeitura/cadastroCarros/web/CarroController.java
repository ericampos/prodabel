package br.gov.pbh.prefeitura.cadastroCarros.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.pbh.prefeitura.cadastroCarros.dao.CarroDao;
import br.gov.pbh.prefeitura.cadastroCarros.dao.CarroDaoImpl;
import br.gov.pbh.prefeitura.cadastroCarros.model.Carro;

/**
 * 
 * @email Eric de Oliveira Campos
 */

@WebServlet("/")
public class CarroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroDao carroDAO;

	public void init() {
		carroDAO = new CarroDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCarro(request, response);
				break;
			case "/delete":
				deleteCarro(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCarro(request, response);
				break;
			default:
				listCarro(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCarro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Carro> listCarro = carroDAO.selectAllCarro();
		request.setAttribute("listCarro", listCarro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("carros/listaCarros.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("carros/formularioCarros.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Carro existingCarro = carroDAO.selectCarro(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("carros/formularioCarros.jsp");
		request.setAttribute("carro", existingCarro);
		dispatcher.forward(request, response);
	}

	private void insertCarro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String placa = request.getParameter("placa");
		LocalDate fabricacao = LocalDate.parse(request.getParameter("fabricacao"));
		Carro newCarro = new Carro(modelo, marca, placa, fabricacao);
		carroDAO.insertCarro(newCarro);
		response.sendRedirect("list");
	}

	private void updateCarro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String placa = request.getParameter("placa");
		LocalDate fabricacao = LocalDate.parse(request.getParameter("fabricacao"));

		Carro updateCarro = new Carro(id, modelo, marca, placa, fabricacao);

		carroDAO.updateCarro(updateCarro);

		response.sendRedirect("list");
	}

	private void deleteCarro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		carroDAO.deleteCarro(id);
		response.sendRedirect("list");
	}
}
