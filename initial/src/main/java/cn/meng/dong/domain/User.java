package cn.meng.dong.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;

    private Date createAt;

    private Date updateAt;

    private String name;

    private Integer age;

    private Integer sex;

    private String email;
}
