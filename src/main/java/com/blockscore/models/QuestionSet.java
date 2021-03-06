package com.blockscore.models;

import com.blockscore.models.base.BasicResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Question set model.
 * Created by Tony Dieppa on 9/29/14.
 */
public class QuestionSet extends BasicResponse {
    @NotNull
    @JsonProperty("verification_id")
    private String mVerificationId;

    @JsonProperty("score")
    private int mScore;

    @JsonProperty("expired")
    private boolean mExpired;

    @JsonProperty("time_limit")
    private long mTimeLimit;

    @NotNull
    @JsonProperty("questions")
    private List<Question> mQuestionSet;

    /**
     * The ID of the verification, and thus the identity, on which to base the question sets.
     * @return Verification ID for this question set.
     */
    @NotNull
    public String getVerificationId() {
        return mVerificationId;
    }

    /**
     * Score for the question set.
     * @return Score
     */
    public int getScore() {
        return mScore;
    }

    /**
     * Determines if this set has been expired.
     * @return True if expired.
     */
    public boolean isExpired() {
        return mExpired;
    }

    /**
     * Gets the time limit (in seconds).
     * @return Time limit.
     */
    public long getTimeLimit() {
        return mTimeLimit;
    }

    /**
     * Returns the list of questions to use.
     * @return Questions available.
     */
    @NotNull
    public List<Question> getQuestionSet() {
        return mQuestionSet;
    }
}
