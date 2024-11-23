package com.lime.backend.service;

import com.lime.backend.entity.Page;
import com.lime.backend.entity.PageDTO;
import com.lime.backend.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public ResponseEntity<?> showPages() {
        List<Page> pages = pageRepository.findAll();
        return ResponseEntity.ok(pages);
    }

    public ResponseEntity<?> addNewPage(PageDTO data) {

        Page newPage = new Page(data.id(), data.title(), data.content());
        pageRepository.save(newPage);
        return ResponseEntity.ok().build();
    }

}
