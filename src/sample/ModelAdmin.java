package sample;
import javafx.beans.property.SimpleStringProperty;

//

//
//import javafx.beans.property.SimpleStringProperty;
//
//
//
//public class ModelAdmin {
////    private  SimpleStringProperty firstName ;
////    private  SimpleStringProperty lastName;
////    private  SimpleStringProperty email;
////    private  SimpleStringProperty password;
////    private  SimpleStringProperty mobile;
////
////    public ModelAdmin(String fName, String lName, String eMail, String Password, String Mobile) {
////
////        this.firstName = new SimpleStringProperty(fName);
////        this.lastName = new SimpleStringProperty(lName);
////        this.email = new SimpleStringProperty(eMail);
////        this.password = new SimpleStringProperty(Password);
////        this.mobile = new SimpleStringProperty(Mobile);
////
////    }
////
////    public ModelAdmin() {
////
////    }
////
////
////    public void admindata(String fName, String lName, String eMail, String Password, String mobile) {
////        this.firstName = new SimpleStringProperty(fName);
////        this.lastName = new SimpleStringProperty(lName);
////        this.email = new SimpleStringProperty(eMail);
////        this.password = new SimpleStringProperty(Password);
////        this.mobile = new SimpleStringProperty(mobile);
////    }
////
////    public String getFirstName() {
////        return firstName.get();
////    }
////
////    public String getLastName() { return lastName.get();
////    }
////
////    public String getEmail() {
////        return email.get();
////    }
////
////    public String getPassword() {
////        return password.get();
////    }
////
////    public String getMobile() {
////        return mobile.get();
////    }
////
////
////    public void setFirstName(String fName) { firstName.set(fName);
////    }
////
////    public void setLastName(String lName) { lastName.set(lName);
////    }
////
////    public void setEmail(String eMail) {
////        email.set(eMail);
////    }
////
////    public void setPassword(String Password) {
////        password.set(Password);
////    }
////
////    public void setMobile(String Mobile) {
////       mobile.set(Mobile);
////    }
//
//    private final SimpleStringProperty ffname;
//    private final SimpleStringProperty llname;
//    private final SimpleStringProperty eemail;
//    private final SimpleStringProperty ppassword;
//    private final SimpleStringProperty mmobile;
//
//
//    public ModelAdmin(String ffname, String llname, String eemail, String ppassword, String mmobile) {
//        this.ffname = new SimpleStringProperty(ffname);
//        this.llname = new SimpleStringProperty(llname);
//        this.eemail = new SimpleStringProperty(eemail);
//        this.ppassword = new SimpleStringProperty(ppassword);
//        this.mmobile = new SimpleStringProperty(mmobile);
//    }
//
//    public String getFfname() {
//        return ffname.get();
//    }
//
//    public String getLlname() {
//        return llname.get();
//    }
//
//    public String getEemail() {
//        return eemail.get();
//    }
//
//    public String getPpassword() {
//        return ppassword.get();
//    }
//
//    public String getMmobile() {
//        return mmobile.get();
//    }
//
//
//    public void setFfname(String ffname) {
//        this.ffname.set(ffname);
//    }
//
//    public void setLlname(String llname) {
//        this.llname.set(llname);
//    }
//
//    public void setEemail(String eemail) {
//        this.eemail.set(eemail);
//    }
//
//    public void setPpassword(String ppassword) {
//        this.ppassword.set(ppassword);
//    }
//
//    public void setMmobile(String mmobile) {
//        this.mmobile.set(mmobile);
//    }
public class ModelAdmin {



    private  SimpleStringProperty ffname;
    private  SimpleStringProperty llname;
    private  SimpleStringProperty eemail;
    private  SimpleStringProperty ppassword;
    private  SimpleStringProperty mmobile;



    public ModelAdmin(String ffname, String llname, String eemail, String ppassword, String mmobile) {


        this.ffname = new SimpleStringProperty(ffname);
        this.llname = new SimpleStringProperty(llname);
        this.eemail = new SimpleStringProperty(eemail);
        this.ppassword = new SimpleStringProperty(ppassword);
        this.mmobile = new SimpleStringProperty(mmobile);
    }

    public ModelAdmin() {

    }

    public void admindata(String ffname, String llname, String eemail, String ppassword, String mmobile) {
        this.ffname = new SimpleStringProperty(ffname);
        this.llname = new SimpleStringProperty(llname);
        this.eemail = new SimpleStringProperty(eemail);
        this.ppassword = new SimpleStringProperty(ppassword);
        this.mmobile = new SimpleStringProperty(mmobile);
    }

    public String getFfname() {
        return ffname.get();
    }

    public String getLlname() {
        return llname.get();
    }

    public String getEemail() {
        return eemail.get();
    }

    public String getPpassword() {
        return ppassword.get();
    }

    public String getMmobile() {
        return mmobile.get();
    }


    public void setFfname(String ffname) {
        this.ffname.set(ffname);
    }

    public void setLlname(String llname) {
        this.llname.set(llname);
    }

    public void setEemail(String eemail) {
        this.eemail.set(eemail);
    }

    public void setPpassword(String ppassword) {
        this.ppassword.set(ppassword);
    }

    public void setMmobile(String mmobile) {
        this.mmobile.set(mmobile);
    }

}






