package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;

@FacesValidator
public class GamesValidator implements Validator {
    private String[] gamesNames = {
            "Diablo", "World of Warcraft", "Path of Exile", "League of Legends", "Counter Strike GO", "Valorant", "Minecraft"
    };

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object name){
        if(!Arrays.asList(gamesNames).contains(name)){
            FacesMessage msg = new FacesMessage("Game title should be chosen from the following: " + Arrays.toString(gamesNames));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
