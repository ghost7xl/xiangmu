package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.GoodsType;
import com.shopping.service.GoodsTypeManageService;
import com.shopping.service.impl.GoodsTypeManageServiceImpl;

/**
 * Servlet implementation class GoodsTypeServlet
 */
@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String word = request.getParameter("word");
		if (word.equals("a")) {
			GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
			List<GoodsType> gtList = gts.queryAllGoodsType();
			request.setAttribute("gtList", gtList);
			request.getRequestDispatcher("admin/showGoodsType.jsp").forward(
					request, response);
		} else if (word.equals("b")) {
			int typelevel = Integer
					.parseInt(request.getParameter("typelevel1"));
			String typename = request.getParameter("typename1");
			/*
			 * System.out.println(typelevel); System.out.println(typename);
			 */
			if ((typelevel > 0) && (typename != "") && (typename != null)) {
				/* System.out.println("走1"); */
				GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
				List<GoodsType> gtList = gts.queryGoodsTypeByLN(typelevel,
						typename);
				request.setAttribute("gtList", gtList);
				request.getRequestDispatcher("admin/showGoodsType.jsp")
						.forward(request, response);
			} else if ((typelevel == 0) && (typename != null)) {
				// 根据类型名查找
				/* System.out.println("走2"); */
				GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
				List<GoodsType> gtList = gts.queryGoodsTypeByName(typename);
				request.setAttribute("gtList", gtList);
				request.getRequestDispatcher("admin/showGoodsType.jsp")
						.forward(request, response);
			} else if ((typelevel > 0) && ("".equals(typename))) {
				// 根据类型水平查找
				// 空字符传比较不能用(typename.equals(""))
				// 用"".equals(typename)
				/* System.out.println("走3"); */
				GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
				List<GoodsType> gtList = gts.queryGoodsTypeByLevel(typelevel);
				System.out.println(gtList);
				request.setAttribute("gtList", gtList);
				request.getRequestDispatcher("admin/showGoodsType.jsp")
						.forward(request, response);
			}
		} else if (word.equals("c")) {
			// 跳入修改界面
			int id = Integer.parseInt(request.getParameter("typeid"));
			/* System.out.println(id); */
			GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
			GoodsType gt = gts.queryGoodsTypeById(id);
			System.out.println(gt);
			request.setAttribute("gts", gt);
			request.getRequestDispatcher("admin/editGoodsType.jsp").forward(
					request, response);

		} else if (word.equals("d")) {
			// 修改商品类别信息
			int id = Integer.parseInt(request.getParameter("typeid"));
			String name = request.getParameter("typename");
			int level = Integer.parseInt(request.getParameter("typelevel"));
			int parentid = Integer.parseInt(request
					.getParameter("typeparentid"));
			/* System.out.println(level); */
			GoodsType gt = new GoodsType();
			gt.setId(id);
			gt.setName(name);
			gt.setLevel(level);
			gt.setParentid(parentid);
			GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
			int i = gts.editGoodsType(gt);
			/* System.out.println(i); */
			response.sendRedirect("GoodsTypeServlet?word=a");
		} else if (word.equals("e")) {
			// 删除商品类别
			int id = Integer.parseInt(request.getParameter("typeid"));
			GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
			int i = gts.delGoodsTypeAndGood(id);
			response.sendRedirect("GoodsTypeServlet?word=a");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加功能
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int level = Integer.parseInt(request.getParameter("level"));
		int parentid = Integer.parseInt(request.getParameter("parentid"));
		GoodsType gt = new GoodsType();
		gt.setName(name);
		gt.setLevel(level);
		gt.setParentid(parentid);
		GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
		int i = gts.addGoodsType(gt);
		response.setContentType("text/jsp;charset=utf-8");
		response.sendRedirect("GoodsTypeServlet?word=a");
	}

}
