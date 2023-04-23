
package cat.xtec.ioc.domain;

/**
 *
 * @author Àlex Salinas
 */
public class Watch extends Device{
    private String sensor;
    private String profunditat;

    public Watch() {
        super();
    }

    public Watch (String codi, String marca, Integer preu, String pantalla, Integer estoc, String sensor, String profunditat) {
        super(codi,  marca,  preu,  pantalla,  estoc);
        this.sensor = sensor;
        this.profunditat = profunditat;
     
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getProfunditat() {
        return profunditat;
    }

    public void setProfunditat(String profunditat) {
        this.profunditat = profunditat;
    }



    
    
}
