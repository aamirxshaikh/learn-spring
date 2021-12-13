package com.demo.springdatajdbccrudrepository.StudentSkill;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student_skill")
public class StudentSkill {
    @Id
    private int id;

    @Column("student_id")
    private Integer studentId;

    @Column("skill_id")
    private Long skillId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    @Override
    public String toString() {
        return "StudentSkill{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", skillId=" + skillId +
                '}';
    }
}
