package com.devsuperior.dslearnbds.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OauthCustomError implements Serializable {

    private String error;

    @JsonProperty(value = "error_description")  //Annotation para alterar o valor de saida para json
    private String errorDescription;

    public OauthCustomError(){
    }

    public OauthCustomError(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
