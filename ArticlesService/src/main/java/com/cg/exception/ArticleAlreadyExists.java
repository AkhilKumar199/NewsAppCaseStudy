package com.cg.exception;

public class ArticleAlreadyExists extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
     //default constructor
    public ArticleAlreadyExists() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Parameterized constructor
    public ArticleAlreadyExists(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }


}