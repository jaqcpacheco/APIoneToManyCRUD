package com.example.demo.dto;

import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private List<PedidoDTO> pedidos;

    public ClienteDTO() {}

    // GETTERS e SETTERS:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
