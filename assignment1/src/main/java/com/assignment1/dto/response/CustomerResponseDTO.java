package com.assignment1.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
    private String firstName;
    private String lastName;
    private String email ;
    private String address1;
    private String address2 ;
    private String phoneNumber;
    private String city ;
}
