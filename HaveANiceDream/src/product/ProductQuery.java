package product;

public class ProductQuery {
	public static final String PRODUCT_INSERT = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?)";
	public static final String PRODUCT_SELECTALL="select * from product";
	public static final String PRODUCT_SELECTPNO="select * from product where  productNo= ?";
	
}
