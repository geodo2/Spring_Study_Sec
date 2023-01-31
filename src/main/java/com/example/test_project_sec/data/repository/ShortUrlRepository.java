package com.example.test_project_sec.data.repository;

import com.example.test_project_sec.data.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
  ShortUrlEntity findByUrl(String url);

  ShortUrlEntity findByOrgUrl(String originalUrl);
}
