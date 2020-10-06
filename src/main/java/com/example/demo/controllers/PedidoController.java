package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Pedido;
import com.example.demo.repository.PedidoRepository;

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

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Pedido>> getPedidos(){
        List<Pedido> pedidos = repository.getAllPedidos();
        if(pedidos != null)
            return ResponseEntity.ok(pedidos);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pedido> inserirPedido(@RequestBody Pedido pedidoCadastar){
        Pedido pedido = repository.savePedido(pedidoCadastar);
        if(pedido != null)
            return ResponseEntity.ok(pedido);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int codigo){
        Pedido pedido = repository.getPedidosById(codigo);
        return verificaBusca(pedido);
    }

    @PutMapping("")
    public ResponseEntity<Pedido> editPedidoById(@RequestBody Pedido pedidoAlterado){
        Pedido pedido = repository.editPedido(pedidoAlterado, pedidoAlterado.getCodigo());
        return verificaBusca(pedido);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pedido> deletePedidoById(@PathVariable int codigo){
        Pedido pedido = repository.deletePedidoById(codigo);
        return verificaBusca(pedido);
    }

    private ResponseEntity<Pedido> verificaBusca(Pedido pedido) {
        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

}
