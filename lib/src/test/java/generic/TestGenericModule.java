package generic;

import org.junit.Test;
import service.Service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGenericModule {
    private final GenericModule sut = new GenericModule();

    @Test
    public void testProvideService() {
        Service actualService = sut.provideService();
        assertThat(actualService, is(notNullValue()));
        assertThat(actualService.getState(), is(equalTo("generic")));
    }
}
