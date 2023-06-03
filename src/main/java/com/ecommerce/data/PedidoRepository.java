package com.ecommerce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
