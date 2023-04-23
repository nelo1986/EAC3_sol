package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.domain.repository.DeviceRepository;
import cat.xtec.ioc.service.BuyDeviceService;

/**
 *
 * @author Àlex Salinas
 */
@Service
public class BuyDeviceServiceImpl implements BuyDeviceService{

    @Autowired
    private DeviceRepository deviceRepository;
    
    @Override
    public void buyDevice(String deviceCode) {
        Device d = deviceRepository.getDeviceByCode(deviceCode);
                
        if ((d.getEstoc()) > 0) {
            d.setEstoc(d.getEstoc()-1);
        }

    }
    
}
