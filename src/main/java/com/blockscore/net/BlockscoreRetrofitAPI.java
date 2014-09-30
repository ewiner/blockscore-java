package com.blockscore.net;

import com.blockscore.models.*;
import org.jetbrains.annotations.NotNull;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

import java.util.List;

/**
 * Blockscore Java API interface.
 * Created by tealocean on 9/29/14.
 */
public interface BlockscoreRetrofitAPI {
    /**
     * Creates a new verification. The information for the person will be run through the
     * verification process and returned with additional information that will help you
     * determine the authenticity of the information given. <br />
     * Thread: Asynchronous <br />
     * @param person Person to verify.
     * @param callback Callback to use.
     */
    @POST("/verifications")
    void createVerification(@NotNull @Body final Person person, @NotNull final Callback<Verification> callback);

    /**
     * Creates a new verification. The information for the person will be run through the
     * verification process and returned with additional information that will help you
     * determine the authenticity of the information given. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @param person Person to verify.
     * @return Observable containing the verification results.
     */
    @NotNull
    @POST("/verifications")
    Observable<Verification> createVerification(@NotNull @Body final Person person);

    /**
     * Pulls up a single verification. This will return a record exactly as it was when you created it.
     * This route is useful for auditing purposes as you can provide proof that a verification
     * took place along with all of its associated data. <br />
     * Thread: Asynchronous <br />
     * @param id ID of verification to verify.
     * @param callback Callback to use.
     */
    @GET("/verifications/{id}")
    void getVerification(@NotNull @Path("id") String id, @NotNull final Callback<Verification> callback);

    /**
     * Pulls up a single verification. This will return a record exactly as it was when you created it.
     * This route is useful for auditing purposes as you can provide proof that a verification
     * took place along with all of its associated data. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @param id ID of verification to verify.
     */
    @NotNull
    @GET("/verifications/{id}")
    Observable<Verification> getVerification(@NotNull @Path("id") String id);

    /**
     * Gets a list of historical records for all verifications you have completed. Sorted
     * newest to oldest. <br />
     * Thread: Asynchronous <br />
     * @param callback Callback to use.
     */
    @GET("/verifications")
    void listVerifications(@NotNull final Callback<List<Verification>> callback);

    /**
     * Gets a list of historical records for all verifications you have completed. Sorted
     * newest to oldest. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     */
    @NotNull
    @GET("/verifications")
    Observable<List<Verification>> listVerifications();

    /**
     * This method will create a new question set to ask your users. You can call this endpoint multiple
     * times with the same verification ID and the questions asked as well as the order that everything
     * is presented in will be randomized. <br />
     * Thread: Asynchronous <br />
     * @param request Question set request.
     * @param callback Callback to use.
     */
    @POST("/questions")
    void createQuestionSet(@NotNull @Body final QuestionSetRequest request
            , @NotNull final Callback<QuestionSet> callback);

    /**
     * This method will create a new question set to ask your users. You can call this endpoint multiple
     * times with the same verification ID and the questions asked as well as the order that everything
     * is presented in will be randomized. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @param request Question set request.
     */
    @NotNull
    @POST("/questions")
    Observable<QuestionSet> createQuestionSet(@NotNull @Body final QuestionSetRequest request);

    /**
     * The scoring system will score it based on how many questions you submit, so if you would only like
     * to ask 3 questions, only submit the 3 questions which you would like scored. <br />
     * Thread: Asynchronous <br />
     * @param answers Question set request.
     * @param callback Callback to use.
     */
    @POST("/questions/{id}/score")
    void scoreQuestionSet(@Path("id") @NotNull final String questionSetId
            , @NotNull @Body final List<AnsweredQuestion> answers
            , @NotNull final Callback<QuestionSet> callback);

    /**
     * The scoring system will score it based on how many questions you submit, so if you would only like
     * to ask 3 questions, only submit the 3 questions which you would like scored. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @param answers Question set request.
     */
    @NotNull
    @POST("/questions/{id}/score")
    Observable<QuestionSet> scoreQuestionSet(@Path("id") @NotNull final String questionSetId
            , @NotNull @Body final List<AnsweredQuestion> answers);

    /**
     * This allows you to retrieve a question set you have created. If you have already scored the question
     * set, we will also return the last score of your submitted answers. <br />
     * Thread: Asynchronous <br />
     * @param questionSetId Question set ID.
     * @param callback Callback to use.
     */
    @GET("/questions/{id}")
    void retrieveQuestionSet(@Path("id") @NotNull final String questionSetId
            , @NotNull final Callback<QuestionSet> callback);

    /**
     * This allows you to retrieve a question set you have created. If you have already scored the question
     * set, we will also return the last score of your submitted answers. <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @param questionSetId Question set ID.
     */
    @NotNull
    @GET("/questions/{id}")
    Observable<QuestionSet> retrieveQuestionSet(@Path("id") @NotNull final String questionSetId);

    /**
     * Gets a list of historical records for all verifications you have completed. Sorted
     * newest to oldest. <br />
     * Thread: Asynchronous <br />
     * @param callback Callback to use.
     */
    @GET("/questions")
    void listQuestionSets(@NotNull final Callback<List<QuestionSet>> callback);

    /**
     * Allows you to see a historical record of all question sets that you have created.
     * The list is displayed in reverse chronological order (newer question sets appear first). <br />
     * Thread: Any [Determined by settings on Observable] <br />
     * @return List of question sets.
     */
    @NotNull
    @GET("/questions")
    Observable<List<QuestionSet>> listQuestionSets();
}
