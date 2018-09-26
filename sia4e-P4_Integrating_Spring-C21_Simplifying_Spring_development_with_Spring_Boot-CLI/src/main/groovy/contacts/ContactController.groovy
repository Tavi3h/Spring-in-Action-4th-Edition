package contacts

@Grab(group='org.thymeleaf', module='thymeleaf-spring4', version='2.1.6.RELEASE')

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;
@Grab(group='org.springframework.boot', module='spring-boot-starter-actuator', version='1.5.16.RELEASE')

@Controller
@RequestMapping("/")
class ContactController {

    @Autowired
    ContactRepository contactRepo

    @RequestMapping(method = RequestMethod.GET)
    String home(Map<String,Object> model) {
        List<Contact> contacts = contactRepo.findAll()
        model.putAll([contacts: contacts])
        "home"
    }

    @RequestMapping(method = RequestMethod.POST)
    String submit(Contact contact) {
        contactRepo.save(contact)
        "redirect:/"
    }
}