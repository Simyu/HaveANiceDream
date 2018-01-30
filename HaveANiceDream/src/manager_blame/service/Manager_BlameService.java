package manager_blame.service;

import java.util.ArrayList;

import manager_blame.dto.Manager_BlameDTO;

public interface Manager_BlameService {
	int insert(Manager_BlameDTO dto);
	ArrayList<String> select(int answerNo);
}
