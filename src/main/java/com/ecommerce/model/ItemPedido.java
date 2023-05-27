package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
    private Long id;
    private Produto produto;
    private int quantidade;
}
