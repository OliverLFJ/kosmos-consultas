package com.kosmos.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmos.app.model.Consultorio;

@Repository
public interface IConsultorio extends CrudRepository<Consultorio, Integer> {

}
