/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Setter
@Getter
@ToString
public class OrderDetail {    
    private int orderId;
    private int productId;
    private String productName;
    private double productPrice;
    private String img_name;
    private int quantity;
}
