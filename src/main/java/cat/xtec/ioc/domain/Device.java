
package cat.xtec.ioc.domain;

/**
 *
 * @author Alex Salinas
 */
public class Device {

    protected String codi;
    protected String marca;
    protected Integer preu;
    protected String pantalla;
    protected Integer estoc;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPreu() {
        return preu;
    }

    public void setPreu(Integer preu) {
        this.preu = preu;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Integer getEstoc() {
        return estoc;
    }

    public void setEstoc(Integer estoc) {
        this.estoc = estoc;
    }

    public Device(String codi, String marca, Integer preu, String pantalla, Integer estoc) {
        this.codi = codi;
        this.marca = marca;
	this.preu = preu;
        this.pantalla = pantalla;
        this.estoc = estoc;
    }

    public Device() {
    }

  
   
    
}
