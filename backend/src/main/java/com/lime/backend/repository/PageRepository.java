package com.lime.backend.repository;

import com.lime.backend.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page,Integer> {
}

