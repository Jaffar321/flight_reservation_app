package com.flight_reservation_app.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

	boolean login(String username, String password);
}
