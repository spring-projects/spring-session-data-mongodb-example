/*
 * Copyright 2017 the original author or authors.
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
package org.springframework.session.mongodb.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.session.data.mongo.ReactiveMongoOperationsSessionRepository;
import org.springframework.session.web.server.session.SpringSessionWebSessionManager;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import org.springframework.web.server.session.WebSessionManager;

/**
 * @author Greg Turnquist
 */
@Configuration
public class Config {

	@Bean(WebHttpHandlerBuilder.WEB_SESSION_MANAGER_BEAN_NAME)
	public WebSessionManager webSessionManager(ReactiveMongoOperations operations) {
		return new SpringSessionWebSessionManager(new ReactiveMongoOperationsSessionRepository(operations));
	}
}
