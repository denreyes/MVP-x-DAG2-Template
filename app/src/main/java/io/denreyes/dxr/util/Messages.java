package io.denreyes.dxr.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messages {

    private List<String> personalized = null;
    private List<String> nonPersonalized = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getPersonalized() {
        return personalized;
    }

    public void setPersonalized(List<String> personalized) {
        this.personalized = personalized;
    }

    public List<String> getNonPersonalized() {
        return nonPersonalized;
    }

    public void setNonPersonalized(List<String> nonPersonalized) {
        this.nonPersonalized = nonPersonalized;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}