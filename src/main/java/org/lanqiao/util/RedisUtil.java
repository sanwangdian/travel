package org.lanqiao.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class RedisUtil {
    public void setRedisCity(String cityName){
        Jedis jedis = new Jedis("39.96.55.109");
        System.out.println("连接成功");
        //加1
        jedis.zincrby("score",1,cityName);
    }
    public Set getRedisCity(){
        Jedis jedis = new Jedis("39.96.55.109");
        System.out.println("连接成功");

        //创建一个有序集合，用来存城市的访问排名。
//        jedis.zadd("score", 0, "厦门市");
//        jedis.zadd("score", 0, "北京市");
//        jedis.zadd("score", 0, "上海市");
//        jedis.zadd("score", 0, "福州市");

        //打印输出的list
        Set<Tuple> score1 = jedis.zrevrangeWithScores("score", 0, -1);
        for (Tuple t : score1) {
            System.out.println(t.getElement()+":"+t.getScore());
        }
        return score1;
    }

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("39.96.55.109");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

        new RedisUtil().setRedisCity("福州市");
        new RedisUtil().getRedisCity();

        //创建一个有序集合，用来存城市的访问排名。
        jedis.zadd("score", 0, "厦门市");
        jedis.zadd("score", 0, "北京市");
        jedis.zadd("score", 0, "上海市");
        jedis.zadd("score", 0, "福州市");
        System.out.println("城市获取到的"+jedis.zrange("score", 0, -1)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }
}
