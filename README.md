# Slack Notification

This library can be used to send Notification to the slack channel using Incoming URL hooks like this
```https://hooks.slack.com/services/T00000000/B0000000/HGBHWuJLDoJYtecT58hszOdt```

## Getting Started

#### with Maven

Add the following Maven dependency to your project's `pom.xml`:
```
<dependency>
  <groupId>com.webcerebrium</groupId>
  <artifactId>slack-notification</artifactId>
  <version>0.1.0</version>
</dependency>
```

#### with Gradle
```
compile group: 'com.webcerebrium', name: 'slack-notification', version: '0.1.0'
```

#### with Grapes
```
@Grapes([ 
@Grab(group = 'com.webcerebrium', module = 'slack-notification', version = '0.1.0')
])
```

## Example of Application
```
import com.webcerebrium.slack.Notification;

SlackMessage message = new SlackMessage();
SlackMessageAttachment attach = new SlackMessageAttachment("Something saved", "Some body", "#c0FFF0");
attach.addMarkdown(ImmutableSet.of("title", "text"));
message.getAttachments().add(attach);
(new Notification()).send(message);
```

# License
MIT. Anyone can copy, change, derive further work from this repository without any restrictions.
