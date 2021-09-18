/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elbertnilton
 */

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
    @GetMapping
    public String getBook(){
        return "API teste";
    }
}
