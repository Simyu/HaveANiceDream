package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import product.ProductDTO;
import product.ProductQuery;
import user.dto.MemberDTO;

public class productDAOimpl implements productDAO {
/*
PRODUCT_NO                                NOT NULL NUMBER
 USER_ID                                            VARCHAR2(20)
 CATEGORY_NO                                        NUMBER
 PRODUCT_NAME                                       VARCHAR2(20)
 PRODUCT_PRICE                                      NUMBER
 PRODUCT_CONTENT                                    VARCHAR2(2000)
 PRODUCT_GRADE                                      VARCHAR2(20)
 PRODUCT_TITLE                                      VARCHAR2(200)
 PRODUCT_DATE                                       DATE
 PRODUCT_STATE                                      NUMBER
 PRODUCT_EXF_DATE                                   NUMBER
 TRADE_TYPE                                         VARCHAR2(20)
 * */
	
	/*
	 *  Name                                      Null?    Type
 ----------------------------------------- -------- --------------
 IMAGE_NO                                  NOT NULL NUMBER
 PRODUCT_NO                                         NUMBER
 IMAGE_SRC                                          VARCHAR2(20)
	 * */
	@Override
	public int insertProduct_Image(String imageSrc, Connection connection) throws SQLException {
		  int result=0;
		  PreparedStatement ptmt=null;
		  ptmt = connection.prepareStatement(ProductQuery.PRODUCT_IMG_INSERT);
		//  System.out.println(imageSrc);
		     ptmt.setString(1, imageSrc);
		     result=ptmt.executeUpdate();
		     
		     DBUtil.close(ptmt);
		  return result;
	}
	
	@Override
	public String productSelect_Image(int productNo, Connection connection) throws SQLException {
		ProductDTO product = null;
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		String result="";
		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_IMG_SELECTPNO);
		ptmt.setInt(1, productNo);
		resultSet = ptmt.executeQuery();
		if(resultSet.next()){
			result=resultSet.getString(1);
		}
		
		//System.out.println(result);
		return result;
	}
	
	
	@Override
	public ProductDTO productSelect(int productNo, Connection connection) throws SQLException {
		ProductDTO product = null;
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(productNo!=0){
		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_SELECTPNO);
		ptmt.setInt(1, productNo);
		}
		resultSet = ptmt.executeQuery();
		if(resultSet.next()){
		product = new ProductDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
					resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getDate(9), resultSet.getInt(10), resultSet.getInt(11), resultSet.getString(12),resultSet.getInt(13));
		}
		
		//System.out.println(product);
		return product;
	}
	
	
	@Override
	public ArrayList<ProductDTO> product_List(String title,Connection connection) throws SQLException {
		ArrayList<ProductDTO> product_list = new ArrayList<ProductDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		 if(title!=null){
			ptmt = connection.prepareStatement(ProductQuery.PRODUCT_SEARCHTITLE);
			ptmt.setString(1, "%"+title+"%");
		}else{

			ptmt = connection.prepareStatement(ProductQuery.PRODUCT_SELECTALL);
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			if (product_list == null) {
				product_list = new ArrayList<ProductDTO>();
			}

			ProductDTO  dto = new ProductDTO(
					resultSet.getInt(1),
					resultSet.getString(2),
					resultSet.getInt(3),
					resultSet.getString(4),
					resultSet.getInt(5),
					resultSet.getString(6),
					resultSet.getString(7),
					resultSet.getString(8),
					resultSet.getDate(9),
					resultSet.getInt(10),
					resultSet.getInt(11),
					resultSet.getString(12),
					resultSet.getInt(13)
					);

			product_list.add(dto);
		}
		
		
		
		
		
		return product_list;
	}
	
	
	@Override
	public int insertProduct(ProductDTO product, Connection connection ) throws SQLException {
		
		int result = 0;
		PreparedStatement ptmt = null;

		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_INSERT);
		//"insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,3,?)";
		
		ptmt.setString(1, product.getUserId());
		ptmt.setInt(2, product.getCategoryNo());
		ptmt.setString(3, product.getProductName());
		ptmt.setInt(4, product.getProductPrice());
		ptmt.setString(5, product.getProductContent());
		ptmt.setString(6, product.getProduct_Grade());
		ptmt.setString(7, product.getProductTitle());
		ptmt.setInt(8, product.getProductState());
		ptmt.setInt(9, 3);
		ptmt.setString(10, product.getTradeType());
		ptmt.setInt(11, product.getCategoryDetailNo());
		
		result = ptmt.executeUpdate();
		
	  // System.out.println(result);
        
		

		DBUtil.close(ptmt);

		return result;
	}


	


	

	
   
}
