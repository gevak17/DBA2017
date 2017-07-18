package gevak.controller;

import gevak.dto.UserDTO;
import gevak.validator.UserValidator;
import gevak.entity.User;
import gevak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String toMainPage(Model model) {
        model.addAttribute("user", new User("", ""));
        return "index";
    }

    @RequestMapping(value = "addNewUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult result,
                             @RequestParam("ava")MultipartFile multipartFile) {

        if (result.hasErrors()) {
            return "index";
        }

        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        System.out.println(realPath);
        try {
            multipartFile.transferTo(new File(realPath+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setAvatar(File.separator+"avatar"+File.separator+multipartFile.getOriginalFilename());

        userService.save(user);

        return "redirect:/";

    }





    @GetMapping("/list")
    public String toListPage(Model model) {
        model.addAttribute("list", userService.findAll());

        List<User> users = userService.findAll();
        List<UserDTO> dtos = new ArrayList<>();

        for (User user: users) {
            UserDTO dto = new UserDTO();

            dto.setUserId(user.getId());
            dto.setUserSurname(user.getSurName());
            dto.setUserName(user.getName());
            dto.setUserP1(user.getP1());
            dto.setUserP2(user.getP2());
            dto.setUserP3(user.getP3());
            dto.setUserAtestat(user.getAtestat());
            dto.setUserAvatar(user.getAvatar());

            dtos.add(dto);
        }
        model.addAttribute("dtos", dtos);
        return "list";
    }


    //Validator
    @Autowired
    UserValidator userValidator;
    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }







//    @RequestMapping(value = "user", method = RequestMethod.POST)
//    public  String addAbiturient(@ModelAttribute("emptyUser") User emptyUser){
//        userService.save(emptyUser);
//        return "list";
//    }

}
