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

import com.techgear.pago.model.Fpago;
import com.techgear.pago.service.FpagoService;

@RestController
@RequestMapping("/fpago")

public class FpagoController {

    @Autowired
    private FpagoService fpagoService;

    @GetMapping()
    public ResponseEntity<List<Fpago>> obtenerFpagos(){
        try {
            List<Fpago>fpagos = fpagoService.getAllFpagos();
            if (fpagos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(fpagos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fpago> obtenerUsuario(@PathVariable("id")int id){
        try {
            Fpago fpago = fpagoService.getFpago(id);
            if (fpago==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(fpago);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Fpago> insertarUsuario(@RequestBody Fpago fpago){
        try {
            Fpago newFpago = fpagoService.saveFpago(fpago);
            return ResponseEntity.ok(newFpago);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping()
    public ResponseEntity<Fpago> actualizarUsuario(@RequestBody Fpago fpago){
        try {
            Fpago updFpago = fpagoService.updateFpago(fpago);
            if (updFpago==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updFpago);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id")int id){
        try {
            boolean delFpago = fpagoService.deleteFpago(id);
            if (delFpago) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
