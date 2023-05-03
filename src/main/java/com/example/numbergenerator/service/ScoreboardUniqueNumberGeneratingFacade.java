package com.example.numbergenerator.service;

public interface ScoreboardUniqueNumberGeneratingFacade {
    String incrementCode(String code);

    String getIncrementedCode();
}
