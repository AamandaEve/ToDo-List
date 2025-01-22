package com.junior.todolist.mappers;

import com.junior.todolist.model.dtos.TarefaDTO;
import com.junior.todolist.model.entities.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);

    Tarefa toEntity(TarefaDTO tarefaDTO);

    TarefaDTO toDTO(Tarefa tarefa);

}
