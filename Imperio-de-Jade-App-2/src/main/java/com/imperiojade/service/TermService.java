package com.imperiojade.service;

import com.imperiojade.dto.TermDTO;
import com.imperiojade.dto.TermUpdateDTO;
import com.imperiojade.entity.Term;
import com.imperiojade.repository.TermRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermService {

    private final TermRepository repository;

    public TermService(TermRepository repository) {
        this.repository = repository;
    }

    public List<TermDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TermDTO findByIdDTO(Long id) {
        Term term = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Term not found"));
        return toDTO(term);
    }

    public TermDTO saveDTO(TermDTO dto) {
        Term term = toEntity(dto);
        Term saved = repository.save(term);
        return toDTO(saved);
    }

    public TermDTO updateDTO(Long id, TermUpdateDTO dto) {
        Term term = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Term not found"));

        // Atualiza apenas os campos enviados
        if (dto.name() != null && !dto.name().isBlank()) {
            term.setName(dto.name());
        }
        if (dto.description() != null && !dto.description().isBlank()) {
            term.setDescription(dto.description());
        }

        Term updated = repository.save(term);
        return toDTO(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Conversões
    private Term toEntity(TermDTO dto) {
        return Term.builder()
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private TermDTO toDTO(Term entity) {
        return new TermDTO(entity.getName(), entity.getDescription());
    }}