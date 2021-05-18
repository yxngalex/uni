package rs.ac.metropolitan.cs230;

import javax.interceptor.Interceptors;
import interceptor.Interceptor;
import stereotype.StudentStereotype;
import clarification.InternetClarification;

@StudentStereotype
@InternetClarification
public class OnlineStudent extends TraditionalStudent {

    private int additonalPrice;

    @Interceptors(Interceptor.class)
    public String scheduleConsultation() {
        return "Congratulations!\n" +
                "Your Consultation Has Been Scheduled.";
    }

    public OnlineStudent() {
    }

    public int getAdditonalPrice() {
        return additonalPrice;
    }

    public void setAdditonalPrice(int additonalPrice) {
        this.additonalPrice = additonalPrice;
    }
}
