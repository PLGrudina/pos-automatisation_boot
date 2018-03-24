package ua.automatisationInc.pos.controller.editors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
public class LocalDateEditor extends PropertyEditorSupport {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    public String getAsText() {
        Object value = getValue();
        if (value == null) {
            return "";
        } else {
            LocalDate localDate = (LocalDate) value;
            return localDate.format(formatter);
        }
    }

        @Override
        public void setAsText (String text){
            if (text == null) {
                setValue(null);
            } else {
                String value = text.trim();
                if ("".equals(value)) {
                    setValue(null);
                } else {
                    LocalDate result = LocalDate.parse(text, formatter);
                    setValue(result);
                }
            }
        }
    }
