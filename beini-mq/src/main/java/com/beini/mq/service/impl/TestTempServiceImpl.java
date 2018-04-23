package com.beini.mq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beini.mq.entity.TestTemp;
import com.beini.mq.repository.TestTempRepository;
import com.beini.mq.service.TestTempService;
@Service
public class TestTempServiceImpl implements TestTempService {
	@Autowired
	private TestTempRepository repository;
	@Override
	public int save(List<TestTemp> list) {
		return repository.save(list).size();
	}
	@Override
	public int save(TestTemp bean) {
		return repository.save(bean)==null?1:0;
	}

}
