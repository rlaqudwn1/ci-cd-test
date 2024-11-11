package edu.cicdtest.repository;

import edu.cicdtest.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
