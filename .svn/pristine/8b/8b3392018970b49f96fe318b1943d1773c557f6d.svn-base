package com.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.Cart;
import com.shopping.pojo.CartDetail;
import com.shopping.pojo.Order;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.User;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SubServlet
 */
@WebServlet("/SubServlet")
public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method == null) {
			User user = (User) request.getSession().getAttribute("user");
			int uid = user.getId();
			int cid = us.queryCartId(uid);
			List<Integer> lList = new ArrayList<Integer>();
			int uaid = Integer.parseInt(request.getParameter("address"));
			List<CartDetail> cdList = us.queryGidByCid(cid);
			for (int i = 0; i < cdList.size(); i++) {
				double price = cdList.get(i).getMoney();
				int num = cdList.get(i).getNum();
				int gid = cdList.get(i).getGid();
				double allPrice = price * num;
				Order order = new Order(uid, uaid, price);
				OrderDetail orderDetail = new OrderDetail(0, 0, gid, num,
						allPrice);
				lList.add(us.createOrder(order, orderDetail));
			}
			for (int i = 0; i < lList.size(); i++) {
				if (lList.get(i) < 1) {
					response.sendRedirect("error.jsp");
				}
			}
			Cart cart = us.queryCartByUid(uid);
			cart.setMoney(0);
			int i = us.delAllCartDetail(cid);
			int j = us.editCart(cart);
			response.sendRedirect("CartServlet?method=found");
		} else if ("cleancart".equals(method)) {
			User user = (User) request.getSession().getAttribute("user");
			int uid = user.getId();
			int cid = us.queryCartId(uid);
			Cart cart = us.queryCartByUid(uid);
			cart.setMoney(0);
			int i = us.delAllCartDetail(cid);
			int j = us.editCart(cart);
			if (i > 0 && j > 0) {
				response.sendRedirect("CartServlet?method=found");
			} else {
				response.sendRedirect("error.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
