package product.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.ProductDTO;

public interface productDAO {

	int insertProduct(ProductDTO product, Connection connection) throws SQLException;
	ArrayList<ProductDTO>  product_List(Connection connection) throws SQLException;
	int insertProduct_Image(String imageSrc,Connection connection)throws SQLException;
	ProductDTO productSelect(int productNo, Connection connection) throws SQLException;
	
	String productSelect_Image(int productNo, Connection connection) throws SQLException;
	
}
