package attendance.query;

public class AttendanceQuery {
	public static final String ATTENDANCEQUERY_INSERT = 
			"insert into attendance values(ATTENDANCE_SEQ.nextval,"
			+ "?,?,sysdate)";
}
