package note.query;

public class NoteQuery {
	public static final String NOTE_INSERT = "INSERT INTO Note VALUES (Note_SEQ.NEXTVAL, ?, ?, sysdate, ?, 'N')";
	public static final String NOTE_UPDATE_STATE = "UPDATE Note SET note_state = 'Y' WHERE note_no = ?";
	public static final String NOTE_DELETE = "DELETE FROM Note WHERE note_no = ?";

	public static final String NOTE_READ = "SELECT * FROM Note WHERE note_no = ?";
	public static final String NOTE_LIST_SEND = "SELECT * FROM Note WHERE note_sender = ?";
	public static final String NOTE_LIST_RECEIVE = "SELECT * FROM Note WHERE note_receiver = ?";
	public static final String NOTE_NEW_NOTE_COUNT = "SELECT count(*) FROM Note WHERE note_state = 'N' and note_receiver = ?";
}
