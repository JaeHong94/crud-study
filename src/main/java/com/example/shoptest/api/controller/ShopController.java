package com.example.shoptest.api.controller;

import com.example.shoptest.api.request.UpdateShopRequest;
import com.example.shoptest.api.response.ShopResponse;
import com.example.shoptest.domain.entity.ShopEntity;
import com.example.shoptest.api.request.ShopRequest;
import com.example.shoptest.application.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.shoptest.api.response.ShopResponse.toDto;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequiredArgsConstructor
public class ShopController {

  private final ShopService shopService;

  // 상품 생성
  @PostMapping("/goods")
  public ResponseEntity<ShopEntity> addGoods(@RequestBody ShopRequest request) {
    ShopEntity shop = shopService.save(request.name(), request.count());
    return ResponseEntity.status(HttpStatus.CREATED).body(shop);
  }

  // 상품 제거
  @DeleteMapping("/goods/{id}")
  public ResponseEntity<Boolean> deleteGoods(@PathVariable long id) {
    shopService.delete(id);
    return ResponseEntity.ok(true);
  }

  // 상품 조회
  @GetMapping("/goods/{id}")
  public ResponseEntity<ShopResponse> findShop(@PathVariable long id) {
    ShopEntity shop = shopService.findById(id);
    return ResponseEntity.ok().body(new ShopResponse(shop.getId(), shop.getName(), shop.getCount()));
  }

  // 상품 수정
  @PutMapping("/goods/{id}")
  public ResponseEntity<ShopEntity> updateShop(@PathVariable long id, @RequestBody UpdateShopRequest request) {
    ShopEntity shop = shopService.update(id, request);

    return ResponseEntity.ok().body(shop);
  }

  @GetMapping("/goods")
  public ResponseEntity<List<ShopResponse>> findAllGoods() {
    List<ShopResponse> shop = shopService.findAll()
            .stream()
            .map(ShopResponse::toDto)
            .toList();

    return ResponseEntity.ok().body(shop);
  }

}
