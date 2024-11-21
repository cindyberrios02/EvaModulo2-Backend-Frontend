package com.uniandes.calificaciones.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // Métodos de conveniencia para logging
    public static void logInfo(Logger logger, String message) {
        logger.info(message);
    }

    public static void logDebug(Logger logger, String message) {
        logger.debug(message);
    }

    public static void logError(Logger logger, String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void logWarn(Logger logger, String message) {
        logger.warn(message);
    }
}