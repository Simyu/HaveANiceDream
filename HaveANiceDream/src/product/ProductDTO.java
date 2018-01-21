package product;

import java.sql.Date;

public class ProductDTO {

    private Integer productNo;

    public String getProduct_Grade() {
		return product_Grade;
	}

	public void setProduct_Grade(String product_Grade) {
		this.product_Grade = product_Grade;
	}

	public ProductDTO(String userId, String productName, Integer productPrice, String productContent, String productGrade,
			String productTitle, int productState, String tradeType) {
		super();
		this.userId = userId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.product_Grade = productGrade;
		this.productTitle = productTitle;
		this.productState = productState;
		this.tradeType = tradeType;
	}

	private String userId;

    private Integer categoryNo;

    private String productName;

    private Integer productPrice;

    private String productContent;

    private String product_Grade;

    private String productTitle;

    private Date productDate;

    private int productState;

    private Integer productExfDate;

    private String tradeType;
    
    public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Integer productNo, String userId, Integer categoryNo, String productName, Integer productPrice,
			String productContent, String product_Grade, String productTitle, Date productDate, int productState,
			Integer productExfDate, String tradeType) {
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
    
    
}