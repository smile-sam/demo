package com.example.demo.logext;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MyLogbackPatternConverter extends ClassicConverter {
    public MyLogbackPatternConverter() {
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        return "TID: N/A";
    }
}
