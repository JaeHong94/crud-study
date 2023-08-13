package com.example.shoptest.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "count")
  private int count;

  @Builder
  public ShopEntity(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public void update(String name, int count) {
    this.name = name;
    this.count = count;
  }
}
