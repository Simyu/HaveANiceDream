package product;

public class ProductQuery {
	//카테고리 시퀀스로 구분해서  핸드폰인지 유야용품인지 구분하는작업이 필요함
	//동시에 디테일도 같이 추가 (int형식)
	//사진이미지 저장되는것까지 한번에 확인할수도록.
	public static final String PRODUCT_INSERT = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
	public static final String PRODUCT_SELECTALL="select * from product";
	public static final String PRODUCT_SELECTPNO="select * from product where  product_No= ?";
	public static final String PRODUCT_SEARCHTITLE="select * from product where  product_title like ?";
	public static final String PRODUCT_IMG_INSERT = "insert into product_image values(PRODUCT_IMAGE_SEQ.nextval,product_seq.currval,?)";
	public static final String PRODUCT_IMG_UPDATE = "update product_image set image_src =? where product_no = ?";
	public static final String PRODUCT_IMG_SELECTPNO= "select IMAGE_SRC from product_image where  product_No= ?";
	
	
	
	
	
	
}
