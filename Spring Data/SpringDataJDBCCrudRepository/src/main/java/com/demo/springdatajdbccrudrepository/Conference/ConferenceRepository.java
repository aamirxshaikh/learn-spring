package com.demo.springdatajdbccrudrepository.Conference;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
    List<Conference> findByName(String name);

    List<Conference> findByLocation(String location);

    List<Conference> findByCapacity(int capacity);

    List<Conference> findByDate(Date date);
}
