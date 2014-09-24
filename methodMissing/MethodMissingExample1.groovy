abstract class Channel {
    void sendNewFollower(String username, String follower) { }
    void sendNewMessage(String username, String msg) { }
}

class EmailChannel extends Channel {
    void sendNewFollower(String username, String follower) {
        println "Sending email notification to '${username}' for new follower '${follower}'"
    }
    void sendNewMessage(String username, String msg) {
        println "Sending email notification to '${username}' for new message '${msg}'"
    }
}

class MobilePushChannel extends Channel {
    void sendNewFollower(String username, String follower) {
        println "Sending mobile push notification to '${username}' for new follower '${follower}'"
    }
}



class NotificationService {

    List channels = []

    def methodMissing(String name, args) {
        System.out.println "...methodMissing called for ${name} with args ${args}"

        // Generate the implementation
        def implementation = { Object[] methodArgs ->
            channels.each { channel ->
                def metaMethod = channel.metaClass.getMetaMethod(name, methodArgs)
                return metaMethod.invoke(channel, methodArgs)
            }
        }
        // Cache the implementation in the metaClass
        NotificationService instance = this
        instance.metaClass."$name" = implementation

        // Execute it!
        implementation(args)
    }
}


def notificationService = new NotificationService(
    channels: [new EmailChannel(), new MobilePushChannel()]
)

assert !notificationService.respondsTo('sendNewFollower', String, String)
notificationService.sendNewFollower("John", "Peter")
assert notificationService.respondsTo('sendNewFollower', String, String)

notificationService.sendNewFollower("Mary", "Steve")

notificationService.sendNewMessage("Iván", "Hello!")