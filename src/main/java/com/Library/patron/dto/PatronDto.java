package com.Library.patron.dto;

import com.Library.patron.entity.Patron;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatronDto {

    private long id ;
    private String name ;
    private String phone ;
    private String email ;
    private String address;


    public static PatronDto toPatronDto(Patron patron){
        return PatronDto.builder()
                .id(patron.getId())
                .name(patron.getName())
                .phone(patron.getPhone())
                .email(patron.getEmail())
                .address(patron.getAddress())
                .build();

    }


}
