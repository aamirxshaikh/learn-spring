package com.demo.springdatajdbccrudrepository.Major;

import com.demo.springdatajdbccrudrepository.Student.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends CrudRepository<Major, Long> {
    @Query("SELECT * FROM majors WHERE major_name = :majorName")
    List<Major> findByName(@Param("majorName") String majorName);
}
