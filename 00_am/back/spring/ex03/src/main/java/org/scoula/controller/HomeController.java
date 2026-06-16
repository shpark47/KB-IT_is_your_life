package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        log.info("================> 첫 페이지 호출 /");
        model.addAttribute("name", "hong");
        return "index"; // View의 이름
    }
}
