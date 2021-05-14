package com.kg.idiomknowledgegraph.service.serviceImpl;

import com.kg.idiomknowledgegraph.service.LaoziService;
import com.kg.idiomknowledgegraph.bean.Daodejing;
import com.kg.idiomknowledgegraph.dao.DaodejingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaoziServiceImpl implements LaoziService {

    @Autowired
    private DaodejingDao daodejingDao;

    @Override
    public Daodejing getDaodejing(int chapter) {
        return daodejingDao.getByChapter(chapter);
    }

}
