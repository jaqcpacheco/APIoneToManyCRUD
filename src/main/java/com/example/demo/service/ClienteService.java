package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.PedidoDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // converter para DTO
    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<PedidoDTO> pedidosDTO = cliente.getPedidos().stream().map(p -> {
            PedidoDTO pd = new PedidoDTO();
            pd.setId(p.getId());
            pd.setDescricao(p.getDescricao());
            pd.setClienteId(cliente.getId());
            return pd;
        }).collect(Collectors.toList());

        dto.setPedidos(pedidosDTO);

        return dto;
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public ClienteDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<ClienteDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Cliente atualizar(Long id, Cliente novo) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(novo.getNome());

        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
