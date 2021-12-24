package com.javaeefinal.itse1908r.javaeefinal.Log;




import com.javaeefinal.itse1908r.javaeefinal.Cache.EhCache;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Logged
@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

    static Logger log = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String data = " ";
        data += "REQUEST_METHOD: " + requestContext.getMethod();
        data += "MEDIA_TYPE: " + requestContext.getMediaType();
        EhCache.setCache(data);
        log.info(data);
    }
}