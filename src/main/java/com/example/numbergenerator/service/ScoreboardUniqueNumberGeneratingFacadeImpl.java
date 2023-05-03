package com.example.numbergenerator.service;

import com.example.numbergenerator.entity.ScoreboardCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Facade that works with incrementing ScoreboardCode and storing new value in db
 */
@Service
public class ScoreboardUniqueNumberGeneratingFacadeImpl implements ScoreboardUniqueNumberGeneratingFacade {

    private static final Long SCOREBOARD_CODE_ID = -1L;

    private ScoreboardCodeService scoreboardCodeService;

    @Autowired
    public void setScoreboardCodeService(ScoreboardCodeService scoreboardCodeService) {
        this.scoreboardCodeService = scoreboardCodeService;
    }

    @Override
    public String getIncrementedCode() {
        final ScoreboardCode scoreboardCode = this.scoreboardCodeService.getScoreboardCodeById(SCOREBOARD_CODE_ID);
        final String value = scoreboardCode.getValue();
        scoreboardCode.setValue(this.incrementCode(value));
        scoreboardCodeService.updateScoreboardCode(scoreboardCode);

        return scoreboardCode.getValue();
    }

    @Override
    public String incrementCode(String code) {
        char[] chars = code.toCharArray();
        int index = chars.length - 1;
        while (index >= 0) {
            if (chars[index] == 'z') {
                chars[index] = 'a';
                index--;
            } else if (chars[index] == '9') {
                chars[index] = '0';
                if (index > 0 && chars[index-1] != 'z' && chars[index-1] != '9') {
                    chars[index-1]++;
                    break;
                } else {
                    index--;
                }
            } else {
                chars[index]++;
                break;
            }
        }
        if (index < 0) {
            return "a0" + new String(chars);
        } else {
            return new String(chars);
        }
    }
}
