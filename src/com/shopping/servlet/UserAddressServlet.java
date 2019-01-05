package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Province;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.service.AddressService;
import com.shopping.service.UserService;
import com.shopping.service.impl.AddressServiceImpl;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserAddressServlet
 */
@WebServlet("/UserAddressServlet")
public class UserAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userAddress = new UserServiceImpl();
	private static AddressService as = new AddressServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddressServlet() {
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
			List<UserAddress> userAdList = userAddress
					.queryAllUserAddressById(uid);
			request.setAttribute("userAdList", userAdList);
			request.getRequestDispatcher("self_info.jsp").forward(request,
					response);
		} else if (method.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int i = userAddress.delAddress(id);
			if (i > 0) {
				response.sendRedirect("UserAddressServlet");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if (method.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String detail = request.getParameter("detail");
			int pid = Integer.parseInt(request.getParameter("pid"));
			int cityid = Integer.parseInt(request.getParameter("cityid"));
			int countyid = Integer.parseInt(request.getParameter("countyid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			int flag = Integer.parseInt(request.getParameter("flag"));
			UserAddress uad = new UserAddress();
			uad.setName(name);
			uad.setId(id);
			uad.setPhone(phone);
			uad.setDetail(detail);
			uad.setCityid(cityid);
			uad.setCountyid(countyid);
			uad.setUid(uid);
			uad.setPid(pid);
			uad.setFlag(flag);
			int i = userAddress.editAddress(uad);
			if (i > 0) {
				response.sendRedirect("UserAddressServlet");
			} else {
				response.sendRedirect("error.jsp");
			}

		} else if (method.equals("add")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String county = request.getParameter("county");
			String detail = request.getParameter("detail");
			UserAddress ud = new UserAddress();
			ud.setName(name);
			ud.setPhone(phone);
			ud.setUid(uid);
			Province pro = null;
			City city2 = null;
			County county2 = null;
			if (province != null) {
				ud.setPid(Integer.parseInt(province));
				pro = as.queryProvinceById(Integer.parseInt(province));
			} else {
				ud.setPid(0);
				pro = new Province();
			}
			if (city != null) {
				ud.setCityid(Integer.parseInt(city));
				city2 = as.queryCityById(Integer.parseInt(city));
			} else {
				ud.setCityid(0);
				city2 = new City();
			}
			if (county != null) {
				ud.setCountyid(Integer.parseInt(county));
				county2 = as.queryCountiesById(Integer.parseInt(county));
			} else {
				ud.setCountyid(0);
				county2 = new County();
			}
			String detailString = pro.getName() + "-" + city2.getName() + "-"
					+ county2.getName() + "-" + detail;
			System.out.println(detailString);
			ud.setDetail(detailString);
			int i = userAddress.addAddress(ud);
			if (i > 0) {
				response.sendRedirect("UserAddressServlet");
			} else {
				response.sendRedirect("error.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
