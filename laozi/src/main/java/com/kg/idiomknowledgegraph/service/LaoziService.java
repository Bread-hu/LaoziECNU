package com.kg.idiomknowledgegraph.service;

import com.kg.idiomknowledgegraph.entity.Daodejing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LaoziService {

    public Daodejing getDaodejing(int chapter);

    public List<Map<String,Object>> searchContentHighlighter(String keywords) throws IOException;
}
