package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;

@FacesValidator
public class CompanyValidator implements Validator {
    private String[] companyNames = {
            "Mojang", "Riot Games", "Blizzard Entertainment", "Grinding Gear Games", "Valve"
    };

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object name){
        if(!Arrays.asList(companyNames).contains(name)){
            FacesMessage msg = new FacesMessage("Game company should be one of the following: " + Arrays.toString(companyNames));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
