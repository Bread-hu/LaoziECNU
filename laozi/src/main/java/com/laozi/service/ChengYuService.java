package com.laozi.service;

import com.laozi.entity.chengyu.ChengYu;
import com.laozi.entity.chengyu.ChengYuMini;
import com.laozi.entity.chengyu.ChengYuRelation;

import java.util.List;

public interface ChengYuService {

     List<ChengYuMini> getIdiomsByFirstPhonetic(String firstPhonetic);
     ChengYu getIdiomById(int id);
     ChengYuRelation getRelation(String name);
}
