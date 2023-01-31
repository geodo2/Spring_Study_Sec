package com.example.test_project_sec.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "short_url")
public class ShortUrlEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  @Column(nullable = false, unique = true)
  private String hash;

  @Column(nullable = false, unique = true)
  private String url;

  @Column(nullable = false, unique = true)
  private String orgUrl;

}