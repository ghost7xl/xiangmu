package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.service.GoodsService;
import com.shopping.service.impl.GoodsServiceImpl;
import com.shopping.view.GoodsView;

/**
 * Servlet implementation class FGoodsServlet
 */
@WebServlet("/FGoodsServlet")
public class FGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService g = new GoodsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		if(method==null){
			int id = Integer.parseInt(request.getParameter("id"));
			GoodsView goods = g.queryGoods(id);
			session.setAttribute("goods", goods);
			request.getRequestDispatcher("goodsDetail.jsp").forward(request, response);
		}else {
//			method =new String(method.getBytes("ISO8859-1"), "UTF-8");
			if(method.equals("搜索")){
				String name = request.getParameter("name");
//				name =new String(name.getBytes("ISO8859-1"), "UTF-8");
				List<GoodsView> l = g.queryGoodsByName(name, name);
			    session.setAttribute("l", l);
			    request.getRequestDispatcher("goodsList.jsp").forward(request, response);
			}else {
				List<GoodsView> l = g.queryGoodsByName(method, method);
				System.out.println(l);
			      session.setAttribute("l", l);
			      request.getRequestDispatcher("goodsList.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
