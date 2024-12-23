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

    public ResponseEntity<?> updatePage(Integer id, PageDTO updatedPage) {

        Page existingPage = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Página não encontrada com ID: " + id));

        existingPage.setTitle(updatedPage.title());
        existingPage.setContent(updatedPage.content());

        pageRepository.save(existingPage);
        return ResponseEntity.ok("Página atualizada com sucesso!");
    }

    public ResponseEntity<?> deletePage(Integer id) {

        Page existingPage = pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado!"));

        pageRepository.delete(existingPage);

        return ResponseEntity.ok("Página deletada com sucesso");
    }

}
