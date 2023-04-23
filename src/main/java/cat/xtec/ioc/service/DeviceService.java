package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Device;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Àlex Salinas
 */
public interface DeviceService {
    
    void addDevice(Device device);
    
    Device getDeviceByCode(String code);
    
    Set<Device> getDeviceByFilter(Map<String, List<String>> filterParams);
    
}
