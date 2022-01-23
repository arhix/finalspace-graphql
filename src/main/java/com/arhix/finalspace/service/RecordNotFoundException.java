package com.arhix.finalspace.service;

public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(Integer id) {
        super(String.format("Record with id '%s' does not exist", id));
    }
}
