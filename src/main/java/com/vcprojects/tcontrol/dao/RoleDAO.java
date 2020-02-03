package com.vcprojects.tcontrol.dao;

import com.vcprojects.tcontrol.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
