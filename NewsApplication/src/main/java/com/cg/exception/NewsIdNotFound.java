package com.cg.exception;

public class NewsIdNotFound extends Exception {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NewsIdNotFound() 
    {
       super();
       
       }

    public NewsIdNotFound(String message) 
    {
    	
       super(message);
       
    }




}