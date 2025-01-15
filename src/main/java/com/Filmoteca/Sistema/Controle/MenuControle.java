package com.Filmoteca.Sistema.Controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class MenuControle {

    @Controller
    public class MenuController {

        @GetMapping("/")
        public String home() {
            return "index";
        }
    }


}
