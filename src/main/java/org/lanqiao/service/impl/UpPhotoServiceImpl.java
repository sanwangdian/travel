package org.lanqiao.service.impl;

import org.lanqiao.entity.Work;
import org.lanqiao.mapper.WorkMapper;
import org.lanqiao.service.UpPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UpPhotoServiceImpl implements UpPhotoService {
    @Resource
    WorkMapper workMapper;
    @Override
    public int insertIntoWork(Work work) {
        if(workMapper.insert(work) > 0){
            return workMapper.selectWorkId(work);
        }
        return 0;
    }

    @Override
    public List<Work> selectBydefault() {
        return workMapper.selectBydefault();
    }

    @Override
    public List<Work> selectBydTime() {
        return workMapper.selectBydTime();
    }

    @Override
    public List<Work> selectByHot() {
        return workMapper.selectByHot();
    }

    @Override
    public List<Work> selectHisWork(int userId) {
        return workMapper.selectHisWork(userId);
    }

    @Override
    public Work selectThisWork(int workId) {
        return workMapper.selectThisWork(workId);
    }

    @Override
    public List<Work> selectByTag(String tag) {
        return workMapper.selectByTag(tag);
    }

    @Override
    public Integer selectWorkId(Work work) {
        return workMapper.selectWorkId(work);
    }

    @Override
    public Work selectByPrimaryKey(Integer workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    @Override
    public int updateTheWork(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public int deletWorkAndInfo(int workId) {

        workMapper.deleteWorkInfo(workId);

        workMapper.deleteByPrimaryKey(workId);

        return 1;
    }

    @Override
    public int deleteWorkInfo(int workId) {
        return workMapper.deleteWorkInfo(workId);
    }


}
