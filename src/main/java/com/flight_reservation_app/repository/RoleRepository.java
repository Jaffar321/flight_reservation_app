package com.flight_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
