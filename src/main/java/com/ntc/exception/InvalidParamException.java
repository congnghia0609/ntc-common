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
public class InvalidParamException extends NException {
    public InvalidParamException() {
		super();
	}

	public InvalidParamException(String message) {
		super(message);
	}

	public InvalidParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidParamException(Throwable cause) {
		super(cause);
	}

	public InvalidParamException(int error) {
		super(error);
	}

	public InvalidParamException(int error, String message) {
		super(error, message);
	}

	public InvalidParamException(int error, String message, Throwable cause) {
		super(error, message, cause);
	}
}
