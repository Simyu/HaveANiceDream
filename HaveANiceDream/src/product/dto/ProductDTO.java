package product.dto;

import java.sql.Date;

public class ProductDTO {

    private Integer productNo;
	
	int rowNum;
    public String getProduct_Grade() {
		return product_Grade;
	}

	public void setProduct_Grade(String product_Grade) {
		this.product_Grade = product_Grade;
	}

	public ProductDTO(String userId, int categoryNo, String productName, Integer productPrice, String productContent, String productGrade,
			String productTitle, int productState, String tradeType , Integer categoryDetailNo) {
		super();
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = productGrade;
		this.productTitle = productTitle;
		this.productState = productState;
		this.tradeType = tradeType;
		this.categoryDetailNo = categoryDetailNo;
	}
	public ProductDTO(String userId, int categoryNo, String productName, Integer productPrice, String productContent, String productGrade,
			String productTitle, int productState, String tradeType , Integer categoryDetailNo, int productNo) {
		super();
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = productGrade;
		this.productTitle = productTitle;
		this.productState = productState;
		this.tradeType = tradeType;
		this.categoryDetailNo = categoryDetailNo;
		this.productNo = productNo;
	}

	private String userId;

    private Integer categoryNo;
    
    private Integer categoryDetailNo;

    private String productName;

    private Integer productPrice;

    private String productContent;

    private String product_Grade;

    private String productTitle;

    private Date productDate;

    private int productState;

    private Integer productExfDate;

    private String tradeType;
    
    private String categoryName;
    
    private String imageSrc;
    
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public ProductDTO(Integer productNo, String userId, Integer categoryNo, String productName ,
			 Integer productPrice, String productContent, String product_Grade, String productTitle,
			Date productDate, int productState, Integer productExfDate, String tradeType, Integer categoryDetailNo, String categoryName,
			String imageSrc) {
		super();
		this.productNo = productNo;
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.categoryDetailNo = categoryDetailNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = product_Grade;
		this.productTitle = productTitle;
		this.productDate = productDate;
		this.productState = productState;
		this.productExfDate = productExfDate;
		this.tradeType = tradeType;
		this.categoryName = categoryName;
		this.imageSrc = imageSrc;
	}
    public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Integer productNo, String userId, Integer categoryNo, String productName, Integer productPrice,
			String productContent, String product_Grade, String productTitle, Date productDate, int productState,
			Integer productExfDate, String tradeType,Integer categoryDetailNo) {
		super();
		this.productNo = productNo;
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = product_Grade;
		this.productTitle = productTitle;
		this.productDate = productDate;
		this.productState = productState;
		this.productExfDate = productExfDate;
		this.tradeType = tradeType;
		this.categoryDetailNo = categoryDetailNo;
	}

	public Integer getCategoryDetailNo() {
		return categoryDetailNo;
	}

	public void setCategoryDetailNo(Integer categoryDetailNo) {
		this.categoryDetailNo = categoryDetailNo;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getUserId() {
		return userId;
	}

	public ProductDTO(int productState) {
		super();
		this.productState = productState;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String product_Grade() {
		return product_Grade;
	}


	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public int getProductState() {
		return productState;
	}

	public void setProductState(int productState) {
		this.productState = productState;
	}

	public Integer getProductExfDate() {
		return productExfDate;
	}

	public void setProductExfDate(Integer productExfDate) {
		this.productExfDate = productExfDate;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", userId=" + userId + ", categoryNo=" + categoryNo
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productContent="
				+ productContent + ", productCount=" + product_Grade + ", productTitle=" + productTitle
				+ ", productDate=" + productDate + ", productState=" + productState + ", productExfDate="
				+ productExfDate + ", tradeType=" + tradeType + "]";
	}
    
	
	private String userEmail;

	private String userName;
	
	private String userTel;
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public ProductDTO(int rowNum,Integer productNo, String userId, Integer categoryNo, String productName ,
			 Integer productPrice, String productContent, String product_Grade, String productTitle,
			Date productDate, int productState, Integer productExfDate, String tradeType, Integer categoryDetailNo, String categoryName,
			String imageSrc, String userName,String userTel ,String userEmail) {
		super();
		this.rowNum = rowNum;
		this.productNo = productNo;
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.categoryDetailNo = categoryDetailNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = product_Grade;
		this.productTitle = productTitle;
		this.productDate = productDate;
		this.productState = productState;
		this.productExfDate = productExfDate;
		this.tradeType = tradeType;
		this.categoryName = categoryName;
		this.imageSrc = imageSrc;
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	
	private String categoryDetailName;
	public ProductDTO(Integer productNo, String userId, Integer categoryNo, String productName ,
			 Integer productPrice, String productContent, String product_Grade, String productTitle,
			Date productDate, int productState, Integer productExfDate, String tradeType, Integer categoryDetailNo, String categoryName,
			String imageSrc, String userName,String userTel ,String userEmail, String categoryDetailName) {
		super();
		this.productNo = productNo;
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.categoryDetailNo = categoryDetailNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = product_Grade;
		this.productTitle = productTitle;
		this.productDate = productDate;
		this.productState = productState;
		this.productExfDate = productExfDate;
		this.tradeType = tradeType;
		this.categoryName = categoryName;
		this.imageSrc = imageSrc;
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.categoryDetailName = categoryDetailName;
	}


	public String getCategoryDetailName() {
		return categoryDetailName;
	}

	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}

	
	
	
	
	
	
	
    
}