package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Mobil;
import cat.xtec.ioc.domain.Tablet;
import cat.xtec.ioc.domain.Device;
import cat.xtec.ioc.domain.Watch;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import cat.xtec.ioc.domain.repository.DeviceRepository;

/**
 *
 * @author Àlex Salinas
 */
@Repository
public class InMemoryDeviceRepository implements DeviceRepository {

    private List<Device> devices = new ArrayList<Device>();

    public InMemoryDeviceRepository() {

        Integer codi = 0;
        for (Integer i = 0; i < 3; i++) {
            Mobil m = new Mobil(codi.toString(), "SAMSUNG", 500, "5,5''", 20, "4g", "Android");
            devices.add(m);
            codi++;
        }
        for (Integer i = 0; i < 3; i++) {
            Tablet t = new Tablet( codi.toString(), "XIAOMI", 350, "10''", 10, "1080x2160px", 180);
            devices.add(t);
            codi++;
        }
        for (Integer i = 0; i < 3; i++) {
            Watch w = new Watch( codi.toString(), "NIXON", 250, "4x4x4", 15, "SI", "30 metros");
            devices.add(w);
            codi++;
        }
    }

    @Override
    public Device getDeviceByCode(String code) {
        Device deviceByCode = null;
        for (Device d : devices) {
            if (d != null && d.getCodi() != null
                    && d.getCodi().equals(code)) {
                deviceByCode = d;
                break;
            }
        }
        if (deviceByCode == null) {
            throw new IllegalArgumentException(
                    "No s'ha trobat el dispositiu amb el codi: " + code);
        }
        return deviceByCode;
    }

    @Override
    public void addDevice(Device device) {
        this.devices.add(device);
    }

    @Override
    public Set<Device> getDeviceByFilter(Map<String, List<String>> filterParams) {
        Set<Device> deviceByType = new HashSet<Device>();
        Set<Device> deviceByPrice = new HashSet<Device>();
        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("device")) {

            String tipus = (filterParams.get("device").get(0));
            for (Device d : devices) {
                try {
                    if (Class.forName("cat.xtec.ioc.domain." + tipus).isInstance(d)) {
                        deviceByType.add(d);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InMemoryDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (criterias.contains("preu")) {

            String price = (filterParams.get("preu").get(0));
            for (Device d : devices) {
                if (d.getPreu() >= Integer.parseInt(price) ) {
                    deviceByPrice.add(d);
                }
            }
        }
        deviceByType.retainAll(deviceByPrice);
        return deviceByType;
    }

}
