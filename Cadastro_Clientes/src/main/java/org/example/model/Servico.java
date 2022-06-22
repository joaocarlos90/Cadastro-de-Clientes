package org.example.model;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String descricao;
    @ManyToOne //define as propiedades de relacionamento no BD
    @JoinColumn(name="id_cliente") //define chave estrangeira
    private Cliente cliente;
    @Column
    private BigDecimal valor;
}
