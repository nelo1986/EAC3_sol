package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Device;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cat.xtec.ioc.service.DeviceService;

/**
 *
 * @author Alex Salinas
 */
@Controller
public class SmartShopController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homeRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> info = new HashMap();
        info.put("title", "Afegir");
        info.put("desc", "Permet afegir un nou dispositiu a la botiga.");
        info.put("url", "/add");
        info.put("icon", "glyphicon-road glyphicon");
        data.add(info);
        Map<String, String> info2 = new HashMap();
        info2.put("title", "Consultar");
        info2.put("desc", "Permet consultar la informació d'un dispositiu de la botiga.");
        info2.put("url", "/get");
        info2.put("icon", "glyphicon-search glyphicon");
        data.add(info2);
        Map<String, String> info3 = new HashMap();
        info3.put("title", "Filtrar");
        info3.put("desc", "Permet cercar dins del llistat de dispositius.");
        info3.put("url", "/filter");
        info3.put("icon", "glyphicon-list-alt glyphicon");
        data.add(info3);
        Map<String, String> info4 = new HashMap();
        info4.put("title", "Comprar");
        info4.put("desc", "Permet comprar un dispositiu de la botiga.");
        info4.put("url", "/buy");
        info4.put("icon", "glyphicon-euro glyphicon");
        data.add(info4);
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("options", data);
        return modelview;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addDeviceRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Afegir un nou dispositiu");
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> info = new HashMap();
        info.put("title", "Mòbil");
        info.put("desc", "Permet afegir un telèfon mòbil a la botiga.");
        info.put("url", "/add/Mobil");
        info.put("icon", "glyphicon-tent glyphicon");
        data.add(info);
        Map<String, String> info2 = new HashMap();
        info2.put("title", "Tablet");
        info2.put("desc", "Permet afegir una tablet a la botiga.");
        info2.put("url", "/add/Tablet");
        info2.put("icon", "glyphicon-dashboard glyphicon");
        data.add(info2);
        Map<String, String> info3 = new HashMap();
        info3.put("title", "Smart Watch");
        info3.put("desc", "Permet afegir un rellotge intel·ligent a la botiga.");
        info3.put("url", "/add/Watch");
        info3.put("icon", "glyphicon-flash glyphicon");
        data.add(info3);
        modelview.getModelMap().addAttribute("options", data);
        return modelview;
    }

    @RequestMapping(value = "/add/{device}", method = RequestMethod.GET)
    public ModelAndView addDeviceForm(@PathVariable("device") String tipusDispositiu, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ModelAndView modelview = new ModelAndView("add" + tipusDispositiu);
        modelview.getModelMap().addAttribute("tagline", "Afegir un dispositiu " + tipusDispositiu + " a la botiga");
        modelview.getModelMap().addAttribute("newDevice",
                Class.forName("cat.xtec.ioc.domain." + tipusDispositiu).newInstance());
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        return modelview;
    }
    
//    @InitBinder
//    public void initialiseBinder(WebDataBinder binder) {
//        binder.setDisallowedFields("estoc");
//    }
    
    @RequestMapping(value = "/add/{device}", method = RequestMethod.POST)
    public String addDeviceForm(@PathVariable("device") String tipusDispositiu, @ModelAttribute("newDevice") Device newDeviceToAdd, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        deviceService.addDevice(newDeviceToAdd);
        return "redirect:/";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getDeviceFormRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("getDeviceForm");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        return modelview;
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ModelAndView getDeviceByCodiRequest(@RequestParam  String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("infoDevice");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un dispositiu de la botiga");
        modelview.getModelMap().addAttribute("r", deviceService.getDeviceByCode(codi));
        return modelview;
    }
    
    
    @RequestMapping("/filter")
    public ModelAndView getDeviceByFilter( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("helpFilter");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Ajuda per la creació d'un Filtre.");
        return modelview;
    }
    
    @RequestMapping("/filter/{ByCriteria}")
    public ModelAndView getDeviceByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("listDeviceByFilter");
        modelview.getModelMap().addAttribute("device", deviceService.getDeviceByFilter(filterParams));
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Llistat de dispositius que compleixen els requisits.");
        return modelview;
    }
    
    @RequestMapping("/buy")
    public ModelAndView buyDevice (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("buyDevice");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Compra d'un dispositiu.");
        return modelview;
    }
    
    @RequestMapping(value = "/getDevice/{codi}", method = RequestMethod.GET)
    public ModelAndView getDeviceByRequest(@PathVariable  String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("infoDevice");
        modelview.getModelMap().addAttribute("banner", "Programa de Gestió Smart Shop!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un dispositiu de la botiga");
        modelview.getModelMap().addAttribute("r", deviceService.getDeviceByCode(codi));
        return modelview;
    }

}
