package com.example.exercise_1.repository;

import com.example.exercise_1.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ILogRepository extends JpaRepository<Log,Long> {
    @Transactional
    Log findByMsg(String msg);
}
