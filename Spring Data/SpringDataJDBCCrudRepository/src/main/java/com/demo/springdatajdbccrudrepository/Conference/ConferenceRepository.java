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

    List<Conference> findByNameAndLocation(String name, String location);

    List<Conference> findByNameOrLocation(String name, String location);

    List<Conference> findByCapacityGreaterThan(int capacity);

    List<Conference> findByCapacityLessThan(int capacity);

    List<Conference> findByCapacityGreaterThanEqual(int capacity);

    List<Conference> findByCapacityLessThanEqual(int capacity);

    List<Conference> findByCapacityGreaterThanEqualOrderByCapacity(int capacity);

    List<Conference> findByCapacityGreaterThanEqualOrderByCapacityDesc(int capacity);

    List<Conference> findByCapacityBetween(int lower, int upper);

    List<Conference> findByDateBefore(Date date);

    List<Conference> findByDateAfter(Date date);

    List<Conference> findByDateBetween(Date start, Date end);

    Conference findFirstByOrderByDate();

    Conference findTopByOrderByDate();

    Conference findFirstByOrderByDateDesc();

    Conference findFirstByLocationOrderByDate(String location);

    Conference findFirstByLocationOrderByDateDesc(String location);

    List<Conference> findTop2ByOrderByDate();

    List<Conference> findFirst3ByOrderByDate();

    List<Conference> findFirst3ByOrderByDateDesc();
}
