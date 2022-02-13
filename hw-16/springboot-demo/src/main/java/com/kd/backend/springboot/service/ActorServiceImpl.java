package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.mapper.ActorMapper;
import com.kd.backend.springboot.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActorServiceImpl implements ActorService{
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private ActorMapper actorMapper;

    @Override
    public ActorDTO getActorById(Long id) {
        return actorRepository.findById(id).map(actorMapper::fromEntity).orElse(null);
    }

    @Override
    public ActorDTO createActor(ActorDTO actorDTO) {
        actorRepository.findAll();
        return actorMapper.fromEntity(actorRepository.save(actorMapper.toEntity(actorDTO)));
    }

    @Override
    public List<ActorDTO> getActorByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName).stream().map(actorMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorByLastName(String lastName) {
        return actorRepository.findByFirstName(lastName).stream().map(actorMapper::fromEntity).collect(Collectors.toList());
    }
}
