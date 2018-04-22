package com.java.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("priceValidator")
public class PriceValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        if (value == null) return;
        double amount = (double) value;

        Object[] params = new Object[]{value};

        FacesMessage minimumMessage = Messages.getMessage("messages", "invalidMinimumAmount", params);
        FacesMessage maximumMessage = Messages.getMessage("messages", "invalidMaximumAmount", params);
        minimumMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        maximumMessage.setSeverity(FacesMessage.SEVERITY_ERROR);

        if (amount < 1) {
            throw new ValidatorException(minimumMessage);
        } else if (amount > 100000) {
            throw new ValidatorException(maximumMessage);
        }

    }

}
