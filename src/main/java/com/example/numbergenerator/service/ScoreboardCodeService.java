package com.example.numbergenerator.service;

import com.example.numbergenerator.entity.ScoreboardCode;

import java.util.List;

public interface ScoreboardCodeService {
    ScoreboardCode createScoreboardCode(ScoreboardCode scoreboardCode);

    ScoreboardCode updateScoreboardCode(ScoreboardCode scoreboardCode);

    void deleteScoreboardCode(Long id);

    List<ScoreboardCode> getAllScoreboardCodes();

    ScoreboardCode getScoreboardCodeById(Long id);
}
