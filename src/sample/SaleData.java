package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SaleData {


        private final SimpleStringProperty nname;
        private final SimpleDoubleProperty prpc;
        private final SimpleStringProperty quan;
        private final SimpleDoubleProperty total;

        public SaleData(String nname, Double prpc, String quan, Double total) {
            this.nname = new SimpleStringProperty(nname);
            this.prpc = new SimpleDoubleProperty(prpc);
            this.quan = new SimpleStringProperty(quan);
            this.total = new SimpleDoubleProperty(total);

        }

        public String getNname() {
            return nname.get();
        }

        public Double getPrpc() {
            return prpc.get();
        }

        public String getQuan() {
            return quan.get();
        }

        public Double getTotal() {
            return total.get();
        }

        public void setNname(String nname) {
            this.nname.set(nname);
        }

        public void setPrpc(Double prpc) {
            this.prpc.set(prpc);
        }

        public void setQuan(String quan) {
            this.quan.set(quan);
        }

        public void setTotal(Double total) {
            this.total.set(total);
        }



}
