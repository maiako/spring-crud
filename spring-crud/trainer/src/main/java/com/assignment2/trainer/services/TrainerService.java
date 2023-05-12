/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.trainer.services;

import com.assignment2.trainer.entities.Trainer;
import com.assignment2.trainer.repositories.TrainerRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Μ
 */
@Service
@Transactional
public class TrainerService {

    @Autowired
    private TrainerRepository repository;

    public List<Trainer> getAllTrainers() {

        //call from Repository findAllProducts/getAllProducts
        return repository.findAll();
    }

    public boolean insertTrainer(Trainer t) {
        return repository.save(t).getId() > 0;
    }

    public Trainer getById(Integer id) {
        return (repository.findById(id)).get();
    }

    public boolean findById(Integer id) {
        return (repository.findById(id).get().getId() > 0);
    }

    public boolean deleteById(Integer id) {
        repository.deleteById(id);
        return (true);
    }

    public boolean updateTrainer(Trainer t) {
        //findById t.getId()
        //change properties
        //save
        Trainer dbTrainer = repository.findById(t.getId()).get();
        //dbTrainer = t  NOOO dont break persistence
        dbTrainer.setFname(t.getFname());
        dbTrainer.setLname(t.getLname());
        dbTrainer.setSubject(t.getSubject());
        repository.saveAndFlush(dbTrainer);
        return true; //na valo if else false
    }
}
