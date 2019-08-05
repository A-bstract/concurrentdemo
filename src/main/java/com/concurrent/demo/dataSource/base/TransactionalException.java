package com.concurrent.demo.dataSource.base;

public abstract class TransactionalException extends Exception {

    private static final long serialVersionUID = -7035498848577048685L;

    private String errCode;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
