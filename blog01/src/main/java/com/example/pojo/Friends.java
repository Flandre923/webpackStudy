package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friends {
    private String friendname;
    private String frienddesc;
    private String friendurl;
    private String friendavatar;
    private Integer id;
}
