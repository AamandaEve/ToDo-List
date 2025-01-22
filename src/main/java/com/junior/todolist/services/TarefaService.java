package com.junior.todolist.services;

import com.junior.todolist.model.dtos.TarefaDTO;
import com.junior.todolist.model.entities.Tarefa;

import java.util.List;
import java.util.UUID;

public interface TarefaService {

    List<TarefaDTO> list();

    List<TarefaDTO> mostrarTarefas();

    List<TarefaDTO> salvar(TarefaDTO tarefaDTO);

    List<TarefaDTO>  editarPorId(UUID id, TarefaDTO tarefaDTO);

    List<TarefaDTO>  deletarPorId(UUID id);

}
