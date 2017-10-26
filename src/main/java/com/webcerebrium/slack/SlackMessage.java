package com.webcerebrium.slack;


import com.google.common.base.Strings;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Currently it supports the very simple messages / attachments
 *
 * More detailed description could be found at
 * https://api.slack.com/custom-integrations
 *
 */
@Data
public class SlackMessage {
    public String text;
    public List<SlackMessageAttachment> attachments = new LinkedList<>();

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        if (!Strings.isNullOrEmpty(text)) obj.addProperty("text", text);

        if (attachments != null && attachments.size() > 0) {
            JsonArray arrAttachments = new JsonArray();
            for (SlackMessageAttachment msg: attachments) {
                arrAttachments.add(msg.toJson());
            }
            obj.add("attachments", arrAttachments);
        }
        return obj;
    }
}
