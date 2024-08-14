package com.Library.admin.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.awt.font.GraphicAttribute;
//import java.util.Set;
//
//@Entity
//@Table(name = "role")
//@Setter
//@Getter
//public class Role implements GrantedAuthority {
//
//    private static final long serialVersionUID=1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private Set<Admin> Admins;
//
//    @Override
//    public String getAuthority() {
//        return name;
//    }
//}
