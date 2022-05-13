package com.cg.exception;

public class NewsAlreadyExists extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
     //default constructor
    public NewsAlreadyExists() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Parameterized constructor
    public NewsAlreadyExists(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }


}