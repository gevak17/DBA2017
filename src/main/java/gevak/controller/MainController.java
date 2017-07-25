package gevak.controller;

import gevak.dto.UserDTO;
import gevak.entity.User;
import gevak.service.MailService;
import gevak.service.UserService;
import gevak.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @GetMapping("/")                                                                 //main page
    public String toMainPage() {
        return "welcome";
    }


    @GetMapping("/login")                                                           //login page
    public String signIn() {return "login";}


    @GetMapping("/index")                                                           //index page, register data user's
    public String toIndexPage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/list")                                                            // list page
    public String toListPage(Model model) {
        model.addAttribute("list", userService.findAll());

        List<User> users = userService.findAll();
        List<UserDTO> dtos = new ArrayList<>();

        for (User user : users) {
            UserDTO dto = new UserDTO();

            dto.setUserId(user.getId());
            dto.setUserSurname(user.getSurName());
            dto.setUserName(user.getName());
            dto.setUserP1(user.getP1());
            dto.setUserP2(user.getP2());
            dto.setUserP3(user.getP3());
            dto.setUserAtestat(user.getAtestat());
            dto.setUserAvatar(user.getAvatar());
            dto.setUserEmail(user.getEmail());
            dto.setUserPhoneNumber(user.getPhoneNumber());

            dtos.add(dto);
        }
//        User user = new User();
        model.addAttribute("dtos", dtos);
        return "list";
    }

    @GetMapping("/deleteAll")
    public String delAll(){
        userService.deleteAll();
        return "list";
    }

    @GetMapping("/delUser-{id}")
    public String delUser(@PathVariable int id,
                          Model model) {
        model.addAttribute("Delete", userService.findOne(id));
        return "list";
    }

    //SAVE USER DATA
    //can be annotation @RequestMapping(value = "addNewUser", method = RequestMethod.POST)
    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult result,
                             @RequestParam("ava") MultipartFile multipartFile) {

        if (result.hasErrors()) {
            return "index";
        }       //validator

        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        try {
            multipartFile.transferTo(new File(realPath + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setAvatar(File.separator + "avatar" + File.separator + multipartFile.getOriginalFilename());

        userService.save(user);
//        mailService.send(user);
//        return "index";
        return "redirect:/"; //return to current page
    }




    //Validator
    @Autowired
    UserValidator userValidator;
    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }


}
