package com.shopping.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopping.pojo.Goods;
import com.shopping.pojo.GoodsType;
import com.shopping.service.GoodsManageService;
import com.shopping.service.GoodsTypeManageService;
import com.shopping.service.impl.GoodsManageServiceImpl;
import com.shopping.service.impl.GoodsTypeManageServiceImpl;
import com.shopping.view.GoodsView;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet() {
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
		if (word == null) {
			// 1.获取数据
			// 不需要获取数据
			// 2.调用service操作数据库
			GoodsTypeManageService gts = new GoodsTypeManageServiceImpl();
			List<GoodsType> gtList = gts.queryAllGoodsType();
			/* System.out.println(gtList); */
			// 3.返回响应,返回json数据
			response.setContentType("text/html;charset=utf-8");
			JSONObject obj = new JSONObject();
			obj.element("gtList", gtList);

			PrintWriter pw = response.getWriter();
			pw.write(obj.toString());
			pw.flush();
			pw.close();
		} else if (word.equals("b")) {
			GoodsManageService gms = new GoodsManageServiceImpl();
			List<GoodsView> goodsList = gms.queryAllGoods();
			/* System.out.println(goodsList); */
			request.setAttribute("goodsList", goodsList);
			request.getRequestDispatcher("admin/showGoods.jsp").forward(
					request, response);
		} else if (word.equals("c")) {
			// 跳入修改界面
			int id = Integer.parseInt(request.getParameter("goodsid"));
			/* System.out.println(id); */
			GoodsManageService gms = new GoodsManageServiceImpl();
			GoodsView gv = gms.queryAllGoods(id);
			request.setAttribute("gvs", gv);
			request.getRequestDispatcher("admin/editGoods.jsp").forward(
					request, response);
		} else if (word.equals("d")) {
			// 修改商品信息
			int id = Integer.parseInt(request.getParameter("goodsid"));
			String name = request.getParameter("goodsname");
			Double price = Double.parseDouble(request
					.getParameter("goodsprice"));
			int tid = Integer.parseInt(request.getParameter("typeid"));
			String intro = request.getParameter("goodsintro");
			String picture = request.getParameter("picture");
			int star = Integer.parseInt(request.getParameter("star"));
			Goods goods = new Goods();
			goods.setId(id);
			goods.setName(name);
			goods.setPrice(price);
			goods.setTid(tid);
			goods.setIntro(intro);
			goods.setPicture(picture);
			goods.setStar(star);
			GoodsManageService gms = new GoodsManageServiceImpl();
			int i = gms.editGoods(goods);
			response.sendRedirect("GoodsServlet?word=b");
		} else if (word.equals("e")) {
			// 删除商品信息
			int id = Integer.parseInt(request.getParameter("goodsid"));
			GoodsManageService gms = new GoodsManageServiceImpl();
			int i = gms.delGoods(id);
			response.sendRedirect("GoodsServlet?word=b");
		} else if (word.equals("f")) {
			// 按要求查找列表信息
			String name = request.getParameter("searchname");
			System.out.println(name);
			GoodsManageService gms = new GoodsManageServiceImpl();
			List<GoodsView> goodsList = gms.queryGoodsViewByName(name);
			/* System.out.println(goodsList); */
			request.setAttribute("goodsList", goodsList);
			request.getRequestDispatcher("admin/showGoods.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.创建FileItem工厂
		DiskFileItemFactory dif = new DiskFileItemFactory();
		// 2.创建servlet上传文件工具
		ServletFileUpload sfu = new ServletFileUpload(dif);
		// 3.利用servletFileUpload获取FileItem
		// 利用servlet上传工具获取FileItem工厂创建出的FileItem
		try {
			// 4.获取FileItem集合
			List<FileItem> itemList = sfu.parseRequest(request);
			// 5.遍历集合
			Goods goods = new Goods();
			System.out.println(goods);
			for (FileItem item : itemList) {
				// 6.获取普通表单数据
				// 如果数据是普通表单数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					System.out.println(name);
					// 解决中文乱码
					String value = new String(item.getString().getBytes(
							"iso8859-1"), "utf-8");
					System.out.println(value);
					if (name.equals("name")) {
						goods.setName(value);
					} else if (name.equals("price")) {
						goods.setPrice(Double.parseDouble(value));
					} else if (name.equals("typeid")) {
						goods.setTid(Integer.parseInt(value));
					} else if (name.equals("intro")) {
						goods.setIntro(value);
					} else if (name.equals("star")) {
						goods.setStar(Integer.parseInt(value));
					}
				} else {
					// 如果传入的是图片:
					// 7.上传文件
					// 7.1获取上传文件的名字
					String filename = item.getName();
					System.out.println(filename);
					// 7.2获取服务器上传文件夹的全路径
					String path = getServletContext().getRealPath("/upload");
					System.out.println(path);
					// 7.3创建文件
					File file = new File(path + "\\" + filename);
					// 7.4将二进制数据写入文件
					item.write(file);
					// 将路径写入数据库
					goods.setPicture("image\\" + filename);
				}
			}
			System.out.println(goods);
			GoodsManageService gms = new GoodsManageServiceImpl();
			int i = gms.addGoods(goods);
			response.sendRedirect("GoodsServlet?word=b");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
