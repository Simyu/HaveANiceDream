package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import fw.DBUtil;
import product.ProductDTO;
import product.dao.productDAO;
import product.dao.productDAOimpl;

public class ProductServiceimpl implements ProductService {

	@Override
	public int insertProduct(ProductDTO product) {
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			result = dao.insertProduct(product, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return result;
	}

}
