package us.bojie.tryguice.server.impl;


import com.google.inject.Guice;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertNotEquals;

public class SessionManagerTest {

    @Inject
    SessionManager sessionManager;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void testGetSessionId() throws InterruptedException{
        Long sessionId1 = sessionManager.getSessionId();
        Thread.sleep(1000);
        Long sessionId2 = sessionManager.getSessionId();
        assertNotEquals(sessionId2.longValue(), sessionId1.longValue());
    }

}
