import client1.Client1;
import client1.Client1Module;
import client2.Client2;
import client2.Client2Module;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.name.Names;
import generic.Client;
import generic.GenericModule;
import org.junit.jupiter.api.Test;
import service.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleConfigurationTests {
    private final Module genericModule = new GenericModule();

    @Test
    void gettingServiceUsingClient1() {
        Module client1Module = new Client1Module();
        Injector injector = Guice.createInjector(genericModule, client1Module);
        Service actualService = injector.getInstance(Key.get(Service.class, Names.named("client1")));
        assertEquals("client1", actualService.getState());
    }

    @Test
    void gettingServiceUsingClient2() {
        Module client2Module = new Client2Module();
        Injector injector = Guice.createInjector(genericModule, client2Module);
        Service actualService = injector.getInstance(Key.get(Service.class, Names.named("client2")));
        assertEquals("client2", actualService.getState());
    }

    @Test
    void gettingClientUsingClient1() {
        Module client1Module = new Client1Module();
        Injector injector = Guice.createInjector(genericModule, client1Module);
        Client actualClient = injector.getInstance(Client1.class);
        assertEquals("client1", actualClient.getService().getState());
    }

    @Test
    void gettingClientUsingClient2() {
        Module client2Module = new Client2Module();
        Injector injector = Guice.createInjector(genericModule, client2Module);
        Client actualClient = injector.getInstance(Client2.class);
        assertEquals("client2", actualClient.getService().getState());
    }
}
