package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    // 处理对“/spitter/register”的GET请求
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    // 处理对“/spitter/register”的POST请求
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Validated Spitter spitter, BindingResult br) {

        List<ObjectError> errors = br.getAllErrors();

        if (errors.size() > 0) {
            return "registerForm";
        }

        // 保存Spitter
        spitterRepository.save(spitter);

        // 重定向到基本信息页
        return "redirect:/spitter/" + spitter.getUsername();
    }

    // 处理显示用户信息的请求
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }
}
