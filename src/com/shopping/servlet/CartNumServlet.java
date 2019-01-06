package com.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.Cart;
import com.shopping.pojo.CartDetail;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CartNumServlet
 */
@WebServlet("/CartNumServlet")
public class CartNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartNumServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		if ("+".equals(action)) {
			CartDetail cartDetail = us.queryCartDetail(id);
			Cart cart = us.queryCart(cartDetail.getCid());
			cart.setMoney(cart.getMoney() + cartDetail.getMoney());
			int i = us.editCartnum(id, cartDetail.getNum() + 1);
			int j = us.editCart(cart);
			if (i > 0 && j > 0) {
				response.sendRedirect("CartServlet?method=found");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if ("-".equals(action)) {
			CartDetail cartDetail = us.queryCartDetail(id);
			Cart cart = us.queryCart(cartDetail.getCid());
			cart.setMoney(cart.getMoney() - cartDetail.getMoney());
			int i = us.editCartnum(id, cartDetail.getNum() - 1);
			int j = us.editCart(cart);
			if (i > 0 && j > 0) {
				response.sendRedirect("CartServlet?method=found");
			} else {
				response.sendRedirect("error.jsp");
			}
		}

	}
}
