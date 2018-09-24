package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;
import spittr.jmx.SpittleControllerManagedOperations;

@Controller
@RequestMapping("/spittles")
@ManagedResource(objectName = "spitter:name=SpitteleController")
public class SpittleController implements SpittleControllerManagedOperations {

    private SpittleRepository spittleRepository;

    private final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

    @ManagedOperation
    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }

    @ManagedOperation
    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    // 注入SpittleRepository
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        // 将spittleList添加到模型中
        model.addAttribute("spittleList", spittleRepository.findSpittles(max, count));
        // 返回视图名
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable long spittleId, Model model) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }
}