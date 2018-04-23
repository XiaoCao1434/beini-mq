package com.beini.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.utils.JsonUtil;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.mq.entity.TestTemp;
import com.beini.mq.imoocSender.MQSender;

@RestController
@RequestMapping("/")
public class BaseController {
	@Autowired
	private MQSender mqSender;
	
	@SuppressWarnings("unchecked")
	@GetMapping("mq")
	public ResultVO<TestTemp> mq(int num){
		for(int i = 1;i<=num;i++) {
			mqSender.send(JsonUtil.beanToString(new TestTemp("name_"+i)));
		}
		return ResultVOUtil.success("发送单条mq");
	}
}
