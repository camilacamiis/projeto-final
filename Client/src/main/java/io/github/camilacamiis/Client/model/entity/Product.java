package io.github.camilacamiis.Client.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data

public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column
    private BigDecimal valor;


}
