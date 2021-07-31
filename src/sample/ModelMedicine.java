package sample;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModelMedicine {

    private final SimpleStringProperty nname;
    private final SimpleIntegerProperty sstock;
    private final SimpleDoubleProperty purprice;
    private final SimpleDoubleProperty salprice;
    private final SimpleDoubleProperty prpc;
    private final SimpleStringProperty manu;


    public ModelMedicine (String nname, Integer sstock, Double purprice, Double salprice, Double prpc, String manu) {
        this.nname = new SimpleStringProperty(nname);
        this.sstock = new SimpleIntegerProperty(sstock);
        this.purprice= new SimpleDoubleProperty(purprice);
        this.salprice= new SimpleDoubleProperty(salprice);
        this.prpc= new SimpleDoubleProperty(prpc);
        this.manu = new SimpleStringProperty(manu);

    }

    public String getNname() {
        return nname.get();
    }
    public Integer getSstock() {
        return sstock.get();
    }
    public Double getPurprice() {
        return purprice.get();
    }
    public Double getSalprice() {
        return salprice.get();
    }
    public Double getPrpc() {
        return prpc.get();
    }
    public String getManu() {
        return manu.get();
    }



    public void setNname(String nname) {
        this.nname.set(nname);
    }
    public void setSstock(Integer sstock) {
        this.sstock.set(sstock);
    }

    public void setPurprice(Double purprice) {
        this.purprice.set(purprice);
    }
    public void setSalprice(Double salprice) {
        this.salprice.set(salprice);
    }
    public void setPrpc(Double prpc) {
        this.prpc.set(prpc);
    }
    public void setManu(String manu) {
        this.manu.set(manu);
    }




//
//        public ModelMedicine(String nname, Integer sstock, Double purprice, Double salprice, Double prpc, String manu) {
//            this.nname = new SimpleStringProperty(nname);
//            this.sstock = new SimpleIntegerProperty(sstock);
//            this.purprice= new SimpleDoubleProperty(purprice);
//            this.salprice= new SimpleDoubleProperty(salprice);
//            this.prpc= new SimpleDoubleProperty(prpc);
//            this.manu = new SimpleStringProperty(manu);
//
//        }



}