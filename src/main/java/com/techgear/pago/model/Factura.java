package com.techgear.pago.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int usuarioId;

    @Column(nullable = false)
    private int carroId;

    @ManyToOne
    @JoinColumn(name = "fpago_id", nullable = false)
    private Fpago formaPago;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private double monto;

}
