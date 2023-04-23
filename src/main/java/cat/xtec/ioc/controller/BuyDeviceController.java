package cat.xtec.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.xtec.ioc.service.BuyDeviceService;

/**
 *
 * @author Àlex Salinas
 */
@Controller
public class BuyDeviceController {
    @Autowired
    BuyDeviceService buyDeviceService;
    
    @RequestMapping("/buyDevice/{codi}")
    public String buy(@PathVariable("codi") String codi) {
        buyDeviceService.buyDevice(codi);
        return "redirect:/getDevice/" + codi;
    }
    
    
}
