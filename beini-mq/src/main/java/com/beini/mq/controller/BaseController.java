package com.beini.mq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.utils.JsonUtil;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.mq.entity.TestTemp;
import com.beini.mq.imoocSender.MQSender;
import com.beini.mq.thread.SendThread;

@SuppressWarnings("unchecked")
@RestController
public class BaseController {
	@Autowired
	private MQSender mqSender;
	@Autowired
	private SendThread sendThread;
	@GetMapping("mq")
	public ResultVO<TestTemp> mq(int num){
		for(int i = 1;i<=num;i++) {
			mqSender.send(JsonUtil.beanToString(new TestTemp("name_"+i)));
		}
		return ResultVOUtil.success("并发单条mq");
	}
	
	@RequestMapping("/mqs")
	public String mqs(){
		long begin=0,end=0;
		begin = new Date().getTime();
		for (int i = 0; i < 1000; i++) {
			sendThread.execute();
		}
		
/*		for (int i = 0; i < 500; i++) {
			sendThread.execute2();
		}
		*/
		
		end = new Date().getTime();
		System.out.println((end-begin)+"---------------------------------------------------------------- s");
		return "success";
	}
}
