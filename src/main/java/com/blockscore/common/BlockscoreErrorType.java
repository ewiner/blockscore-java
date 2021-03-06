package com.blockscore.common;

import org.jetbrains.annotations.NotNull;

/**
 * Error Types enum
 * Created by Tony Dieppa on 10/1/14.
 */
public enum BlockscoreErrorType {
    INVALID("invalid_request_error"), API("api_error"), UNKNOWN("unknown");

    private final String mValue;

    private BlockscoreErrorType(@NotNull final String value) {
        mValue = value;
    }

    /**
     * Returns if this status matches.
     * @param value Value to test
     * @return True or false.
     */
    public boolean isEqualTo(final String value) {
        return mValue.equalsIgnoreCase(value);
    }

    /**
     * Converts a string to a enum.
     * @param value Value to convert.
     * @return Enum for this value.
     */
    @NotNull
    public static BlockscoreErrorType toEnum(@NotNull final String value) {
        if (value.equalsIgnoreCase(INVALID.toString())) {
            return INVALID;
        } else if (value.equalsIgnoreCase(API.toString())) {
            return API;
        } else {
            return UNKNOWN;
        }
    }

    /**
     * Converts an enum to the string value.
     * @return String value for enum.
     */
    @Override
    public String toString() {
        return mValue;
    }
}
