package note;

import java.sql.Date;

public class NoteDTO {

    private Integer noteNo;

    private String noteSender;

    private String noteReceiver;

    private Date noteDate;

    private String noteContent;

    private String noteState;
    
    public NoteDTO() {
		// TODO Auto-generated constructor stub
	}

	public NoteDTO(Integer noteNo, String noteSender, String noteReceiver, Date noteDate, String noteContent,
			String noteState) {
		super();
		this.noteNo = noteNo;
		this.noteSender = noteSender;
		this.noteReceiver = noteReceiver;
		this.noteDate = noteDate;
		this.noteContent = noteContent;
		this.noteState = noteState;
	}

	public NoteDTO(String noteSender, String noteReceiver, String noteContent) {
		super();
		this.noteSender = noteSender;
		this.noteReceiver = noteReceiver;
		this.noteContent = noteContent;
	}
    
    
}