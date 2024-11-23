package com.lime.backend.controller;


import com.lime.backend.entity.Page;
import com.lime.backend.entity.PageDTO;
import com.lime.backend.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("page")
@CrossOrigin("*")
public class PageController {

    @Autowired
    private PageService pageService;


    @GetMapping
    @RequestMapping("all")
    public ResponseEntity<?> showAllPages() {
        return pageService.showPages();
    }


    @PostMapping
    @RequestMapping("/new")
    public ResponseEntity<?> postNewPage(@RequestBody PageDTO newPage) {
        return pageService.addNewPage(newPage);
    }

}
