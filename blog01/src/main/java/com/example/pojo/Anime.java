package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anime {
    private Integer id;
    private String animename;
    private String animeoriginname;
    private String animedesc;
    private String animeimg;
    private Integer animeprogress;
}
