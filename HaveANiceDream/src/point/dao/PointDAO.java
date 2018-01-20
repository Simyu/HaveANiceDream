package point.dao;

import java.sql.Connection;
import java.sql.SQLException;

import point.PointDTO;


public interface PointDAO {
	int pointInsert(PointDTO point, Connection connection) throws SQLException;

}
