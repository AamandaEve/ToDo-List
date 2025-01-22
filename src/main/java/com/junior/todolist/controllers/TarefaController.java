package com.junior.todolist.controllers;

import com.junior.todolist.model.dtos.TarefaDTO;
import com.junior.todolist.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public List<TarefaDTO> salvar(@RequestBody TarefaDTO tarefaDTO){
        return service.salvar(tarefaDTO);
    }

    @GetMapping
    public List<TarefaDTO> mostrarTodos(){
        return service.mostrarTarefas();
    }

    @PutMapping("/{id}")
    public List<TarefaDTO> editarTarefaPorId(@PathVariable UUID id, @RequestBody @Valid TarefaDTO tarefaDTO){
        return service.editarPorId(id, tarefaDTO);
    }

    @DeleteMapping("/{id}")
    public List<TarefaDTO> deletarPorId(@PathVariable UUID id){
        return service.deletarPorId(id);
    }
}
