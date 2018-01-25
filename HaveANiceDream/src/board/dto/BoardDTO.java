package board.dto;

import java.sql.Date;

public class BoardDTO {

    private Integer boardNo;

    private String userId;

    private Date writeDate;

    private String boardTitle;

    private String boardContent;

    private String boardType;

    private String boardState;

    private Integer boardCount;

    private Integer boardParentNo;

    private Integer boardLevel;

    private Integer boradOrder;
    
    private String borderimageSrc;
    
    public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(Integer boardNo, String userId, Date writeDate, String boardTitle, String boardContent,
			String boardType, String boardState, Integer boardCount, Integer boardParentNo, Integer boardLevel,
			Integer boradOrder, String borderimageSrc) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
		this.writeDate = writeDate;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardType = boardType;
		this.boardState = boardState;
		this.boardCount = boardCount;
		this.boardParentNo = boardParentNo;
		this.boardLevel = boardLevel;
		this.boradOrder = boradOrder;
		this.borderimageSrc = borderimageSrc;
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardState() {
		return boardState;
	}

	public void setBoardState(String boardState) {
		this.boardState = boardState;
	}

	public Integer getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(Integer boardCount) {
		this.boardCount = boardCount;
	}

	public Integer getBoardParentNo() {
		return boardParentNo;
	}

	public void setBoardParentNo(Integer boardParentNo) {
		this.boardParentNo = boardParentNo;
	}

	public Integer getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(Integer boardLevel) {
		this.boardLevel = boardLevel;
	}

	public Integer getBoradOrder() {
		return boradOrder;
	}

	public void setBoradOrder(Integer boradOrder) {
		this.boradOrder = boradOrder;
	}

	public String getBorderimageSrc() {
		return borderimageSrc;
	}

	public void setBorderimageSrc(String borderimageSrc) {
		this.borderimageSrc = borderimageSrc;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", userId=" + userId + ", writeDate=" + writeDate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardType=" + boardType + ", boardState="
				+ boardState + ", boardCount=" + boardCount + ", boardParentNo=" + boardParentNo + ", boardLevel="
				+ boardLevel + ", boradOrder=" + boradOrder + ", borderimageSrc=" + borderimageSrc + "]";
	}




    
}