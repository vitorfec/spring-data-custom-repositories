/*
 * Copyright 2008-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.repository

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.data.repository.sample.User
import java.util.*

/**
 * Unit tests for ReadOnlyRepositoryExtensions.
 *
 * @author Vitor Carvalho
 */
class ReadOnlyRepositoryExtensionsTests {

	var repository = mockk<ReadOnlyRepository<User, String>>()

	@Test
	fun `ReadOnlyRepository#findByIdOrNull() extension should call its Java counterpart`() {

		val user = User()

		every { repository.findById("foo") }.returnsMany(Optional.of(user), Optional.empty())

		assertThat(repository.findByIdOrNull("foo")).isEqualTo(user)
		assertThat(repository.findByIdOrNull("foo")).isNull()
		verify(exactly = 2) { repository.findById("foo") }
	}
}