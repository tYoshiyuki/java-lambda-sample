package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

import java.util.Objects;

public class App implements RequestHandler<KinesisEvent, Object> {

    public Object handleRequest(KinesisEvent event, final Context context) {
        if (!Objects.isNull(event)) {
            event.getRecords().stream().forEach(r -> {
                String str = new String(r.getKinesis().getData().array());
                System.out.println(str);
            });
        }

        return null;
    }
}
