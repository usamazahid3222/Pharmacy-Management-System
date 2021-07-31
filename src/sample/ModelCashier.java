package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class ModelCashier {


        private final SimpleStringProperty ffname;
        private final SimpleStringProperty llname;
        private final SimpleStringProperty eemail;
        private final SimpleStringProperty ppassword;
        private final SimpleStringProperty mmobile;


        public ModelCashier(String ffname, String llname, String eemail, String ppassword, String mmobile) {
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
