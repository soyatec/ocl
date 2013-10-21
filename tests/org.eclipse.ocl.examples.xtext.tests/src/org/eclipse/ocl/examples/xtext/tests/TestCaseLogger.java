/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.tests;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A TestCaseLogger gathers any console output for rteview at the end of a test.
 */
public final class TestCaseLogger extends ConsoleAppender
	{
		public static final @NonNull TestCaseLogger INSTANCE = new TestCaseLogger();

		private static Logger rootLogger = Logger.getRootLogger();

		private boolean installed = false;
		private StringBuilder s = new StringBuilder();
		
		private TestCaseLogger() {
			super(new SimpleLayout(), SYSTEM_OUT); 
			setName("TestCaseLogger");
		}
		
		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				s.append(renderedMessage);
			}
//			super.append(event);
		}

		public void clear() {
			s.setLength(0);
		}

		public String get() {
			return s.toString();
		}
		
		public void install() {
			if (!installed) {
				rootLogger.addAppender(this);
				installed = true;
			}
			clear();
		}
		
		public void uninstall() {
			rootLogger.removeAppender(this);
			installed = false;
		}
	}