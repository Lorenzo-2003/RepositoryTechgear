package com.techgear.pago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgear.pago.model.Factura;
import com.techgear.pago.service.FacturaService;

@RestController
@RequestMapping("/api/factura")

public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping()
    public ResponseEntity<List<Factura>> obtenerFacturas(){
        try {
            List<Factura>facturas = facturaService.getAllFacturas();
            if (facturas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(facturas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable("id")int id){
        try {
            Factura factura = facturaService.getFactura(id);
            if (factura==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(factura);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Factura> insertarFactura(@RequestBody Factura factura){
        try {
            Factura newFactura = facturaService.saveFactura(factura);
            return ResponseEntity.ok(newFactura);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping()
    public ResponseEntity<Factura> actualizarFactura(@RequestBody Factura factura){
        try {
            Factura updFactura = facturaService.updateFactura(factura);
            if (updFactura==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updFactura);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable("id")int id){
        try {
            boolean deleteFact = facturaService.deleteFactura(id);
            if (deleteFact) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
