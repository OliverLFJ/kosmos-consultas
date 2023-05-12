package com.kosmos.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmos.app.model.Doctor;

@Repository
public interface IDoctor extends CrudRepository<Doctor, Integer>{

}
