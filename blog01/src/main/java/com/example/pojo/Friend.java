package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String friendname;
    private String frienddesc;
    private String friendurl;
    private String friendavatar;
    @TableId(type = IdType.AUTO)
    private Integer id;
}
