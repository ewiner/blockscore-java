package com.blockscore.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Question set request model. Used in creation of question sets.
 * Created by Tony Dieppa on 9/30/14.
 */
public class QuestionSetRequest {

    @NotNull
    @JsonProperty("verification_id")
    private String mVerificationId;

    @JsonProperty("time_limit")
    private long mTimeLimit = 0L;

    /**
     * The ID of the verification, and thus the identity, on which to base the question sets.
     * You can create multiple question sets using the same question set ID.
     * @param verificationId Verification ID
     * @return this
     */
    @NotNull
    public QuestionSetRequest setVerificationId(@NotNull final String verificationId) {
        mVerificationId = verificationId;
        return this;
    }

    /**
     * How long after creating a question set that the expired boolean will remain false.
     * This is inputted in seconds and defaults to 0, which means no time limit.
     * This allows you to make sure that your customer does not take too long to answer a question set.
     * @param timeLimit Time limit.
     * @return this
     */
    @NotNull
    public QuestionSetRequest setTimeLimit(final long timeLimit) {
        mTimeLimit = timeLimit;
        return this;
    }

    /**
     * Gets the verification ID set to this request.
     * @return Verification ID
     */
    @Nullable
    public String getVerificationId() {
        return mVerificationId;
    }

    /**
     * Gets the time limit set to this request.
     * @return Time limit.
     */
    public long getTimeLimit() {
        return mTimeLimit;
    }
}
