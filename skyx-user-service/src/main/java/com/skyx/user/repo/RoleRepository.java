package com.skyx.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyx.user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
