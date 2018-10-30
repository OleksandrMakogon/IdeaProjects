package Calculator;

class Password {
    private String expected;
    private Boolean isFound;

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
        }else
        {
            //System.out.println("Already found.");
        }
    }
    public synchronized Boolean getIsFound(){
        return this.isFound;
    }
}
