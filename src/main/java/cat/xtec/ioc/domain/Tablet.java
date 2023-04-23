package cat.xtec.ioc.domain;

/**
 *
 * @author Alex Salinas
 */
public class Tablet extends Device {

    protected String resolucio;
    protected Integer pes;

    public Tablet (String codi, String marca, Integer preu, String pantalla, Integer estoc, String resolucio, Integer pes) {
        super(codi,  marca,  preu,  pantalla,  estoc);
        this.resolucio = resolucio;
        this.pes = pes;
     
    }

    public Tablet() {
        super();
    }

    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    public Integer getPes() {
        return pes;
    }

    public void setPes(Integer pes) {
        this.pes = pes;
    }


   

    
}
