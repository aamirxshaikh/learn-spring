package com.demo.springdatajdbccrudrepository;

import com.demo.springdatajdbccrudrepository.Conference.Conference;
import com.demo.springdatajdbccrudrepository.Conference.ConferenceRepository;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataJdbcCrudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcCrudRepositoryApplication.class, args);
    }

//    @Bean
//    ApplicationRunner studentRunner(StudentRepository studentRepository) {
//        return args -> {
////            Student
//
//            Student student1 = new Student(null, 18, "John", "john@gmail.com", 1);
//            Student student2 = new Student(null, 20, "Jane", "jane@gmail.com", 2);
//
////            insert
//
////            System.out.println(studentRepository.save(student1));
////            System.out.println(studentRepository.save(student2));
//
////            select/find all
//
//            System.out.println(studentRepository.findAll());
//
////            find by
//
//            System.out.println(studentRepository.findById(1));
//            System.out.println(studentRepository.findByAge(18));
//            System.out.println(studentRepository.findByName("John"));
//            System.out.println(studentRepository.findByEmail("john@gmail.com"));
//            System.out.println(studentRepository.findByMajor(1));
//        };
//    }
//
//    @Bean
//    ApplicationRunner majorRunner(MajorRepository majorRepository) {
//        return args -> {
////            Major
//
//            Major major1 = Major.addMajor(null, "History");
//            Major major2 = Major.addMajor(null, "Psychology");
//
////            insert
//
////            System.out.println(majorRepository.save(major1));
////            System.out.println(majorRepository.save(major2));
//
////            select/find all
//
//            System.out.println(majorRepository.findAll());
//
////            find by
//
//            System.out.println(majorRepository.findById(2L));
//            System.out.println(majorRepository.findByName("History"));
//        };
//    }
//
//    @Bean
//    ApplicationRunner skillRunner(SkillRepository skillRepository) {
//        return args -> {
////            Skill
//
//            Skill skill1 = Skill.addSkill(null, "React");
//            Skill skill2 = Skill.addSkill(null, "AWS");
//
////            insert
//
////            System.out.println(skillRepository.save(skill1));
////            System.out.println(skillRepository.save(skill2));
//
////            select/find all
//
//            System.out.println(skillRepository.findAll());
//
////            find by
//
//            System.out.println(skillRepository.findByName("AWS"));
//        };
//    }
//
//    @Bean
//    ApplicationRunner studentSkillRunner(StudentSkillRepository studentSkillRepository) {
//        return args -> {
////            StudentSkill
//
//            Integer studentId = studentSkillRepository.findStudentByName("Aamir").getId();
//            Long skillId = studentSkillRepository.findSkillByName("AWS").getSkillId();
//
//            StudentSkill studentSkill = new StudentSkill();
//
//            studentSkill.setStudentId(studentId);
//            studentSkill.setSkillId(skillId);
//
////            insert
//
//            System.out.println(studentSkillRepository.save(studentSkill));
//
////            find by
//
//            System.out.println(studentSkillRepository.findStudentByName("Aamir"));
//            System.out.println(studentSkillRepository.findSkillByName("React"));
//        };
//    }

    @Bean
    ApplicationRunner conferenceRunner(ConferenceRepository conferenceRepository) {
        return args -> {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021");
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2021");
            Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse("28/12/2021");

//            conferenceRepository.save(new Conference(null, "ReactConf", "abc", 5000, date1));
//            conferenceRepository.save(new Conference(null, "Redux", "xyz", 1000, date2));
//            conferenceRepository.save(new Conference(null, "Azure", "abc", 10000, date3));

            System.out.println("findAll()");
            for (Conference conference : conferenceRepository.findAll()) {
                System.out.println(conference);
            }

            System.out.println("findById()");
            System.out.println(conferenceRepository.findById(2L));

            List<Long> ids = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));

            System.out.println("findAllById()");
            for (Conference conference : conferenceRepository.findAllById(ids)) {
                System.out.println(conference);
            }

            System.out.println("existsById()");
            System.out.println(conferenceRepository.existsById(2432L));

            System.out.println("count()");
            System.out.println(conferenceRepository.count());

//            derived query methods

            System.out.println("find by conference name");
            System.out.println(conferenceRepository.findByName("Redux"));

            System.out.println("find by location");
            System.out.println(conferenceRepository.findByLocation("abc"));

            System.out.println("find by capacity");
            System.out.println(conferenceRepository.findByCapacity(5000));

            System.out.println("find by date");
            System.out.println(conferenceRepository.findByDate(date1));

            System.out.println("findByNameAndLocation()");

            System.out.println(conferenceRepository.findByNameAndLocation("Redux", "xyz"));

            System.out.println("findByNameOrLocation()");

            System.out.println(conferenceRepository.findByNameOrLocation("ReactConf", "abc"));

            System.out.println("Range Queries");

            System.out.println(conferenceRepository.findByCapacityGreaterThan(10));

            System.out.println(conferenceRepository.findByCapacityGreaterThanEqual(10));

            System.out.println(conferenceRepository.findByCapacityLessThan(1000));

            System.out.println(conferenceRepository.findByCapacityLessThanEqual(1000));

            System.out.println(conferenceRepository.findByCapacityGreaterThanEqualOrderByCapacity(10));

            System.out.println(conferenceRepository.findByCapacityGreaterThanEqualOrderByCapacityDesc(10));

            System.out.println(conferenceRepository.findByCapacityBetween(1000, 10000));

            System.out.println("Ordering results");

            System.out.println(conferenceRepository.findByDateBefore(date2));

            System.out.println(conferenceRepository.findByDateAfter(date2));

            System.out.println(conferenceRepository.findByDateBetween(date1, date3));

            System.out.println(conferenceRepository.findFirstByOrderByDate());

            System.out.println(conferenceRepository.findFirstByOrderByDateDesc());

            System.out.println(conferenceRepository.findFirstByLocationOrderByDate("abc"));

            System.out.println(conferenceRepository.findFirstByLocationOrderByDateDesc("abc"));

            System.out.println(conferenceRepository.findTop2ByOrderByDate());

            System.out.println(conferenceRepository.findFirst3ByOrderByDate());

            System.out.println(conferenceRepository.findFirst3ByOrderByDateDesc());
        };
    }
}
