package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import rs.ac.metropolitan.cs230.TraditionalStudent;
import stereotype.StudentStereotype;
import clarification.InternetClarification;

@StudentStereotype
public class OnlineStudentController {

    private static final Logger logger = Logger.getLogger(
            TraditionalStudentController.class.getName());

    @Inject
    @InternetClarification
    private TraditionalStudent student;

    public TraditionalStudent getStudent() {
        return student;
    }

    public void setStudent(TraditionalStudent student) {
        this.student = student;
    }

      public String saveStudent() {
        TraditionalStudent studentt
                = (TraditionalStudent) student;
        logger.log(Level.INFO, "Online Student : \n"
                + "{0} {1} {2}",
                new Object[]{studentt.getName(),
                    studentt.getLastName(), studentt.getCourse()});
        return "onlineStudent_confirmation";
    }

}
