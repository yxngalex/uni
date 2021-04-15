package rs.ac.metropolitan.cs230;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+[a-zA-Z0-9-]+$");
        Matcher matcher = pattern.matcher(
                (CharSequence) value);
        HtmlInputText htmlInputText
                = (HtmlInputText) component;
        String label;

        if (htmlInputText.getLabel() == null
                || htmlInputText.getLabel().trim().equals("")) {
            label = htmlInputText.getId();
        } else {
            label = htmlInputText.getLabel();
        }

        if (!matcher.matches()) {
            FacesMessage facesMessage;
            facesMessage = new FacesMessage(label
                    + ": Email adresa nije ispravna");

            throw new ValidatorException(facesMessage);
        }
    }

    
}
