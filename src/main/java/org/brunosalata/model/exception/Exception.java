package org.brunosalata.model.exception;

/**
 * @author Bruno Salata Lima - 16/05/2023
 * github.com/Brunosalata
 * @version 2.0.3
 * @project mBioLabv3
 */
public class Exception extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public Exception (String msg) {
        super(msg);
    }

}
