package com.example.numbergenerator;

import com.example.numbergenerator.service.ScoreboardUniqueNumberGeneratingFacade;
import com.example.numbergenerator.service.ScoreboardUniqueNumberGeneratingFacadeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberGeneratorApplicationTests {

    public ScoreboardUniqueNumberGeneratingFacade scoreboardUniqueNumberGeneratingFacade
            = new ScoreboardUniqueNumberGeneratingFacadeImpl();

    @Test
    public void testIncrementCodeBorderValues() {
        Assertions.assertEquals("c0a0a0a0a0", scoreboardUniqueNumberGeneratingFacade.incrementCode("b9z9z9z9z9"));
        Assertions.assertEquals("a0a0a0a0", scoreboardUniqueNumberGeneratingFacade.incrementCode("z9z9z9"));
        Assertions.assertEquals("a0a0a0a0a0a0a0", scoreboardUniqueNumberGeneratingFacade.incrementCode("z9z9z9z9z9z9"));
        Assertions.assertEquals("b1d0", scoreboardUniqueNumberGeneratingFacade.incrementCode("b1c9"));
        Assertions.assertEquals("b2a0", scoreboardUniqueNumberGeneratingFacade.incrementCode("b1z9"));
        Assertions.assertEquals("b2b0", scoreboardUniqueNumberGeneratingFacade.incrementCode("b2a9"));
    }

}
