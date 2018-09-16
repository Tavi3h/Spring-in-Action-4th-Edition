package spittr.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.SpittleForm;
import spittr.data.SpittleRepository;
import spittr.web.exceptions.SpittleNotFoundException;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    private final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

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

        Spittle spittle = spittleRepository.findOne(spittleId);

        if (spittle == null) {
            throw new SpittleNotFoundException();
        }

        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(form.getMessage(), new Date(), form.getLatitude(), form.getLongitude()));
        return "redirect:/spittles";
    }
    
//    @ExceptionHandler(DuplicateSpittleException.class) 
//    public String handleDuplicateSpittle() {
//        return "error/duplicate";
//    }
}