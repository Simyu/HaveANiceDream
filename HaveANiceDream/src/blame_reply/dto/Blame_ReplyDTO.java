package blame_reply.dto;

import java.sql.Date;

public class Blame_ReplyDTO {

    private Integer blame_replyNo;

    private String blame_replyType;

    private String blame_replyTitle;
    
    private Date blame_replyDate;

    private String blame_replyContent;

    
    public Blame_ReplyDTO(String blame_replyType, String blame_replyTitle,String blame_replyContent) {
		super();
		this.blame_replyType = blame_replyType;
		this.blame_replyTitle = blame_replyTitle;
		this.blame_replyContent = blame_replyContent;
	}
	public Blame_ReplyDTO(Integer blame_replyNo, String blame_replyType, String blame_replyTitle, Date blame_replyDate,
			String blame_replyContent) {
		super();
		this.blame_replyNo = blame_replyNo;
		this.blame_replyType = blame_replyType;
		this.blame_replyTitle = blame_replyTitle;
		this.blame_replyDate = blame_replyDate;
		this.blame_replyContent = blame_replyContent;
	}

	@Override
	public String toString() {
		return "Blame_ReplyDTO [blame_replyNo=" + blame_replyNo + ", blame_replyType=" + blame_replyType
				+ ", blame_replyTitle=" + blame_replyTitle + ", blame_replyDate=" + blame_replyDate
				+ ", blame_replyContent=" + blame_replyContent + "]";
	}

	public Integer getBlame_replyNo() {
		return blame_replyNo;
	}

	public void setBlame_replyNo(Integer blame_replyNo) {
		this.blame_replyNo = blame_replyNo;
	}

	public String getBlame_replyType() {
		return blame_replyType;
	}

	public void setBlame_replyType(String blame_replyType) {
		this.blame_replyType = blame_replyType;
	}

	public String getBlame_replyTitle() {
		return blame_replyTitle;
	}

	public void setBlame_replyTitle(String blame_replyTitle) {
		this.blame_replyTitle = blame_replyTitle;
	}

	public Date getBlame_replyDate() {
		return blame_replyDate;
	}

	public void setBlame_replyDate(Date blame_replyDate) {
		this.blame_replyDate = blame_replyDate;
	}

	public String getBlame_replyContent() {
		return blame_replyContent;
	}

	public void setBlame_replyContent(String blame_replyContent) {
		this.blame_replyContent = blame_replyContent;
	}

    
    
	
}