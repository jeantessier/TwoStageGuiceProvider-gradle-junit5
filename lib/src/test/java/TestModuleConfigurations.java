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
import org.junit.Test;
import service.Service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestModuleConfigurations {
    private final Module genericModule = new GenericModule();

    @Test
    public void testGettingServiceUsingClient1() {
        Module client1Module = new Client1Module();
        Injector injector = Guice.createInjector(genericModule, client1Module);
        Service actualService = injector.getInstance(Key.get(Service.class, Names.named("client1")));
        assertThat(actualService.getState(), is(equalTo("client1")));
    }

    @Test
    public void testGettingServiceUsingClient2() {
        Module client2Module = new Client2Module();
        Injector injector = Guice.createInjector(genericModule, client2Module);
        Service actualService = injector.getInstance(Key.get(Service.class, Names.named("client2")));
        assertThat(actualService.getState(), is(equalTo("client2")));
    }

    @Test
    public void testGettingClientUsingClient1() {
        Module client1Module = new Client1Module();
        Injector injector = Guice.createInjector(genericModule, client1Module);
        Client actualClient = injector.getInstance(Client1.class);
        assertThat(actualClient.getService().getState(), is(equalTo("client1")));
    }

    @Test
    public void testGettingClientUsingClient2() {
        Module client2Module = new Client2Module();
        Injector injector = Guice.createInjector(genericModule, client2Module);
        Client actualClient = injector.getInstance(Client2.class);
        assertThat(actualClient.getService().getState(), is(equalTo("client2")));
    }
}
