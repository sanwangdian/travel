package org.lanqiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyArticles {
    private Integer id;
    private String title;
    private Date createDate;
}
