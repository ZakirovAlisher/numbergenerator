package com.example.numbergenerator.service;

import com.example.numbergenerator.entity.ScoreboardCode;
import com.example.numbergenerator.repository.ScoreboardCodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Service with CRUD opertaions on ScoreboardCode entity
 */
@Service
public class ScoreboardCodeServiceImpl implements ScoreboardCodeService {
    private final ScoreboardCodeRepository scoreboardCodeRepository;

    public ScoreboardCodeServiceImpl(ScoreboardCodeRepository scoreboardCodeRepository) {
        this.scoreboardCodeRepository = scoreboardCodeRepository;
    }

    @Override
    public ScoreboardCode createScoreboardCode(ScoreboardCode scoreboardCode) {
        return scoreboardCodeRepository.save(scoreboardCode);
    }

    @Override
    public ScoreboardCode updateScoreboardCode(ScoreboardCode scoreboardCode) {
        Optional<ScoreboardCode> existingScoreboardCode = scoreboardCodeRepository.findById(scoreboardCode.getId());
        if (existingScoreboardCode.isPresent()) {
            return scoreboardCodeRepository.save(scoreboardCode);
        } else {
            throw new EntityNotFoundException("ScoreboardCode with id " + scoreboardCode.getId() + " not found.");
        }
    }

    @Override
    public void deleteScoreboardCode(Long id) {
        Optional<ScoreboardCode> existingScoreboardCode = scoreboardCodeRepository.findById(id);
        if (existingScoreboardCode.isPresent()) {
            scoreboardCodeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ScoreboardCode with id " + id + " not found.");
        }
    }

    @Override
    public List<ScoreboardCode> getAllScoreboardCodes() {
        return scoreboardCodeRepository.findAll();
    }

    @Override
    public ScoreboardCode getScoreboardCodeById(Long id) {
        Optional<ScoreboardCode> existingScoreboardCode = scoreboardCodeRepository.findById(id);
        if (existingScoreboardCode.isPresent()) {
            return existingScoreboardCode.get();
        } else {
            throw new EntityNotFoundException("ScoreboardCode with id " + id + " not found.");
        }
    }
}

