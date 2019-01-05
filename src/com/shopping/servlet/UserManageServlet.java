package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.pojo.User;
import com.shopping.service.UserManageService;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserManageServiceImpl;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManageService ums = new UserManageServiceImpl();
	private UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManageServlet() {
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
			List<User> uList = ums.queryAllUser();
			request.setAttribute("uList", uList);
			request.getRequestDispatcher("admin/userList.jsp").forward(request,
					response);
		} else if ("queryone".equals(method)) {
			int id = ((User) request.getSession().getAttribute("user")).getId();
			User user = us.showUser(id);
			System.out.println(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("userList.jsp").forward(request,
					response);

		} else if ("editone".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			int i = us.editUser(id, email, username, gender, password);
			if (i > 0) {
				User user = us.showUser(id);
				HttpSession session =request.getSession();
				session.setAttribute("user",user);
				response.sendRedirect("UserManageServlet?method=queryone");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			int i = ums.delUser(id);
			if (i > 0) {
				response.sendRedirect("UserManageServlet?method=query");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if ("edit".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			int flag = Integer.parseInt(request.getParameter("flag"));
			int i = ums.editUser(id, email, username, gender, flag);
			if (i > 0) {
				response.sendRedirect("UserManageServlet?method=query");
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
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		List<User> uList = ums.queryUsers(username, gender);
		request.setAttribute("uList", uList);
		request.getRequestDispatcher("admin/userList.jsp").forward(request,
				response);
	}
}
