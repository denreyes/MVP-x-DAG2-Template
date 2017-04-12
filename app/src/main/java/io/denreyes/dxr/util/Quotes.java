package io.denreyes.dxr.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DJ on 4/10/2017.
 */

public class Quotes {

    private Messages messages;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
