package org.lanqiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.lanqiao.entity.Person;
import org.lanqiao.mapper.PersonMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PersonController {

    @Resource
    private PersonMapper personMapper;

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable("id") Integer id){
        Person person = personMapper.getPerson(id);
        log.info("获取数据成功！！！");
        return person;
    }
}
