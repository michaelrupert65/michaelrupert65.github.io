package com.arteach.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Event;

@Repository
public interface IEventRepo extends JpaRepository<Event, Integer> {

}
