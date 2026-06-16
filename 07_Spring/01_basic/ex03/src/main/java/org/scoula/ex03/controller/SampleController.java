package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("")
    public void basic() {
        log.info("basic...........");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get.........");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get..............");
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        return "sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05........");
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes redirect) {
        redirect.addAttribute("name", "AAA");
        redirect.addAttribute("age", 10);
        return "redirect:/sample/ex06-2";
    }

    @GetMapping("/ex01")
    public void ex01(SampleDTO dto) {
        log.info(dto.toString());
    }

    @GetMapping("/ex02")
    public void ex02(String name, int age) {
        log.info(name);
        log.info(age);
    }

    @GetMapping("/ex02List")
    public void ex02List(ArrayList<String> ids, String[] ids2) {
        log.info(ids.toString());
        log.info(Arrays.toString(ids2));
    }

    @GetMapping("/ex03")
    public void ex03(TodoDTO dto) {
        log.info(dto.toString());
    }
}
