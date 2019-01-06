package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.pojo.SysUser;
import com.shopping.service.SysUserService;
import com.shopping.service.impl.SysUserServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		SysUserService sus = new SysUserServiceImpl();
		if ("query".equals(method)) {
			List<SysUser> suList = sus.queryAllSysUsers();
			request.setAttribute("suList", suList);
			request.getRequestDispatcher("admin/adminManage.jsp").forward(
					request, response);
		} else if ("edit".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int flag = Integer.parseInt(request.getParameter("flag"));
			SysUser sysUser = new SysUser(id, username, password, flag);
			int i = sus.editSysUser(sysUser);
			if (i > 0) {
				response.sendRedirect("AdminLoginServlet?method=query");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			int i = sus.delSysUser(id);
			if (i > 0) {
				response.sendRedirect("AdminLoginServlet?method=query");
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
		String adminname = request.getParameter("username");
		String password = request.getParameter("password");
		int i = new SysUserServiceImpl().loginSysUser(adminname, password);
		if (i > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("adminname", adminname);
			request.getRequestDispatcher("admin/admin.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
