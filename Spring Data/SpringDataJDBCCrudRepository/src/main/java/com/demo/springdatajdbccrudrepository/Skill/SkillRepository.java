package com.demo.springdatajdbccrudrepository.Skill;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
    @Query("SELECT * FROM skills WHERE skill_name = :skillName")
    Skill findByName(@Param("skillName") String skillName);
}
