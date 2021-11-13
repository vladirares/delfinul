package com.jocuriledelfinului.delfinul.controllers;

import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/public/")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("generate/board")
    public Mono<List<List<Terrain>>> generateBoard(@PathParam("size") Integer size, @PathParam("strategy") String strategy) {
        Logger.getLogger(UserController.class.getName()).info("generated board ");
        return userService.generateBoard(size, strategy);
    }
}
