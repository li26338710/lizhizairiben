package com.junpeng.daigou.controller.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.status.StatusService;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService statusService;

	@ResponseBody
	@RequestMapping("/findbyStatusType")
	public CommonResponse<StatusResponse> findStatusByStatusType(
				@RequestParam(value="statusType" , defaultValue = "0") String statusType ){
		List<StatusResponse> response = statusService.findStatusByStatusType(statusType);
		return new CommonResponse<StatusResponse>(response);
	}
}
