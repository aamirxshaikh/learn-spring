package com.demo.springdatajdbccrudrepository.StudentSkill;

import com.demo.springdatajdbccrudrepository.Skill.Skill;
import com.demo.springdatajdbccrudrepository.Student.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSkillRepository extends CrudRepository<StudentSkill, Long> {
    @Query("SELECT * FROM students WHERE name = :name")
    Student findStudentByName(@Param("name") String name);

    @Query("SELECT * FROM skills WHERE skill_name = :skillName")
    Skill findSkillByName(@Param("skillName") String skillName);
}
