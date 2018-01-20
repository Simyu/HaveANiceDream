package blame.service;

import java.util.ArrayList;

import blame.dto.BlameDTO;

public interface BlameService {
	int insert(BlameDTO dto);
	ArrayList<BlameDTO> list();
	int update(BlameDTO dto);
	BlameDTO select(int blameNo);

}
