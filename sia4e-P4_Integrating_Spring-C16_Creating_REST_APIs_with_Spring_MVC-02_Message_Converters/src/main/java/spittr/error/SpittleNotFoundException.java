package spittr.error;

public class SpittleNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2618420166836567451L;

    private long spittleId;

    public SpittleNotFoundException(long spittleId) {
        this.spittleId = spittleId;
    }

    public long getSpittleId() {
        return spittleId;
    }
}
