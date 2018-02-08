/*
 * Copyright 2015 nghiatc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntc.exception;

/**
 *
 * @author nghiatc
 * @since Sep 22, 2015
 */
public class NException extends Exception {
    private int _error;
	private Object _attachment;

	public NException() {
		super();
	}

	public NException(String message) {
		super(message);
	}

	public NException(String message, Throwable cause) {
		super(message, cause);
	}

	public NException(Throwable cause) {
		super(cause);
	}

	////////////////////////////////////////////////////////////////////////////
	//additional constructors
	public NException(int error) {
		super();
		_error = error;
	}

	public NException(int error, String message) {
		super(message);
		_error = error;
	}

	public NException(int error, String message, Throwable cause) {
		super(message, cause);
		_error = error;
	}

	////////////////////////////////////////////////////////////////////////////
	//get/set methods
	public void setAttachment(Object attachment) {
		_attachment = attachment;
	}

	public Object getAttachment() {
		return _attachment;
	}

	public int getError() {
		return _error;
	}

	public void setError(int error) {
		_error = error;
	}
}
