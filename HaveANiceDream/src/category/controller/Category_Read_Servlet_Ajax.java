package category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import category.CategoryDetailDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;


@WebServlet(name = "category/readAjax", urlPatterns = { "/category/readAjax.do" })
public class Category_Read_Servlet_Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//
		PrintWriter pw = response.getWriter();
		String categoryName=request.getParameter("categoryName");
		CategoryService service = new CategoryServiceimpl();
		ArrayList<CategoryDetailDTO> category_detail_list  = service.categoryDetailList(categoryName);
		//System.out.println(category_detail_list);
		//이름으로 검색하는데 해당이름으로 시작하는 항목을 검색할 예정.. %
		ArrayList<CategoryDetailDTO> category_detail_listAjax=service.categoryDetailListAjax(categoryName);
		//json파싱.
		JSONObject category_detail = new JSONObject();
		JSONArray list = new JSONArray();
		int size=category_detail_listAjax.size();
		for (int i = 0; i < size; i++) {
			CategoryDetailDTO dto =category_detail_listAjax.get(i);

			list.add(dto.getCategoryDetailName());
			
		}
		category_detail.put("categoryDetailName", list);
		 response.setContentType("application/json;charset=euc-kr");
	     response.setHeader("cache-control", "no-cache,no-store");
	     System.out.println(category_detail.toJSONString());
	     pw.print(category_detail.toJSONString());
	}

}
