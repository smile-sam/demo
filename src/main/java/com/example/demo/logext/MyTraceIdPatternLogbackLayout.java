package com.example.demo.logext;

import ch.qos.logback.classic.PatternLayout;
import org.apache.skywalking.apm.toolkit.log.logback.v1.x.LogbackPatternConverter;

public class MyTraceIdPatternLogbackLayout extends PatternLayout {
    public MyTraceIdPatternLogbackLayout() {
    }

    static {
        defaultConverterMap.put("mytid", MyLogbackPatternConverter.class.getName());
        defaultConverterMap.put("tid", LogbackPatternConverter.class.getName());
    }
}
