package attendance.service;

import java.sql.Connection;
import java.sql.SQLException;

import attendance.dto.AttendanceDTO;

public interface AttendanceService {
	int insert(AttendanceDTO dto);
}
