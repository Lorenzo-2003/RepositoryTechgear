package com.techgear.pago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techgear.pago.model.Factura;
import com.techgear.pago.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }

    public Factura getFactura(int id){
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura saveFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura updateFactura(Factura factura){
        Factura updFact = getFactura(factura.getId());
        if (updFact==null) {
            return null;
        }
        updFact.setFormaPago(factura.getFormaPago());
        updFact.setMonto(factura.getMonto());
        updFact.setFecha(factura.getFecha());
        
        return facturaRepository.save(updFact);
    }

    public boolean deleteFactura(int id){
        Factura delFact = getFactura(id);
        if(delFact==null){
            return false;
        }
        facturaRepository.delete(delFact);
        return true;
    }
}
