package com.demo.springdatajdbccrudrepository.Major;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("majors")
public class Major {
    @Id
    @Column("major_id")
    private Long majorId;
    
    @Column("major_name")
    private String majorName;

    public Major(Long majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
    
    public static Major addMajor(Long majorId, String majorName) {
        return new Major(majorId, majorName);
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
