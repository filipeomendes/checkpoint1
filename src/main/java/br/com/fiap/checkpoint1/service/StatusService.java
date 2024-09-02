package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.status.StatusDto;
import br.com.fiap.checkpoint1.model.Status;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    public List<StatusDto> listarStatus() {
        return Arrays.stream(Status.values())
                .map(status -> new StatusDto(status.name()))
                .collect(Collectors.toList());
    }
}