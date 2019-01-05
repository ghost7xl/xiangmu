package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.Province;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.service.OrderService;
import com.shopping.service.impl.OrderServiceImpl;
import com.shopping.view.GoodsOrderDetailView;
import com.shopping.view.OrderView;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrderService os = new OrderServiceImpl();
		OrderView ov = os.queryOrderView(id);
		User user = os.queryOrderUser(ov.getUid());
		UserAddress userAddress = os.queryOrderUserAddress(ov.getUaid());
		List<OrderDetail> odList = os.queryAllOrderDetailsById(id);
		List<GoodsOrderDetailView> gList = os.queryAllListGoods(odList);
		Province province = os.queryProvinceById(userAddress.getPid());
		City city = os.queryCityById(userAddress.getCityid());
		County county = os.queryCountyById(userAddress.getCountyid());
		double price = 0;
		for (int i = 0; i < odList.size(); i++) {
			price += odList.get(i).getNum() * odList.get(i).getMoney();
		}
		request.setAttribute("ov", ov);
		request.setAttribute("price", price);
		request.setAttribute("province", province);
		request.setAttribute("city", city);
		request.setAttribute("county", county);
		request.setAttribute("id", id);
		request.setAttribute("user", user);
		request.setAttribute("userAddress", userAddress);
		request.setAttribute("gList", gList);
		request.getRequestDispatcher("admin/orderdetail.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
