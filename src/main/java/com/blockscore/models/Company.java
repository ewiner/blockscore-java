package com.blockscore.models;

import com.blockscore.common.CorporationType;
import com.blockscore.common.ValidityStatus;
import com.blockscore.models.base.BasicResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Model object for a company
 * Created by Tony Dieppa on 9/30/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends BasicResponse {
    @Nullable
    @JsonProperty("status")
    private ValidityStatus mStatus;

    @NotNull
    @JsonProperty("entity_name")
    private String mEntityName;

    @NotNull
    @JsonProperty("tax_id")
    private String mTaxId;

    @Nullable
    @JsonProperty("incorp_date")
    private String mIncorpDate;

    @Nullable
    @JsonProperty("incorp_state")
    private String mIncorpState;

    @NotNull
    @JsonProperty("incorp_country_code")
    private String mIncorpCountryCode;

    @NotNull
    @JsonProperty("incorp_type")
    private String mIncorpType;

    @NotNull
    @JsonProperty("dbas")
    private String mDbas;

    @NotNull
    @JsonProperty("registration_number")
    private String mRegNumber;

    @NotNull
    @JsonProperty("email")
    private String mEmail;

    @NotNull
    @JsonProperty("url")
    private String mURL;

    @Nullable
    @JsonProperty("phone_number")
    private String mPhoneNumber;

    @Nullable
    @JsonProperty("ip_address")
    private String mIPAddress;

    @NotNull
    @JsonProperty("address")
    private Address mAddress;

    @NotNull
    @JsonProperty("details")
    private Details mDetails;

    /**
     * Returns the validity status for this company.
     * @return Validity status.
     */
    @Nullable
    public ValidityStatus getStatus() {
        if (mStatus == null) {
            System.out.println("Not yet validated with Blockscore.");
        }
        return mStatus;
    }

    /**
     * Returns the name of the entity.
     * @return Name of the entity.
     */
    @NotNull
    public String getEntityName() {
        return mEntityName;
    }

    /**
     * Name of entity. This should exclude any legal endings like "Co" or "Inc" for best results.
     * @param entityName Name
     */
    @NotNull
    public Company setEntityName(@NotNull final String entityName) {
        mEntityName = entityName;
        return this;
    }

    /**
     * Tax ID associated with this entity.
     * @return Tax ID
     */
    @NotNull
    public String getTaxId() {
        return mTaxId;
    }

    /**
     * Sets the Tax ID for this entity. The tax ID should only include the digits of the ID with
     * no extraneous characters like dashes.
     * @param mTaxId Tax ID
     */
    @NotNull
    public Company setTaxId(@NotNull final String mTaxId) {
        this.mTaxId = mTaxId;
        return this;
    }

    /**
     * Returns the date of incorporation.
     * @return Incorporation date.
     */
    @Nullable
    public String getIncorpDate() {
        return mIncorpDate;
    }

    /**
     * Sets the incorporation date. Should be of the ISO date form (YYYY-MM-DD)
     * @param mIncorpDate Incorporation date.
     */
    @NotNull
    public Company setIncorpDate(@NotNull final String mIncorpDate) {
        this.mIncorpDate = mIncorpDate;
        return this;
    }

    /**
     * Gets the incorporation state. Can be either of ISO code form or the full length name of the state.
     * @return Incorporation state.
     */
    @Nullable
    public String getIncorpState() {
        return mIncorpState;
    }

    /**
     * Sets the incorporation state. Can be either of ISO code form or the full length name of the state.
     * @param incorpState Incorporation state.
     */
    @NotNull
    public Company setIncorpState(@NotNull final String incorpState) {
        mIncorpState = incorpState;
        return this;
    }

    /**
     * Gets the incorporation country code. Should be of the ISO alpha-2 code form.
     * @return Incorporation country code.
     */
    @NotNull
    public String getIncorpCountryCode() {
        return mIncorpCountryCode;
    }

    /**
     * Sets the incorporation country code. Should be of the ISO alpha-2 code form.
     * @param incorpCountryCode Country code.
     */
    @NotNull
    public Company setIncorpCountryCode(@NotNull final String incorpCountryCode) {
        mIncorpCountryCode = incorpCountryCode;
        return this;
    }

    /**
     * Gets the corporation type. The type of legal business entity that this company
     * is such as a Limited Liability Company.
     * @return Corporation type.
     */
    @NotNull
    public CorporationType getIncorpType() {
        return CorporationType.valueOf(mIncorpType);
    }

    /**
     * Sets the corporation type.
     * @param incorpType Corporation type.
     */
    public void setIncorpType(@NotNull final CorporationType incorpType) {
        mIncorpType = incorpType.toString();
    }

    /**
     * A list of "doing business as" names, which are other names this business may be known by.
     * @return List of DBA names.
     */
    @NotNull
    public String[] getDbas() {
        return mDbas.split(",");
    }

    /**
     * Sets the "doing business as" names.
     * @param mDbas Doing business as names.
     */
    public void setDbas(@NotNull final String mDbas) {
        this.mDbas = mDbas;
    }

    /**
     * Gets the registration number. This is the number typically provided by the state of
     * incorporation which is assigned to a business.
     * @return Registration number.
     */
    @NotNull
    public String getRegNumber() {
        return mRegNumber;
    }

    /**
     * Sets the registration number for this entity.
     * @param regNumber Registration number.
     */
    public Company setRegNumber(@NotNull final String regNumber) {
        mRegNumber = regNumber;
        return this;
    }

    /**
     * Gets the email for this entity.
     * @return Email.
     */
    @NotNull
    public String getEmail() {
        return mEmail;
    }

    /**
     * Sets the email for this entity.
     * @param email Email for the entity.
     */
    public Company setEmail(@NotNull final String email) {
        mEmail = email;
        return this;
    }

    /**
     * Gets the URL for the entity.
     * @return URL.
     */
    @NotNull
    public String getURL() {
        return mURL;
    }

    /**
     * Sets the URL for this business
     * @param url URL for the business
     */
    public void setURL(@NotNull final String url) {
        mURL = url;
    }

    /**
     * Gets a company's phone number.
     * @return Phone number.
     */
    @Nullable
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * Sets a person's phone number.
     * @param phoneNumber Phone number for this individual.
     * @return this.
     */
    @NotNull
    public Company setPhoneNumber(@Nullable final String phoneNumber) {
        mPhoneNumber = phoneNumber;
        return this;
    }

    /**
     * Gets a company's IP address.
     * @return IP address.
     */
    @Nullable
    public String getIPAddress() {
        return mIPAddress;
    }

    /**
     * Sets a person's IP address.
     * @param ipAddress IP address to associate with this individual.
     * @return this.
     */
    @NotNull
    public Company setIPAddress(@Nullable final String ipAddress) {
        mIPAddress = ipAddress;
        return this;
    }

    /**
     * Gets the address of the entity.
     * @return Address.
     */
    @NotNull
    public Address getAddress() {
        return mAddress;
    }

    /**
     * Sets the address of the entity.
     * @param address Address to use.
     */
    public Company setAddress(@NotNull Address address) {
        mAddress = address;
        return this;
    }

    /**
     * A breakdown of some of the information that determines the status element.
     * @return Details breakdown.
     */
    @NotNull
    public Details getDetails() {
        return mDetails;
    }
}
