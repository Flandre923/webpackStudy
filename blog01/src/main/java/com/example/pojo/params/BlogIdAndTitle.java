package com.example.pojo.params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BlogIdAndTitle {
    private Long id;
    private String title;
}