package com.laozi.service;

import com.laozi.entity.daodejing.Daodejing;
import com.laozi.entity.daodejing.DaodejingIdiom;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DaodejingService {

    public DaodejingIdiom getIdiom(int id);

    public Daodejing getDaodejing(int chapter);

    public List<Map<String,Object>> searchContentHighlighter(String keywords) throws IOException;
}
