package com.correvate.exercise.zipper.model;

public enum Error {
    ZIP_CREATION_EXCEPTION("An error occurred generating zip File"),
    VALIDATION_ERROR_EMPTY_LIST("Input file list Empty"),
    LIMIT_SIZE_EXCEEDED_ERROR("The size of the files sent exceeds the limit."),
    GENERIC_ERROR("An Error occurred in transaction");

    private final String message;

    Error(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
