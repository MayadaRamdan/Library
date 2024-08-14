package com.Library.patron.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "patron")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Min(3)
    @Max(15)
    private String name ;
    @NonNull
    private String phone ;
    @NonNull
    @Email(message = "not a email")
    private String email ;
    @NonNull
    private String address;


}
