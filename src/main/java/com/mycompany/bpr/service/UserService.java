/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.service;

import com.mycompany.bpr.entity.security.RoleSecurity;
import com.mycompany.bpr.entity.security.UserSecurity;
import com.mycompany.bpr.repository.RoleRepository;
import com.mycompany.bpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author bubun
 */
@Repository
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserSecurity findById(String id) {
        return this.userRepository.findOne(id);
    }

    public List<RoleSecurity> listRole() {
        return this.roleRepository.findAll();
    }

    public List<UserSecurity> findUsers() {
        return this.userRepository.findAll();
    }

    public UserSecurity findByUsername(String username) {
        return this.userRepository.findByName(username);
    }

    @Transactional
    public UserSecurity save(UserSecurity user) {
        return this.userRepository.save(user);
    }

}
