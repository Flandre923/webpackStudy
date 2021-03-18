package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anime {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String animename;
    private String animeoriginname;
    private String animedesc;
    private String animeimg;
    private Integer animeprogress;
}
