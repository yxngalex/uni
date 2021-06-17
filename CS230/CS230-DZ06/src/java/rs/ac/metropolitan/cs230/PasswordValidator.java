package rs.ac.metropolitan.cs230;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class PasswordValidator implements Validator {
/*
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();
        
        String conf_password = (String) value;

        if(password == null || conf_password == null || !password.equals(repeated_password)){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password : ", "morate ponovo uneti password u polje za ponovni unos password-a.");
            throw new ValidatorException(msg);
        }
    }
*/
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String confirmPassword = (String) value;

        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password ERROR : ", "morate ponovo uneti password u polje za ponovni unos password-a.");
            throw new ValidatorException(msg);
        }
    }
}
