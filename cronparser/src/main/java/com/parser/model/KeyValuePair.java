package com.parser.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class KeyValuePair {
    private final String key;
    @Setter
    private String parsedValue;

    public KeyValuePair(String key) {
        this.key = key;
    }
}
