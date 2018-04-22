package com.java.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Temperature.class)
public class TemperatureConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String string) {
        boolean valid = true;
        String unit = null;
        int value = 0;

        if ((string.startsWith("F") || string.startsWith("C") || string.startsWith("f") || string.startsWith("c")) && string.length() >= 2) {
            unit = string.charAt(0) + "";
            String substring = string.substring(1, string.length());
            try {
                value = Integer.parseInt(substring);
            } catch (NumberFormatException ex) {
                valid = false;
            }
        } else if (string.length() >= 7) {
            String[] parts = string.split(" ");
            if ((parts[1].equals("Celcius") || parts[1].equals("Fahrenheit")) && parts.length == 2) {
                try {
                    value = Integer.parseInt(parts[0]);
                    unit = parts[1].charAt(0) + "";
                } catch (NumberFormatException ex) {
                    valid = false;
                }
            } else {
                valid = false;
            }

        } else {
            valid = false;
        }

        if (!valid) {
            FacesMessage message = Messages.getMessage("messages", "invalidTemperatureFormat", new Object[]{uiComponent.getAttributes().get("label"), string});
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return new Temperature(unit, value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        return object.toString();
    }

}
