package app.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/ws/message")
public class MessageEndpoint {
    private final static Logger logger = LoggerFactory.getLogger(MessageEndpoint.class);

    @OnOpen
    public void onOpen(Session session) {

        logger.info("啊啦拉");
    }

}
