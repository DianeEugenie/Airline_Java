public enum PlaneType {

    CODECLAN100(2, 100),
    CODECLAN200(2, 200),
    CODECLAN300(5, 300),
    CODECLAN400(10, 400),
    CODECLAN500(5, 500);

    private final int capacity;
    private final int planeWeight;

    PlaneType(int capacity, int planeWeight) {
        this.capacity = capacity;
        this.planeWeight = planeWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPlaneWeight() {
        return planeWeight;
    }
}
