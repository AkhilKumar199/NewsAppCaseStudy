package com.cg.exception;

public class TechnologyAlreadyExists extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
     //default constructor
    public TechnologyAlreadyExists() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Parameterized constructor
    public TechnologyAlreadyExists(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }


}