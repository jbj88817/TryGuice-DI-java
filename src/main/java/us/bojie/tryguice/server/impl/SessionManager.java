package us.bojie.tryguice.server.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

public class SessionManager {
    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(Provider<Long> sessionIdProvider) {
        this.sessionIdProvider = sessionIdProvider;
    }

    public Long getSessionId() {
        return sessionIdProvider.get();
    }
}
