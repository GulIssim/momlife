package kz.vienna.momlife.util;

public enum PregnancyStatus {

        ACTIVE("active"),
        SUCCESS("success"),
        COMPLICATION("complication"),
        ABORTION("abortion");

    private final String status;

    PregnancyStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
