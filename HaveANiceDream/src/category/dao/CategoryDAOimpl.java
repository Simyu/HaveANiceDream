package category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import category.CategoryDTO;
import category.CategoryDetailDTO;
import product.ProductDTO;
import product.ProductQuery;

public class CategoryDAOimpl implements CategoryDAO {

	@Override
	public ArrayList<CategoryDTO> categoryList(String categoryName,  Connection connection) throws SQLException {
		ArrayList<CategoryDTO> category_list  = new ArrayList<CategoryDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(categoryName!=null){
			ptmt = connection.prepareStatement("select * from category where category_Name like  ?");
			ptmt.setString(1, categoryName+"%");
		}else{
		ptmt = connection.prepareStatement("select * from category");
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			CategoryDTO  dto = new CategoryDTO(resultSet.getInt(1), resultSet.getString(2));				
			category_list.add(dto);
		}
		//System.out.println(category_list);
		
		return category_list;
	}

	@Override
	public ArrayList<CategoryDetailDTO> categoryDetailList(int categoryNo, String categoryDetailName,Connection connection) throws SQLException {
		ArrayList<CategoryDetailDTO> category_detail_list  = new ArrayList<CategoryDetailDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(categoryNo!=0){
			ptmt = connection.prepareStatement("select * from category_detail where category_no = ?");
			 ptmt.setInt(1, categoryNo);
		}else if(categoryDetailName!=null){
			ptmt = connection.prepareStatement("select * from category_detail where category_detail_name like ? ");
			 ptmt.setString(1, categoryDetailName+"%");
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			CategoryDetailDTO  dto = new CategoryDetailDTO(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));				
			category_detail_list.add(dto);
		}
		System.out.println(category_detail_list);
		return category_detail_list;
	}


	
	
}