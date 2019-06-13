package com.practice.springcloud.feign.boot.transmission;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
public class TransmissionValExtractServletFilter extends OncePerRequestFilter {
    private final TransmissionProperties transmissionProperties;
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    public TransmissionValExtractServletFilter(TransmissionProperties transmissionProperties) {
        this.transmissionProperties = transmissionProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        List<String> headers = transmissionProperties.getHeaders();
        for (String header : headers) {
            String value = request.getHeader(header);
            TransmissionContextHolder.putKV(header, value);
            if (logger.isTraceEnabled()) {
                logger.trace("put " + header + " in thread-bound Transmission Context of request: " + request);
            }
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            TransmissionContextHolder.clear();
            if (logger.isTraceEnabled()) {
                logger.trace("cleared thread-bound Transmission Context of request: " + request);
            }
        }

    }
}
