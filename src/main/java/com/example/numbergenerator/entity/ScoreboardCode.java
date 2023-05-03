package com.example.numbergenerator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ScoreboardCode {

    @Id
    @SequenceGenerator(name = "scoreboardCode_id_sequence",
                       sequenceName = "scoreboardCode_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "scoreboardCode_id_sequence")
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

