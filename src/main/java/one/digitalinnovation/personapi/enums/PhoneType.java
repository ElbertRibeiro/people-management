/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 *
 * @author elbertnilton
 */
@Getter
@AllArgsConstructor

public enum PhoneType {
    HOME("Home"),
    MOBILE("Mobile"), 
    COMMERCIAL("Commercial");
    
    private final String description;
}
