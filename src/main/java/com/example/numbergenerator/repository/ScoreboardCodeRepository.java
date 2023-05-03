package com.example.numbergenerator.repository;

import com.example.numbergenerator.entity.ScoreboardCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreboardCodeRepository extends JpaRepository<ScoreboardCode, Long> {
}
