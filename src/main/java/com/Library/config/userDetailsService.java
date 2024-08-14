package com.Library.config;

//
//import com.Library.admin.entity.Admin;
//import com.Library.admin.repo.AdminRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class userDetailsService implements UserDetailsService {
//
//        @Autowired
//        AdminRepo adminRepo;
//
//        @Override
//        public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
//
//            Admin admin = adminRepo.findByEmail(email);
//            if (admin == null) {
//                throw  new UsernameNotFoundException("user  not found for email : " + email);
//            }
//                return new org.springframework.security.core.userdetails.User(
//                        admin.getEmail(),
//                         admin.getPassword(),
//                        admin.getRoles());
//
//        }
//
////    Customer customer= customerRepo.findByEmail(email).orElseThrow(()-> new
////            UsernameNotFoundException("user details not found for the user : " +email)  );
////
////       if (customer !=null){
////        return User.withUsername(customer.getEmail())
////                .password("{noop}"+customer.getPassword())
////                .roles(customer.getRole())
////                .build();
////    }
////
////        return null;
//
//}







