package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    public int id;
    public String name;
    public String email;
    public String theme;
    public String msgContent;
    public LocalDateTime sendTime;
}
