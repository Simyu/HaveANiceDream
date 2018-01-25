package manager_blame.dao;

import java.sql.Connection;
import java.sql.SQLException;

import manager_blame.dto.Manager_BlameDTO;


public interface Manager_BlameDAO {
	int insert(Manager_BlameDTO dto,Connection con) throws SQLException;
	Manager_BlameDTO select(int answerNo,Connection con) throws SQLException;
}
