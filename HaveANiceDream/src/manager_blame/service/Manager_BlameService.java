package manager_blame.service;

import manager_blame.dto.Manager_BlameDTO;

public interface Manager_BlameService {
	int insert(Manager_BlameDTO dto);
	Manager_BlameDTO select(int answerNo);
}
