package org.lanqiao.service.impl;

import org.lanqiao.entity.Workinfo;
import org.lanqiao.mapper.WorkinfoMapper;
import org.lanqiao.service.WorkinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkinfoServiceImpl implements WorkinfoService {
    @Resource
    WorkinfoMapper workinfoMapper;
    @Override
    public List<Workinfo> selectWorkContent(int workId) {
        return workinfoMapper.selectWorkContent(workId);
    }

    @Override
    public int insertOne(Workinfo workinfo) {
        if (workinfo.getIsCover().equals("y")) {
            workinfoMapper.updateWorkCover(workinfo);
        }
        return workinfoMapper.insertOne(workinfo);
    }

    @Override
    public List<Workinfo> selectByWorkId(int workId) {
        return workinfoMapper.selectByWorkId(workId);
    }

}
