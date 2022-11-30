package com.skyx.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyx.user.entity.Status;

public interface StatusRepository extends JpaRepository<Status,Long> {

}
