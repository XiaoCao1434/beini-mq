package com.beini.mq.service;

import java.util.List;

import com.beini.mq.entity.TestTemp;

public interface TestTempService {
	
	int save(List<TestTemp> list);
	int save(TestTemp bean);
}
