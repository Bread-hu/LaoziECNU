package com.laozi.service.serviceImpl;

import com.laozi.dao.GbookDao;
import com.laozi.entity.book.Gbook;
import com.laozi.service.GbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GbookServiceImpl implements GbookService {
    @Autowired
    private GbookDao gbookDao;

    @Override
    public List<Gbook> getRootBooks(){
        return gbookDao.getRootBooks();
    }

    @Override
    public List<Gbook> getBooks(String parName){
        return gbookDao.getGBooksByParName(parName);
    }

    @Override
    public List<Gbook> getBookInfo(String bookname) {
        return gbookDao.getGbookEntityByName(bookname);
    }
}
