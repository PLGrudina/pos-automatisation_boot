package ua.automatisationInc.pos.exceptions;

import java.time.LocalDateTime;

/**
 * Created by Pavel Grudina on 27.03.2018.
 */
public class BillNotFoundEx extends ItemNotFoundEx {

    private String info = "Bill not found in database";

    public BillNotFoundEx() {

    }

    BillNotFoundEx(Long id) {
        info = LocalDateTime.now() + "Bill id " + id + " not found in database";
    }

    public String getInfo() {
        return info;
    }
}

