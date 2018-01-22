package attendance.dao;

import java.sql.Connection;
import java.sql.SQLException;

import attendance.dto.AttendanceDTO;

public interface AttendanceDAO {
	int insert(AttendanceDTO dto,Connection con)throws SQLException;
	
}
