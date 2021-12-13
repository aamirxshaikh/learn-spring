package com.demo.springdatajdbccrudrepository;

import com.demo.springdatajdbccrudrepository.Major.Major;
import com.demo.springdatajdbccrudrepository.Major.MajorRepository;
import com.demo.springdatajdbccrudrepository.Skill.Skill;
import com.demo.springdatajdbccrudrepository.Skill.SkillRepository;
import com.demo.springdatajdbccrudrepository.Student.Student;
import com.demo.springdatajdbccrudrepository.Student.StudentRepository;
import com.demo.springdatajdbccrudrepository.StudentSkill.StudentSkill;
import com.demo.springdatajdbccrudrepository.StudentSkill.StudentSkillRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJdbcCrudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcCrudRepositoryApplication.class, args);
    }

    @Bean
    ApplicationRunner studentRunner(StudentRepository studentRepository) {
        return args -> {
//            Student

            Student student1 = new Student(null, 18, "John", "john@gmail.com", 1);
            Student student2 = new Student(null, 20, "Jane", "jane@gmail.com", 2);

//            insert

//            System.out.println(studentRepository.save(student1));
//            System.out.println(studentRepository.save(student2));

//            select/find all

            System.out.println(studentRepository.findAll());

//            find by

            System.out.println(studentRepository.findById(1));
            System.out.println(studentRepository.findByAge(18));
            System.out.println(studentRepository.findByName("John"));
            System.out.println(studentRepository.findByEmail("john@gmail.com"));
            System.out.println(studentRepository.findByMajor(1));
        };
    }

    @Bean
    ApplicationRunner majorRunner(MajorRepository majorRepository) {
        return args -> {
//            Major

            Major major1 = Major.addMajor(null, "History");
            Major major2 = Major.addMajor(null, "Psychology");

//            insert

//            System.out.println(majorRepository.save(major1));
//            System.out.println(majorRepository.save(major2));

//            select/find all

            System.out.println(majorRepository.findAll());

//            find by

            System.out.println(majorRepository.findById(2L));
            System.out.println(majorRepository.findByName("History"));
        };
    }

    @Bean
    ApplicationRunner skillRunner(SkillRepository skillRepository) {
        return args -> {
//            Skill

            Skill skill1 = Skill.addSkill(null, "React");
            Skill skill2 = Skill.addSkill(null, "AWS");

//            insert

//            System.out.println(skillRepository.save(skill1));
//            System.out.println(skillRepository.save(skill2));

//            select/find all

            System.out.println(skillRepository.findAll());

//            find by

            System.out.println(skillRepository.findByName("AWS"));
        };
    }

    @Bean
    ApplicationRunner studentSkillRunner(StudentSkillRepository studentSkillRepository) {
        return args -> {
//            StudentSkill

            Integer studentId = studentSkillRepository.findStudentByName("Aamir").getId();
            Long skillId = studentSkillRepository.findSkillByName("AWS").getSkillId();

            StudentSkill studentSkill = new StudentSkill();

            studentSkill.setStudentId(studentId);
            studentSkill.setSkillId(skillId);

//            insert

            System.out.println(studentSkillRepository.save(studentSkill));

//            find by

            System.out.println(studentSkillRepository.findStudentByName("Aamir"));
            System.out.println(studentSkillRepository.findSkillByName("React"));
        };
    }
}
