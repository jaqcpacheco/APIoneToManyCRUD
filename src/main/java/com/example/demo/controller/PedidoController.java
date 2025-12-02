package com.example.demo.controller;

import com.example.demo.dto.PedidoDTO;
import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido criar(@RequestBody PedidoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
