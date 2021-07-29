package com.example.smallinvoicespringfeign.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * HasLogger is a feature interface that provides Logging capability for anyone
 * implementing it where logger needs to operate in serializable environment
 * without being static.
 */
interface HasLogger {

	default Logger getLogger() {
		return LoggerFactory.getLogger(getClass());
	}
}
