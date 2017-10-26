package com.webcerebrium.slack;


import com.google.common.base.Strings;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.Set;

@Data
public class SlackMessageAttachment {
    public String title = "";
    public String text = "";
    public String color = "#888";
    public JsonArray markdown = new JsonArray();

    public SlackMessageAttachment() {
    }

    public SlackMessageAttachment(String title, String text, String color) {
        this.title = title;
        this.text = text;
        this.color = color;
    }

    public SlackMessageAttachment addMarkdown(Set<String> m) {
        for (String s: m) {
            this.markdown.add(s);
        }
        return this;
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        if (!Strings.isNullOrEmpty(title)) obj.addProperty("title", title);
        if (!Strings.isNullOrEmpty(text)) obj.addProperty("text", text);
        if (!Strings.isNullOrEmpty(color)) obj.addProperty("color", color);
        if (markdown != null && markdown.size() > 0) obj.add("mrkdwn_in", getMarkdown());
        return obj;
    }
}
