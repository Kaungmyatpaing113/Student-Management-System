package bean;

import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private String course;

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this. studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this. studentName = studentName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this. course = course; }
}