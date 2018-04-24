package com.beini.mq.repository;

import java.util.List;

import com.beini.mq.entity.TestTemp;

public interface TestTempMapper {
	//@InsertProvider(type = UserDAOProvider.class, method = "insertAll")
	int save(List<TestTemp> list);
	int save(TestTemp bean);
}
