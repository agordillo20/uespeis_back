package com.uespeis.utils;

public class EnumTypeForUse {
    public enum gender {
        MALE, FEMALE, NO_BINARY
    }

    public enum civil_status {
        SINGLE, MARRIED,LIVE_WITH_PARTNER, WIDOWED, DIVORCED, SEPARATED
    }

    public enum study{
        NO_STUDY,PRIMARY,SECONDARY,BACHILLERATO,FP,DEGREE
    }

    public enum employmentStatus{
        ACTIVE,HOUSEWORK,STUDENT,RETIRED,UNEMPLOYED
    }

    public enum rol {
        DEFAULT, CONSULTANT
    }

    public enum form_type {
        PRIMARY, SECONDARY
    }

    public enum archive_type {
        VIDEO, IMAGE, GIF, DOC, PDF
    }// can be more?
}
