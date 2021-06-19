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


@Setter
@Getter
@Builder
@ToString
public class Account {  
    private int id;
    private String account;
    private String password;
    private String displayName;
    private String roll;
}
