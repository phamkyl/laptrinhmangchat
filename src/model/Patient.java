package model;


import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private int numberCode;
    private String namePatient;
    private String homeTown;
    private String diagnostic;
    private Date dateCome;
    private Date dateOut;

    public Patient(int numberCode, String namePatient, String homeTown, String diagnostic, Date dateCome, Date dateOut) {
        this.numberCode = numberCode;
        this.namePatient = namePatient;
        this.homeTown = homeTown;
        this.diagnostic = diagnostic;
        this.dateCome = dateCome;
        this.dateOut = dateOut;
    }

    public Patient() {

    }

    public int getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(int numberCode) {
        this.numberCode = numberCode;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Date getDateCome() {
        return dateCome;
    }

    public void setDateCome(Date dateCome) {
        this.dateCome = dateCome;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "numberCode='" + numberCode + '\'' +
                ", namePatient='" + namePatient + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", diagnostic='" + diagnostic + '\'' +
                ", dateCome=" + dateCome +
                ", dateOut=" + dateOut +
                '}';
    }
}
