package spittr.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    // 使用形参MultipartFile
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Validated Spitter spitter, 
            BindingResult br, 
            HttpSession session,
            MultipartFile profilePicture,
            RedirectAttributes model) throws IllegalStateException, IOException {

        List<ObjectError> errors = br.getAllErrors();

        if (errors.size() > 0) {
            return "registerForm";
        }
        
        if (!profilePicture.isEmpty()) {
            
            String path = session.getServletContext().getRealPath("/profilePictures");
            
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            
            String filename = profilePicture.getOriginalFilename();
            
            if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png") || filename.endsWith(".gif")) {
                profilePicture.transferTo(new File(path, filename));
            } else {
                return "registerForm";
            }
        }

        // 保存Spitter
        spitterRepository.save(spitter);

        // 重定向到基本信息页
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/" + spitter.getUsername();
        
    }
    
    // 处理对“/spitter/register”的POST请求
    // 使用形参Part
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String processRegistration(
//            @Validated Spitter spitter, 
//            BindingResult br, 
//            HttpSession session,
//            Part profilePicture ) throws IllegalStateException, IOException {
//
//        List<ObjectError> errors = br.getAllErrors();
//
//        if (errors.size() > 0) {
//            return "registerForm";
//        }
//        
//        if (profilePicture.getSize() != 0) {
//            
//            String path = session.getServletContext().getRealPath("/profilePictures");
//            
//            File file = new File(path);
//            if (!file.exists()) {
//                file.mkdir();
//            }
//            
//            String filename = profilePicture.getSubmittedFileName();
//            
//            if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png") || filename.endsWith(".gif")) {
//                profilePicture.write(new File(path, filename).toString());
//            } else {
//                return "registerForm";
//            }
//        }
//
//        // 保存Spitter
//        spitterRepository.save(spitter);
//
//        // 重定向到基本信息页
//        return "redirect:/spitter/" + spitter.getUsername();
//    }

    // 处理显示用户信息的请求
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        
        if (!model.containsAttribute("spitter")) {
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute("spitter", spitter);
        }
        return "profile";
    }
}
