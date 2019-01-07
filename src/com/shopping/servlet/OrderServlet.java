package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.User;
import com.shopping.service.OrderService;
import com.shopping.service.UserService;
import com.shopping.service.impl.OrderServiceImpl;
import com.shopping.service.impl.UserServiceImpl;
import com.shopping.view.OrderView;
import com.shopping.view.UserOrderPojo;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os = new OrderServiceImpl();
	private UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("query".equals(method)) {
			List<OrderView> oList = os.queryAllOrder();
			request.setAttribute("oList", oList);
			request.getRequestDispatcher("admin/showAllOrder.jsp").forward(
					request, response);
		} else if ("queryone".equals(method)) {
			int id = ((User) request.getSession().getAttribute("user")).getId();
			UserOrderPojo userOrderPojo = us.queryAllOrderViewByUid(id);
			request.setAttribute("userOrderPojo", userOrderPojo);
			request.getRequestDispatcher("orderdetail.jsp").forward(request,
					response);
		} else if ("edit".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			int flag = Integer.parseInt(request.getParameter("flag"));
			int i = os.editOrder(id, flag);
			if (i > 0) {
				List<OrderView> oList = os.queryAllOrder();
				request.setAttribute("oList", oList);
				request.getRequestDispatcher("admin/showAllOrder.jsp").forward(
						request, response);
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
		String name = request.getParameter("username");
		String flag = request.getParameter("flag");
		System.out.println(flag);
		// String flag1=ArrayUtils.toString(flag);
		List<OrderView> oList = os.queryOrder(name, flag);
		request.setAttribute("oList", oList);
		request.getRequestDispatcher("admin/showAllOrder.jsp").forward(request,
				response);
	}

}
