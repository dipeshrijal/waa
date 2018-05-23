package com.java.jsf;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.IntegerConverter;
import java.io.IOException;
import java.util.Map;

@FacesComponent("com.java.jsf.Spinner")
public class UISpinner extends UIInput {

    private static final String MORE_BTN_VALUE = ".next";
    private static final String LESS_BTN_VALUE = ".prev";

    public UISpinner() {
        setConverter(new IntegerConverter());
        setRendererType(null);
    }

    private static Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new IllegalArgumentException("Cannot convert " + value);
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context);
        ResponseWriter writer = context.getResponseWriter();
        String clientId = getClientId(context);

        encodeInputField(writer, clientId);
        encodeDecrementButton(writer, clientId);
        encodeIncrementButton(writer, clientId);
    }

    @Override
    public void decode(FacesContext context) {
        super.decode(context);
        Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
        String cliendId = getClientId(context);

        int increment = 0;
        if (requestMap.containsKey(cliendId + MORE_BTN_VALUE)) {
            increment = 1;
        } else if (requestMap.containsKey(cliendId + LESS_BTN_VALUE)) {
            increment = -1;
        }

        try {

            int submittedValue = Integer.parseInt((String) requestMap.get(cliendId));
            int newValue = getIncrementedValue(submittedValue, increment);
            setSubmittedValue("" + newValue);

        } catch (NumberFormatException ex) {
            setSubmittedValue((String) requestMap.get(cliendId));
        }
    }

    private void encodeInputField(ResponseWriter writer, String clientId) throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, null);

        Object value = getValue();
        if (value != null) {
            writer.writeAttribute("value", value, "value");
        }

        Object size = getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }

        writer.endElement("input");
    }

    private void encodeDecrementButton(ResponseWriter writer, String clientId) throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + LESS_BTN_VALUE, null);
        writer.writeAttribute("value", "<<", "value");
        writer.endElement("input");
    }

    private void encodeIncrementButton(ResponseWriter writer, String clientId) throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + MORE_BTN_VALUE, null);
        writer.writeAttribute("value", ">>", "value");
        writer.endElement("input");
    }

    private int getIncrementedValue(int submittedValue, int increment) {
        Integer minimum = toInteger(getAttributes().get("minimum"));
        Integer maximum = toInteger(getAttributes().get("maximum"));
        int newValue = submittedValue + increment;

        if ((minimum == null || newValue >= minimum.intValue()) && (maximum == null || newValue <= maximum.intValue())) {
            return newValue;
        } else {
            if (minimum == null || newValue < minimum.intValue()) {
                return minimum.intValue();
            } else {
                return maximum.intValue();
            }
        }
    }
}
