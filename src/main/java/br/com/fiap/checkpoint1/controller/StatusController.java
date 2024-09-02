package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.status.StatusDto;
import br.com.fiap.checkpoint1.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/status")
    public ResponseEntity<List<StatusDto>> listarStatus() {
        List<StatusDto> status = statusService.listarStatus();
        return ResponseEntity.ok(status);
    }
}