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

import category.dto.CategoryDetailDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;

//category_detail에 대한 내용을 AJAX 통신을 사용하여 DB에 접근해서 받아옴
@WebServlet(name = "category/readAjax", urlPatterns = { "/category/readAjax.do" })
public class Category_Read_Servlet_Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String categoryName=request.getParameter("categoryName");  //카테고리이름을 받아옴
		
		CategoryService service = new CategoryServiceimpl();
		ArrayList<CategoryDetailDTO> category_detail_listAjax =  null; 
		String state=request.getParameter("state");
		if(state.equals("ENROLL")){//물품등록할때
		 category_detail_listAjax=service.categoryDetailList(0,categoryName);//이름으로 검색할때 해당이름으로 시작하는것들은 전부가져오기 위해 이름으로 검색
		}else if (state.equals("SEARCH")){//product_list.jsp화면에서 대분류를 선택했을때 실행되는 코드.
			int categoryNo=Integer.parseInt(request.getParameter("categoryNo"));//?
			category_detail_listAjax =service.categoryDetailList(categoryNo,null);//카테고리 No로 검색 2번째는 이름으로검색. 리턴은 카테고리디테일리스트
				}
		JSONObject root_category_detail = new JSONObject();
		JSONArray list = new JSONArray();
		int size=0;
		if(category_detail_listAjax!=null){
		size=category_detail_listAjax.size();
		}
		for (int i = 0; i < size; i++) {
			CategoryDetailDTO dto =category_detail_listAjax.get(i);
			JSONObject category_detail = new JSONObject();
			category_detail.put("categoryDetailNo", dto.getCategoryDetailNo());
			category_detail.put("categoryDetailName", dto.getCategoryDetailName());
			category_detail.put("categoryNo", dto.getCategoryNo());

			list.add(category_detail);
			
		}
		
		root_category_detail.put("category_detail", list);
		 response.setContentType("application/json;charset=utf-8");
	     response.setHeader("cache-control", "no-cache,no-store");
	     pw.print(root_category_detail.toJSONString());
	}

}
