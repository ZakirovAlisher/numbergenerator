package com.example.numbergenerator.api.endpoint;

import com.example.numbergenerator.api.constants.ApiConstants;
import com.example.numbergenerator.service.ScoreboardUniqueNumberGeneratingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint to work with scoreboard codes.
 * It has method to get next code
 */

@RestController
@RequestMapping(ApiConstants.API_VERSION_V1 + ScoreboardCodeEndpoint.RESOURCE_PATH)
public class ScoreboardCodeEndpoint {

    public static final String RESOURCE_PATH = "/scoreboardCodes";

    private final ScoreboardUniqueNumberGeneratingFacade scoreboardUniqueNumberGeneratingFacade;

    @Autowired
    public ScoreboardCodeEndpoint(ScoreboardUniqueNumberGeneratingFacade scoreboardUniqueNumberGeneratingFacade) {
        this.scoreboardUniqueNumberGeneratingFacade = scoreboardUniqueNumberGeneratingFacade;
    }

    @PostMapping("/getNewCode")
    public ResponseEntity<String> getNewScoreboardCode() {
        final String scoreboardCode = this.scoreboardUniqueNumberGeneratingFacade.getIncrementedCode();
        return new ResponseEntity<>(scoreboardCode, HttpStatus.OK);
    }
}
