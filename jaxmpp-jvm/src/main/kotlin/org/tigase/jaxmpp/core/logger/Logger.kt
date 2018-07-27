package org.tigase.jaxmpp.core.logger

import java.util.logging.LogRecord

actual class Logger actual constructor(name: String) {

	private val log = java.util.logging.Logger.getLogger(name)

	private fun cnv(level: Level): java.util.logging.Level = when (level) {
		Level.OFF -> java.util.logging.Level.OFF
		Level.SEVERE -> java.util.logging.Level.SEVERE
		Level.WARNING -> java.util.logging.Level.WARNING
		Level.INFO -> java.util.logging.Level.INFO
		Level.CONFIG -> java.util.logging.Level.CONFIG
		Level.FINE -> java.util.logging.Level.FINE
		Level.FINER -> java.util.logging.Level.FINER
		Level.FINEST -> java.util.logging.Level.FINEST
		Level.ALL -> java.util.logging.Level.ALL
	}

	actual fun isLoggable(level: Level): Boolean {
		return log.isLoggable(cnv(level))
	}

	actual fun log(level: Level, msg: String) {
		log.log(cnv(level), msg)
	}

	actual fun log(level: Level, msg: String, caught: Exception) {
		log.log(cnv(level), msg, caught)
	}

	actual fun fine(msg: String) {
		log.fine(msg)
	}

	actual fun finer(msg: String) {
		log.finer(msg)
	}

	actual fun finest(msg: String) {
		val lr = LogRecord(java.util.logging.Level.FINEST, msg)
		log.log(lr)
	}

	actual fun config(msg: String) {
		log.config(msg)
	}

	actual fun info(msg: String) {
		log.info(msg)
	}

	actual fun warning(msg: String) {
		log.warning(msg)
	}

	actual fun severe(msg: String) {
		log.severe(msg)
	}

}