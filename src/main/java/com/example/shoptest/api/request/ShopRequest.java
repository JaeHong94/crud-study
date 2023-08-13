package com.example.shoptest.api.request;

import com.example.shoptest.domain.entity.ShopEntity;

public record ShopRequest(String name, int count) {

  public ShopEntity toEntity(String name, int count) {
    return ShopEntity.builder()
            .name(name)
            .count(count)
            .build();
  }

}
