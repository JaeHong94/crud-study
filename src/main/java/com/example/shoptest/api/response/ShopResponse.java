package com.example.shoptest.api.response;

import com.example.shoptest.domain.entity.ShopEntity;

public record ShopResponse(long id, String name, int count) {


  public static ShopResponse toDto(ShopEntity shop) {
    return new ShopResponse(shop.getId(), shop.getName(),shop.getCount());
  }
}
