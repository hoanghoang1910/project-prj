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
public class Order {
    
    private int id;
    private String name;
    private String mobile;
    private String address;
    private double totalPrice;
    private String note;
    private int status;
}
