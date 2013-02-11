
package uk.co.patrickcunningham.model.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("com.googlecode.jsonschema2pojo")
public class Context {

    private String in_hd;
    private String domain;
    private String is_signed;
    private String locale;
    private String is_dubbed_audio;
    private List<Bikini_state> bikini_states = new ArrayList<Bikini_state>();
    private String recipe;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIn_hd() {
        return in_hd;
    }

    public void setIn_hd(String in_hd) {
        this.in_hd = in_hd;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIs_signed() {
        return is_signed;
    }

    public void setIs_signed(String is_signed) {
        this.is_signed = is_signed;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getIs_dubbed_audio() {
        return is_dubbed_audio;
    }

    public void setIs_dubbed_audio(String is_dubbed_audio) {
        this.is_dubbed_audio = is_dubbed_audio;
    }

    public List<Bikini_state> getBikini_states() {
        return bikini_states;
    }

    public void setBikini_states(List<Bikini_state> bikini_states) {
        this.bikini_states = bikini_states;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
