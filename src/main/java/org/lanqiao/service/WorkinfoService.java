package org.lanqiao.service;

import org.lanqiao.entity.Workinfo;

import java.util.List;

public interface WorkinfoService {
    List<Workinfo> selectWorkContent(int workId);

    int insertOne(Workinfo workinfo);

    List<Workinfo> selectByWorkId(int workId);




}
