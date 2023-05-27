package com.ecommerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
    private Long id;
    private Produto produto;
    private int quantidade;
}
