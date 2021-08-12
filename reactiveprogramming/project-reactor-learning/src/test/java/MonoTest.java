import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    void firstMono(){
        Mono.just("X")
                .log()
                .subscribe();
    }

    @Test
    void monoWithConsumer(){
        Mono.just("X")
                .log()
                .subscribe(s -> System.out.println(s));
    }

    @Test
    void monoWithDoOn(){
        Mono.just("X")
                .log()
                .doOnSubscribe(subs -> System.out.println("Subscribed: " + subs))
                .doOnRequest(request -> System.out.println("Request: " + request))
                .doOnSuccess(complete -> System.out.println("Complete: " + complete))
                .subscribe(s -> System.out.println(s));
    }

    @Test
    void emptyMono(){
        Mono.empty()
                .log()
                .subscribe(System.out::println);
    }

    @Test
    void emptyCompleteConsumerMono(){
        Mono.empty()
                .log()
                .subscribe(System.out::println, null, () -> System.out.println("Done"));
    }

    @Test
    void errorRuntimeExceptionMono(){
        Mono.error(new RuntimeException())
                .log()
                .subscribe(System.out::println,
                        e -> System.out.println("Error: " + e));
    }

    @Test
    void errorDoOnErrorMono(){
        Mono.error(new Exception())
                .doOnError(e -> System.out.println("Error: " + e))
                .log()
                .subscribe();
    }

    @Test
    void errorOnErrorResumeMono(){
        Mono.error(new Exception())
                .onErrorResume(e -> {
                    System.out.println("Caught: " + e);
                    return Mono.just("B");
                })
                .log()
                .subscribe(x -> System.out.println(x));
    }

    @Test
    void errorOnErrorReturnMono(){
        Mono.error(new Exception())
                .onErrorReturn("B")
                .log()
                .subscribe();
    }
}
