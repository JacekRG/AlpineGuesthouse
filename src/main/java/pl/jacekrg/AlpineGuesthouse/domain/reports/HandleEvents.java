package pl.jacekrg.AlpineGuesthouse.domain.reports;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.jacekrg.AlpineGuesthouse.domain.reservation.events.TempReservationCreatedEvent;

@Component
public class HandleEvents {

    @Async
    @EventListener
    public void handleTempReservationCreatedEvent(TempReservationCreatedEvent event) {
        System.out.println("Handle event by adnotation");
    }

}