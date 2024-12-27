package com.hermes.hermes.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Purchase {
    private int purchase_reg_num;
    private String purchase_id;
    private int purchase_product_size;
    private String purchase_user_id;
    private Date purchase_date;
    private String purchase_status;

}
