package com.example.demo.service;

import com.example.demo.dto.PedidoDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Pedido;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido salvar(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.getDescricao());
        pedido.setCliente(cliente);

        return repository.save(pedido);
    }

    public PedidoDTO buscarPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setDescricao(pedido.getDescricao());
        dto.setClienteId(pedido.getCliente().getId());

        return dto;
    }

    public Pedido atualizar(Long id, PedidoDTO dto) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setDescricao(dto.getDescricao());

        return repository.save(pedido);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
