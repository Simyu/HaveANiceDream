package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fw.DBUtil;
import product.ProductDTO;
import product.ProductQuery;

public class productDAOimpl implements productDAO {
/*
 * PRODUCT_NO                                    NOT NULL NUMBER
 USER_ID                                               VARCHAR2(20)
 CATEGORY_NO                                              NUMBER
 PRODUCT_NAME                                                VARCHAR2(20)
 PRODUCT_PRICE                                               NUMBER
 PRODUCT_CONTENT                                               VARCHAR2(2000)
 PRODUCT_COUNT                                        NUMBER
 PRODUCT_TITLE                            VARCHAR2(200)
 PRODUCT_DATE                             DATE
 PRODUCT_STATE                            VARCHAR2(20)
 PRODUCT_EXF_DATE                               NUMBER
 TRADE_TYPE                            CHAR(1)
 * */
	@Override
	public int insertProduct(ProductDTO product, Connection connection ) throws SQLException {
		
		int result = 0;
		PreparedStatement ptmt = null;

		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_INSERT);
		//"insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,3,?)";
		
		ptmt.setString(1, product.getUserId());
		ptmt.setString(2, "");
		ptmt.setString(3, product.getProductName());
		ptmt.setInt(4, product.getProductPrice());
		ptmt.setString(5, product.getProductContent());
		ptmt.setString(6, product.getProduct_Grade());
		ptmt.setString(7, product.getProductTitle());
		ptmt.setInt(8, product.getProductState());
		ptmt.setInt(9, 3);
		ptmt.setString(10, product.getTradeType());
		
		result = ptmt.executeUpdate();
		
	   System.out.println(result);
        
		

		DBUtil.close(ptmt);

		return result;
	}
   
}
