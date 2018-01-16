package trade;

import java.sql.Date;

public class TradeDTO {

    private Integer tradeNo;

    private Date tradeStartDate;

    private Date tradeEndDate;

    private String userIdBuy;

    private String userIdSell;

    private Integer productNo;

    private String tradeState;

    private String tradeMemo;
    
    public TradeDTO() {
	}

	public TradeDTO(Integer tradeNo, Date tradeStartDate, Date tradeEndDate, String userIdBuy, String userIdSell,
			Integer productNo, String tradeState, String tradeMemo) {
		super();
		this.tradeNo = tradeNo;
		this.tradeStartDate = tradeStartDate;
		this.tradeEndDate = tradeEndDate;
		this.userIdBuy = userIdBuy;
		this.userIdSell = userIdSell;
		this.productNo = productNo;
		this.tradeState = tradeState;
		this.tradeMemo = tradeMemo;
	}

	public Integer getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Integer tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Date getTradeStartDate() {
		return tradeStartDate;
	}

	public void setTradeStartDate(Date tradeStartDate) {
		this.tradeStartDate = tradeStartDate;
	}

	public Date getTradeEndDate() {
		return tradeEndDate;
	}

	public void setTradeEndDate(Date tradeEndDate) {
		this.tradeEndDate = tradeEndDate;
	}

	public String getUserIdBuy() {
		return userIdBuy;
	}

	public void setUserIdBuy(String userIdBuy) {
		this.userIdBuy = userIdBuy;
	}

	public String getUserIdSell() {
		return userIdSell;
	}

	public void setUserIdSell(String userIdSell) {
		this.userIdSell = userIdSell;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getTradeMemo() {
		return tradeMemo;
	}

	public void setTradeMemo(String tradeMemo) {
		this.tradeMemo = tradeMemo;
	}

	@Override
	public String toString() {
		return "TradeDTO [tradeNo=" + tradeNo + ", tradeStartDate=" + tradeStartDate + ", tradeEndDate=" + tradeEndDate
				+ ", userIdBuy=" + userIdBuy + ", userIdSell=" + userIdSell + ", productNo=" + productNo
				+ ", tradeState=" + tradeState + ", tradeMemo=" + tradeMemo + "]";
	}
    
    
}