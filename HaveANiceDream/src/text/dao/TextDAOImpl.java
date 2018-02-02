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

		ptmt = connection.prepareStatement("insert into text values(text_seq.nextval,trade_seq.currval,?,?,?");
		ptmt.setString(1, text.getUserId());
		ptmt.setString(2, text.getTextDate());
		ptmt.setString(3, text.getTextContent());
		result = ptmt.executeUpdate();
		
		return result;
	}

}
