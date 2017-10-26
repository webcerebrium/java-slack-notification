package com.webcerebrium.slack;

import com.google.common.collect.ImmutableSet;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Notification {

    String channelUrl;

    /**
     * Constructor that is used when we want to initialize slack notifciation URL from some properties
     */
    public Notification() {
        NotificationConfig config = new NotificationConfig();
        channelUrl = config.getVariable("SLACK_NOTIFICATION_URL");
        log.info("channelUrl={}", channelUrl);
    }

    /**
     * Constructor which is used when we know the channel URL exactly
     * @param channelUrl URL from income webkooks, i.e https://hooks.slack.com/services/T00000000/B0000000/HGBHWuJLDoJYtecT58hszOdt
     */
    public Notification(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    /**
     * Sending the message
     * @param message message object
     */
    public String send(SlackMessage message) throws NotificationException {
        SlackRequest request = new SlackRequest();
        return request.connect(channelUrl).post().payload(message.toJson()).read().getLastResponse();
    }

}