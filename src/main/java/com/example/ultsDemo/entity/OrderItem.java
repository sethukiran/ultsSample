package com.example.ultsDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import jakarta.validation.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;
  @Column(nullable = false)
  @NotBlank(message = "Product code must not be empty")
  private String productCode;
  @Column(nullable = false)
  @NotNull(message = "Quantity must be provided")
  @Min(value = 1, message = "Quantity must be positive")
  private Integer quantity;
  @Column(nullable = false)
  @NotNull(message = "Unit price must be provided")
  @DecimalMin(value = "0.01", inclusive = true, message = "Unit price must be positive")
  private BigDecimal unitPrice;

  public OrderItem(
      @NotBlank(message = "Product code must not be empty") String productCode,
      @NotNull(message = "Quantity must be provided") @Min(value = 1, message = "Quantity must be positive") Integer quantity,
      @NotNull(message = "Unit price must be provided") @DecimalMin(value = "0.01", inclusive = true, message = "Unit price must be positive") BigDecimal unitPrice) {
    this.productCode = productCode;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }
}