package cabbieManager;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Classe para transformar o biblioteca em local date time para não dar bug no unmasheler.
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    // Define o formato dd-MM-yyyy HH:mm
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    /**
     * Transforma a String em LocalDateTime
     * @param v é uma string com o formato de LocalDateTime
     * @return uma LocalDateTime no formato da String
     */
    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return (v != null) ? LocalDateTime.parse(v, formatter) : null;
    }
    /**
     * Transforma a String em LocalDateTime
     * @param v LocalDateTime para ser transformado
     * @return String com o formato dd-MM-yyyy HH:mm
     */
    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return (v != null) ? v.format(formatter) : null;
    }
}
