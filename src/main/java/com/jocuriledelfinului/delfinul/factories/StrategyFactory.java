package com.jocuriledelfinului.delfinul.factories;

import com.jocuriledelfinului.delfinul.strategies.DefaultStrategy;
import com.jocuriledelfinului.delfinul.strategies.Strategy;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StrategyFactory {
    private final List<Strategy> strategies = List.of(new DefaultStrategy());
    public static final Strategy DEFAULT_STRATEGY = new DefaultStrategy();

    public Strategy getByName(String strategyName) {
        return strategies.stream()
                .filter(s -> s.NAME.name().compareToIgnoreCase(strategyName) == 0).findFirst()
                .orElse(DEFAULT_STRATEGY);
    }

}
