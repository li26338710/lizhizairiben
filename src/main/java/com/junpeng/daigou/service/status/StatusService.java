package com.junpeng.daigou.service.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.status.StatusResponse;
import com.junpeng.daigou.dao.StatusMapper;
import com.junpeng.daigou.model.Status;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class StatusService {
	@Autowired
	private StatusMapper statusDao;
	
	public List<StatusResponse> findStatusByStatusType(String statusType) {
		List<Status> statuses = statusDao.getStatusByStatusType(statusType);
		List<StatusResponse> result = new ArrayList<StatusResponse>();
		if (Utils.isNotEmpty(statuses)) {
			for (Status s : statuses) {
				
				result.add(saveStatusToResponse(s));
			}
		}
		return result;
	}
	
	private StatusResponse saveStatusToResponse(Status s) {
		
		StatusResponse sr = new StatusResponse();
		
		sr.setComment(s.getComment());
		sr.setIdstatus(String.valueOf(s.getIdstatus()));
		sr.setStatusCode(s.getStatuscode());
		sr.setStatusStr(s.getStatusvalue());
		sr.setStatusType(s.getStatustype());
		
		return sr;
	}
	
}
