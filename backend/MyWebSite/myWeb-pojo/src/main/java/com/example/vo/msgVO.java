package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class msgVO {
    public int id;
    public String name;
    public String email;
    public String theme;
    public String msgContent;
}
