package com.blockscore.net;

import com.blockscore.common.Constants;
import com.blockscore.exceptions.NoApiKeyFoundException;
import com.blockscore.models.Person;
import com.blockscore.models.QuestionSet;
import com.blockscore.models.QuestionSetRequest;
import com.blockscore.models.Verification;
import org.jetbrains.annotations.NotNull;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;
import rx.Observable;

import java.util.Base64;
import java.util.List;

/**
 * The Blockscore Java API client.
 * Created by tealocean on 9/29/14.
 */
public class BlockscoreApiClient {
    private static RestAdapter.LogLevel sLogLevel = RestAdapter.LogLevel.NONE;
    private static String sApiKey;

    private BlockscoreRetrofitAPI restAdapter;

    /**
     * Initializes the API client with the API key. Must be done first or else all calls will fail.
     * @param apiKey API key to use.
     */
    public static void init(@NotNull final String apiKey) {
        sApiKey = apiKey + ":";
    }

    /**
     * Turns on/off logging. Should be done after init(), but before API client usage.
     */
    public static void useVerboseLogs(final boolean useVerboseLogs) {
        if (useVerboseLogs) {
            sLogLevel = RestAdapter.LogLevel.FULL;
        }
    }

    public BlockscoreApiClient() {
        RestAdapter.Builder restBuilder = new RestAdapter.Builder()
                .setClient(new OkClient())
                .setConverter(new JacksonConverter())
                .setEndpoint(Constants.getDomain());

        //Sets up the authentication headers and accept headers.
        restBuilder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader(Constants.AUTHORIZATION_HEADER, getEncodedAuthorization());
                request.addHeader(Constants.ACCEPT_HEADER, Constants.getAcceptHeaders());
            }
        });

        restBuilder.setLogLevel(sLogLevel);
        restAdapter = restBuilder.build().create(BlockscoreRetrofitAPI.class);
    }

    /**
     * Creates a new verification.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#createVerification(com.blockscore.models.Person, retrofit.Callback)
     * @param person Person to verify.
     * @param callback Callback to use.
     */
    public void createVerification(@NotNull final Person person, @NotNull final Callback<Verification> callback) {
        restAdapter.createVerification(person, callback);
    }

    /**
     * Creates a new verification.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#createVerification(com.blockscore.models.Person)
     * @param person Person to verify.
     * @return Observable containing the verification results.
     */
    @NotNull
    public Observable<Verification> createVerification(@NotNull final Person person) {
        return restAdapter.createVerification(person);
    }

    /**
     * Pulls up a single verification.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#getVerification(String, retrofit.Callback)
     * @param id ID of verification to verify.
     * @param callback Callback to use.
     */
    public void getVerification(@NotNull final String id, final Callback<Verification> callback) {
        restAdapter.getVerification(id, callback);
    }

    /**
     * Pulls up a single verification.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#getVerification(String)
     * @param id ID of verification to verify.
     * @return Observable containing the verification results.
     */
    @NotNull
    public Observable<Verification> getVerification(@NotNull final String id) {
        return restAdapter.getVerification(id);
    }

    /**
     * Gets a list of verifications.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#listVerifications(retrofit.Callback)
     * @param callback Callback to use.
     */
    public void listVerifications(@NotNull final Callback<List<Verification>> callback) {
        restAdapter.listVerifications(callback);
    }

    /**
     * Gets a list of verifications.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#listVerifications()
     * @return Observable containing the list of verification results.
     */
    @NotNull
    public Observable<List<Verification>> listVerifications() {
        return restAdapter.listVerifications();
    }

    /**
     * Creates a question set.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#createQuestionSet(com.blockscore.models.QuestionSetRequest, retrofit.Callback)
     * @param request Question set request.
     * @param callback Callback to use.
     */
    public void createQuestionSet(@NotNull final QuestionSetRequest request
            , @NotNull final Callback<QuestionSet> callback) {
        restAdapter.createQuestionSet(request, callback);
    }

    /**
     * Creates a question set.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#createQuestionSet(com.blockscore.models.QuestionSetRequest)
     * @param request Question set request.
     * @return Observable containing the question set.
     */
    @NotNull
    public Observable<QuestionSet> createQuestionSet(@NotNull final QuestionSetRequest request) {
        return restAdapter.createQuestionSet(request);
    }

    /**
     * This allows you to retrieve a question set you have created.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#retrieveQuestionSet(String, retrofit.Callback)
     * @param questionSetId Question set ID
     * @param callback Callback to use.
     */
    public void retrieveQuestionSet(@NotNull final String questionSetId
            , @NotNull final Callback<QuestionSet> callback) {
        restAdapter.retrieveQuestionSet(questionSetId, callback);
    }

    /**
     * This allows you to retrieve a question set you have created.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#retrieveQuestionSet(String)
     * @param questionSetId Question set ID
     * @return Observable containing the question set.
     */
    public Observable<QuestionSet> retrieveQuestionSet(@NotNull final String questionSetId) {
        return restAdapter.retrieveQuestionSet(questionSetId);
    }

    /**
     * This allows you to retrieve a question set you have created.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#listQuestionSets(retrofit.Callback)
     * @param callback Callback to use.
     */
    public void listQuestionSet(@NotNull final Callback<List<QuestionSet>> callback) {
        restAdapter.listQuestionSets(callback);
    }

    /**
     * This allows you to retrieve a question set you have created.
     * @see com.blockscore.net.BlockscoreRetrofitAPI#retrieveQuestionSet(String)
     * @return Observable containing the question set.
     */
    @NotNull
    public Observable<List<QuestionSet>> listQuestionSet() {
        return restAdapter.listQuestionSets();
    }

    /**
     * Encodes the API key for Basic authentication.
     * @return API key encoded with Base 64.
     */
    @NotNull
    private String getEncodedAuthorization() {
        if (sApiKey == null || sApiKey.isEmpty()) {
            throw new NoApiKeyFoundException();
        }
        return "Basic " + Base64.getEncoder().encodeToString(sApiKey.getBytes());
    }
}
