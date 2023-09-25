package com.centralplatform.server.service.Route;

import com.centralplatform.server.repository.Route.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository repository;
}
