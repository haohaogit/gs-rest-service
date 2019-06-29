package cn.meng.dong.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Long id;

    private Date createAt;

    private Date updateAt;

    private String taskName;

    private String description;

    private Integer type;

    private Integer grade;
}
