package gevak.validator;


import gevak.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    private int p1;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getSurName().isEmpty()) {
            errors.rejectValue("surName", "error", "Empty property");
        }else if(user.getName().isEmpty()) {
            errors.rejectValue("name", "error", "Empty property");
        }else if (user.getP1() <100 || user.getP1()>200 ) {
            errors.rejectValue("p1", "error", "Enter value from 100 to 200");
        }else if (user.getP2() <100 || user.getP2()>200 ) {
            errors.rejectValue("p2", "error", "Enter value from 100 to 200");
        }else if (user.getP3() <100 || user.getP3()>200 ) {
            errors.rejectValue("p3", "error", "Enter value from 100 to 200");
        }else if (user.getAtestat() <100 || user.getAtestat()>200 ) {
            errors.rejectValue("atestat", "error", "Enter value from 100 to 200");
        }
    }
}
