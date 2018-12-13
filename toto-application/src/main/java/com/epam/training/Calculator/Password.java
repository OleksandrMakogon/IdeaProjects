package com.epam.training.Calculator;

class Password {
    private String expected;
    private volatile boolean isFound;

    public Password(String expected) {
        this.expected = expected;
        this.isFound = false;
        System.out.println("Expected hash: " + expected);
        //System.out.println("Found: " + isFound);
    }
    public synchronized void stop(String hash, String originalPassword){
        if (!this.isFound){
            if (hash.equals(expected)){
                this.isFound = true;
                System.out.println("Password is found: " + originalPassword);
            }
        }
    }
    public synchronized boolean getIsFound(){
        return this.isFound;
    }
}
