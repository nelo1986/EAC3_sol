package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Device;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.domain.repository.DeviceRepository;
import cat.xtec.ioc.service.DeviceService;

/**
 *
 * @author Àlex Salinas
 */

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Override
    public Device getDeviceByCode(String code) {
        return deviceRepository.getDeviceByCode(code);    
    }
   
    @Override
    public void addDevice(Device device) {
        deviceRepository.addDevice(device);
    }

    @Override
    public Set<Device> getDeviceByFilter(Map<String, List<String>> filterParams) {
        return deviceRepository.getDeviceByFilter(filterParams);
    }
    
}
