package com.demon.dbserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static class DemoBean {
        private String name;
        private int id;

        public DemoBean(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    @GetMapping("/demo")
    public DemoBean demoMapping() {
        return new DemoBean("demo", 1);
    }
}
