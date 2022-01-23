package com.jocuriledelfinului.delfinul.controllers;

import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestMapping("/public/")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("generate/board")
    public Mono<List<List<Terrain>>> generateBoard(@PathParam("size") Integer size, @PathParam("strategy") String strategy) {
        Logger.getLogger(UserController.class.getName()).info("generated board ");
        return Optional.ofNullable(strategy)
                .map(strat -> userService.generateBoard(size,strat))
                .orElse(userService.generateBoard(size,""));
    }

    @GetMapping("generate/ceva")
    public Mono<List<List<Terrain>>> generateBoardCeva(@PathParam("size") Integer size, @PathParam("strategy") String strategy) {
        Logger.getLogger(UserController.class.getName()).info("generated board ");
        return Optional.ofNullable(strategy)
                .map(strat -> userService.generateBoard(10,strat))
                .orElse(userService.generateBoard(size,""));
    }


}
