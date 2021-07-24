package com.cya.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    String goodsId;
    String pic;
    String descs;
    Date times;
    String place;
    String userId;
    Date releaseTime;
    String label;
    String typeTable;
}
