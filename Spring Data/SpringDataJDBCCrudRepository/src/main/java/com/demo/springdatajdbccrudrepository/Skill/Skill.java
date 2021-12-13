package com.demo.springdatajdbccrudrepository.Skill;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("skills")
public class Skill {
    @Id
    @Column("skill_id")
    private Long skillId;

    @Column("skill_name")
    private String skillName;

    public Skill(Long skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public static Skill addSkill(Long skillId, String skillName) {
        return new Skill(skillId, skillName);
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
