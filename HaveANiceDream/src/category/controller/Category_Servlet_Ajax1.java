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

import category.CategoryDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;

@WebServlet(name = "category/readAjax1", urlPatterns = { "/category/readAjax1.do" })
public class Category_Servlet_Ajax1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String categoryName = request.getParameter("categoryName");
		CategoryService service = new CategoryServiceimpl();
		// ArrayList<CategoryDetailDTO> category_detail_list =
		// service.categoryDetailList(categoryName);
		// System.out.println(category_detail_list);
		// 이름으로 검색하는데 해당이름으로 시작하는 항목을 검색할 예정.. %
		ArrayList<CategoryDTO> category_listAjax = service.categoryList(categoryName);
		// json파싱.
		// System.out.println(categoryName);
		JSONObject root_category = new JSONObject();
		JSONArray list = new JSONArray();
		int size = category_listAjax.size();
		for (int i = 0; i < size; i++) {
			CategoryDTO dto = category_listAjax.get(i);
			JSONObject category = new JSONObject();
			category.put("categoryNo", dto.getCategoryNo());
			category.put("categoryName", dto.getCategoryName());

			list.add(category);

		}

		root_category.put("category", list);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		pw.print(root_category.toJSONString());
	}
}
