package product.query;

public class ProductQuery {
	//카테고리 시퀀스로 구분해서  핸드폰인지 유야용품인지 구분하는작업이 필요함
	//동시에 디테일도 같이 추가 (int형식)
	//사진이미지 저장되는것까지 한번에 확인할수도록.
	public static final String PRODUCT_INSERT = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
	public static final String PRODUCT_SELECTALL="select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email from product p, category c,product_image i,member m where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id";
	public static final String PRODUCT_SELECTALL1="select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email from product p, category c,product_image i,member m where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.user_id= ?";
	public static final String PRODUCT_SELECTPNO="select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email from product p, category c,product_image i,member m where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_No= ?";
//여기가 정보를 가져옴!!
	public static final String PRODUCT_SEARCHTITLE="select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src from product p, category c,product_image i where p.category_no = c.category_no and p.product_no = i.product_no and p.product_title like ? and p.category_no = ? and p.category_detail_no = ?";
//	"select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.iamge_src from product p, category c,product_image i where p.product_no =c.product_no and p.product_no=i.product_no ":    
	public static final String PRODUCT_SEARCHTITLENO="select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src "+
" from product p, category c,product_image i where  p.category_no = c.category_no and p.product_no= i.product_no and  p.product_title like ? and   p.category_no = ? ";
	public static final String PRODUCT_IMG_INSERT = "insert into product_image values(PRODUCT_IMAGE_SEQ.nextval,product_seq.currval,?)";
	public static final String PRODUCT_IMG_UPDATE = "update product_image set image_src =? where product_no = ?";
	public static final String PRODUCT_IMG_SELECTPNO= "select IMAGE_SRC from product_image where  product_No= ?";



	
	
}
