package point.service;

import java.util.ArrayList;

import point.dto.PointDTO;

public interface PointService {
	ArrayList<PointDTO> pointList(String userId);

}
