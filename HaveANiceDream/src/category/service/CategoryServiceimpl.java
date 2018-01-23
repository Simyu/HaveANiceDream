package category.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import category.CategoryDTO;
import category.CategoryDetailDTO;
import category.dao.CategoryDAO;
import category.dao.CategoryDAOimpl;
import fw.DBUtil;

public class CategoryServiceimpl implements CategoryService {

	@Override
	public ArrayList<CategoryDTO> categoryList() {
		ArrayList<CategoryDTO> category_list = new ArrayList<CategoryDTO>();
		Connection connection = null;
		CategoryDAO dao = new CategoryDAOimpl();
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			category_list=dao.categoryList(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return category_list;
	}

	@Override
	public ArrayList<CategoryDetailDTO> categoryDetailList(String categoryName) {
		ArrayList<CategoryDetailDTO> category_list = new ArrayList<CategoryDetailDTO>();
		Connection connection = null;
		CategoryDAO dao = new CategoryDAOimpl();
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			category_list=dao.categoryDetailList(categoryName, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return category_list;
	}

	@Override
	public ArrayList<CategoryDetailDTO> categoryDetailListAjax(String categoryName) {
		ArrayList<CategoryDetailDTO> category_list = new ArrayList<CategoryDetailDTO>();
		Connection connection = null;
		CategoryDAO dao = new CategoryDAOimpl();
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			category_list=dao.categoryDetailListAjax(categoryName, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return category_list;
	}

}
