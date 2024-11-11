package edu.cicdtest.service;

import edu.cicdtest.entity.TestEntity;
import edu.cicdtest.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    public TestEntity testCreate(){
        return testRepository.save(TestEntity.builder().name("testCreate").build());
    }
    public TestEntity findTestById(int id){
        TestEntity byId = testRepository.findById(id).get();
        return byId;
    }
}
