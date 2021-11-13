package com.jocuriledelfinului.delfinul.services;

import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.factories.StrategyFactory;
import com.jocuriledelfinului.delfinul.strategies.Strategy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class UserService {

    StrategyFactory strategyFactory;

    public UserService(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public Mono<List<List<Terrain>>> generateBoard(int size, String strategyName) {
        Strategy strategy = strategyFactory.getByName(strategyName);
        return Mono.just(strategy.makeTable(size));
    }

}
