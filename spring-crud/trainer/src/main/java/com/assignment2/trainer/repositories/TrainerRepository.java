/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.trainer.repositories;

import com.assignment2.trainer.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Μ
 */
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
    
}
