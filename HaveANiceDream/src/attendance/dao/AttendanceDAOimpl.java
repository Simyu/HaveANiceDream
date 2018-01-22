package attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static fw.DBUtil.*;
import attendance.dto.AttendanceDTO;
import attendance.query.*;

public class AttendanceDAOimpl implements AttendanceDAO {

	
	public int insert(AttendanceDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(AttendanceQuery.ATTENDANCEQUERY_INSERT);
		
		ptmt.setString(1, dto.getUserId());
		ptmt.setInt(2, dto.getAttPoint());
		
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

}
