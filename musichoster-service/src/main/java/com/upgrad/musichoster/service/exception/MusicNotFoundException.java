package com.upgrad.musichoster.service.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class MusicNotFoundException extends Exception {


    private final String code;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    private final String errorMessage;
    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }


    public MusicNotFoundException(final String code, final String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }


    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }


}
