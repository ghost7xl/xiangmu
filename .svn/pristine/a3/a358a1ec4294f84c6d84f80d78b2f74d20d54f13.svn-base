package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Province;
import com.shopping.service.impl.AddressServiceImpl;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		JSONObject json = new JSONObject();
		if (method == null) {
			List<Province> pList = new AddressServiceImpl().queryAllProvince();
			json.put("pList", pList);
		} else if (method.equals("city")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			List<City> cityList = new AddressServiceImpl()
					.queryAllCityById(pid);
			json.put("cityList", cityList);
		} else if (method.equals("county")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			List<County> countyList = new AddressServiceImpl()
					.queryAllCountiesById(cid);
			json.put("countyList", countyList);
		}
		pw.write(json.toString());
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
