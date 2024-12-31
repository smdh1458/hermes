package com.hermes.hermes.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private int product_reg_num;
    private String product_name;
    private int product_price;
    private String product_description;
    private String product_image_path;
    private String product_category;
    private int product_size;
}
