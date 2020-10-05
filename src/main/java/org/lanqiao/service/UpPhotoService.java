package org.lanqiao.service;

import org.lanqiao.entity.Work;

import java.util.List;

public interface UpPhotoService {
    public int insertIntoWork(Work work);

    public List<Work> selectBydefault();

    public List<Work> selectBydTime();

    public List<Work> selectByHot();

    public List<Work> selectHisWork(int userId);

    public Work selectThisWork(int workId);

    public List<Work> selectByTag(String tag);

    public Integer selectWorkId(Work work);

    Work selectByPrimaryKey(Integer workId);

    int updateTheWork(Work work);

    int deletWorkAndInfo(int workId);

    int  deleteWorkInfo(int workId);


}
