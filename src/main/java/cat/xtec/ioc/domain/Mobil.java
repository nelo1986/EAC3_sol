package cat.xtec.ioc.domain;

/**
 *
 * @author Àlex Salinas
 */
public class Mobil extends Device{
    private String connectivitat;
    private String so;

    public Mobil (String codi, String marca, Integer preu, String pantalla, Integer estoc, String connectivitat, String so) {
        super( codi,  marca,  preu,  pantalla,  estoc);
        this.connectivitat = connectivitat;
        this.so = so;
     
    }

    public Mobil() {
        super();
    }    

    public String getConnectivitat() {
        return connectivitat;
    }

    public void setConnectivitat(String connectivitat) {
        this.connectivitat = connectivitat;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }




    
    
}
