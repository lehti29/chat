package dsv.pis.chat.client;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

//import static java.util.concurrent.TimeUnit.*;

/**
 * Created by emillehti on 2017-01-22.
 */
public class ChatAFK {

    private final ScheduledExecutorService controller = Executors.newScheduledThreadPool(1);
    //private String name;

    public void checkAFK(){
        /*final Runnable checker = new Runnable() {
            @Override
            public void run() {
                System.out.println("Sry guys afk");
            }
        };

        final ScheduledFuture<?> afkHandle = controller.schedule(checker, 20, java.util.concurrent.TimeUnit.SECONDS);
        controller.schedule(new Runnable(){
            public void run() {afkHandle.cancel(true); }
        }, 20, java.util.concurrent.TimeUnit.SECONDS);*/
    }

}
