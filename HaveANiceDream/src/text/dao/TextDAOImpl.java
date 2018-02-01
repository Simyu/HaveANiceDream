package text.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import product.query.ProductQuery;
import text.TextDTO;

public class TextDAOImpl implements TextDAO {

	@Override
	public int insertText(TextDTO text, Connection connection ) throws SQLException {
		int result=0;
		
		PreparedStatement ptmt = null;

		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_INSERT);
		//"insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,3,?)";
		
		
		return result;
	}

}
