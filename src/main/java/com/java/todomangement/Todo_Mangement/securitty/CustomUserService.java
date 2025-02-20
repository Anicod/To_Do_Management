package com.java.todomangement.Todo_Mangement.securitty;

import com.java.todomangement.Todo_Mangement.entity.User;
import com.java.todomangement.Todo_Mangement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernameOREmail) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrEmail(usernameOREmail, usernameOREmail).orElseThrow(()->new UsernameNotFoundException("user not exsist"));
        Set<GrantedAuthority> authoritis = user.getRoleSet().stream().map((m)->new SimpleGrantedAuthority(m.getName())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(usernameOREmail, null, authoritis);
    }
}
