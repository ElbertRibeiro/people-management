/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.digitalinnovation.personapi.dto.response;

import lombok.Builder;
import lombok.Data;



/**
 *
 * @author elbertnilton
 */

@Data
@Builder
public class MessageResponseDTO {
    private String message;
}
