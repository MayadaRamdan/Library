package com.Library.admin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "admin")
@Getter
@Setter
@RequiredArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "admin_role" ,
//            joinColumns =@JoinColumn(name = "admin_id" , referencedColumnName = "id") ,
//            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id")
//    )
//    private Set<Role> roles;


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                //", role='" + roles + '\'' +
                '}';
    }
}
