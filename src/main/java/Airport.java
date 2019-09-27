public enum Airport {

    AMS("Amsterdam"),
    EDI("Edinburgh"),
    LAX("Los Angeles International Airport");

    private final String fullName;


    Airport(String fullName){
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
