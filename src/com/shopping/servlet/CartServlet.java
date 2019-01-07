package com.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.impl.CartDaoImpl;
import com.shopping.pojo.Cart;
import com.shopping.pojo.CartDetail;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;
import com.shopping.view.CartViewPojo;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
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
			int gid = Integer.parseInt(request.getParameter("gid"));
			int num = 1;
			double money = Double.parseDouble(request.getParameter("money"));
			try {
				CartDetail cartDetail = us.querCartDetailByCidAndGid(cid, gid);
				if (cartDetail != null) {
					num = cartDetail.getNum() + 1;
					
					us.editCartnum(cartDetail.getId(), num);
					Cart cart = new CartDaoImpl().queryCartById(cartDetail.getCid());
					money +=(double)cart.getMoney();
					System.out.println("money.."+money);
					cart.setMoney(money);
					new CartDaoImpl().editCart(cart);
					response.sendRedirect("cartSuccess.jsp");
				}else {
					us.addNewCart(new CartDetail(0, cid, gid, num, money));
					response.sendRedirect("cartSuccess.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect("error.jsp");
			}
		} else if ("found".equals(method)) {
			User user = (User) request.getSession().getAttribute("user");
			int uid = user.getId();
			int cid = us.queryCartId(uid);
			CartViewPojo cvp = null;
			List<CartViewPojo> cList = new ArrayList<CartViewPojo>();
			List<CartDetail> cdList = us.queryGidByCid(cid);
			for (int i = 0; i < cdList.size(); i++) {
				int id = cdList.get(i).getId();
				String name = us.queryGoodsById(cdList.get(i).getGid())
						.getName();
				double price = cdList.get(i).getMoney();
				int num = cdList.get(i).getNum();
				double allPrice = price * num;
				cvp = new CartViewPojo(id, name, price, num, allPrice);
				cList.add(cvp);
			}
			double money = us.queryCartByUid(uid).getMoney();
			List<UserAddress> uaList = us.queryAllUserAddressByUid(uid);
			request.setAttribute("uaList", uaList);
			request.setAttribute("cList", cList);
			request.setAttribute("money", money);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			double price = Double.parseDouble(request.getParameter("price"));
			CartDetail cartDetail = us.queryCartDetail(id);
			Cart cart = us.queryCart(cartDetail.getCid());
			cart.setMoney(cart.getMoney() - price);
			int i = us.delCartDetail(id);
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
