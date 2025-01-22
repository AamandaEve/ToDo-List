package com.junior.todolist.services;

import com.junior.todolist.exceptions.NotFoundException;
import com.junior.todolist.mappers.TarefaMapper;
import com.junior.todolist.model.dtos.TarefaDTO;
import com.junior.todolist.model.entities.Tarefa;
import com.junior.todolist.model.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TarefaServiceImpl implements TarefaService{

    private final TarefaRepository repository;

    private final TarefaMapper mapper;

    public TarefaServiceImpl(TarefaMapper mapper, TarefaRepository repository){
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<TarefaDTO> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return repository.findAll(sort).stream().map(TarefaMapper.INSTANCE::toDTO).toList();
    }

    @Override
    public List<TarefaDTO> mostrarTarefas() {
        return list();

    }

    @Override
    public List<TarefaDTO>  salvar(TarefaDTO tarefaDTO) {
        tarefaDTO.setId(null);
        Tarefa tarefa = TarefaMapper.INSTANCE.toEntity(tarefaDTO);
        repository.save(tarefa);
        return list();
    }

    @Override
    public List<TarefaDTO>  editarPorId(UUID id, TarefaDTO tarefaDTO) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new NotFoundException("Tarefa não encontrada"));
        Tarefa entity = mapper.toEntity(tarefaDTO);

        entity.setId(tarefa.getId());
        repository.save(entity);

        return list();
    }

    @Override
    public List<TarefaDTO>  deletarPorId(UUID id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Tarefa não encontrada"));
        repository.deleteById(id);
        return list();

    }
}
