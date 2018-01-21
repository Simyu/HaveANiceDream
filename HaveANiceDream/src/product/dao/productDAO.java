package product.dao;

import java.sql.Connection;
import java.sql.SQLException;

import product.ProductDTO;

public interface productDAO {

	int insertProduct(ProductDTO product, Connection connection) throws SQLException;
}
