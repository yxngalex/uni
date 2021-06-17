package rs.ac.metropolitan.cs230;

import stereotype.StudentStereotype;

@StudentStereotype
public class TraditionalStudent {
    private String name;
    private String lastName;
    private String course;
    private int numIndex;
    
    public TraditionalStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(int numIndex) {
        this.numIndex = numIndex;
    }
    
}
