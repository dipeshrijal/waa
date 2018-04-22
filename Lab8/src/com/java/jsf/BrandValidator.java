package com.java.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.Locale;

@FacesValidator("brandValidator")
public class BrandValidator implements Validator {

    private String errorSummary;
    private String errorDetail;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        if (value == null) return;
        String brandName = (String) value;

        Locale locale = facesContext.getViewRoot().getLocale();
        Object[] params = new Object[]{value};

        FacesMessage message = Messages.getMessage("messages", "invalidBrand", null);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);

        if (!(brandName.toLowerCase().equals("bmw") || brandName.toLowerCase().equals("mercedes"))) {
            if (errorSummary != null) {
                message.setSummary(new MessageFormat(errorSummary, locale).format(params));
            }
            if (errorDetail != null) {
                message.setDetail(new MessageFormat(errorDetail, locale).format(params));
            }
            throw new ValidatorException(message);
        }

    }

    public void setErrorSummary(String errorSummary) {
        this.errorSummary = errorSummary;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
