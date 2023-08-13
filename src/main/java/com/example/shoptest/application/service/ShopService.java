package com.example.shoptest.application.service;

import com.example.shoptest.api.request.UpdateShopRequest;
import com.example.shoptest.domain.entity.ShopEntity;
import com.example.shoptest.api.request.ShopRequest;
import com.example.shoptest.domain.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

  private final ShopRepository shopRepository;

  public ShopEntity save(String name, int count) {
    ShopEntity shop = new ShopRequest(name, count).toEntity(name, count);
    shopRepository.save(shop);
    return shop;
  }

  public void delete(Long id) {
    Optional<ShopEntity> shop = shopRepository.findById(id);
    shopRepository.delete(shop.get());
  }

  public ShopEntity findById(long id) {
    return shopRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("not fount: " + id));
  }

  @Transactional
  public ShopEntity update(long id, UpdateShopRequest request) {
    ShopEntity shop = shopRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not fount: " + id));

    shop.update(request.name(), request.count());

    return shop;
  }

  public List<ShopEntity> findAll() {
    return shopRepository.findAll();
  }
}
