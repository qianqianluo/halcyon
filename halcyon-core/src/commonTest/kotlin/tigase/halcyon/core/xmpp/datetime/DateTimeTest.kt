/*
 * Tigase Halcyon XMPP Library
 * Copyright (C) 2018 Tigase, Inc. (office@tigase.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 */
package tigase.halcyon.core.xmpp.datetime

import tigase.halcyon.core.timestampToISO8601
import kotlin.test.Test
import kotlin.test.assertEquals

class DateTimeTest {

	@Test
	fun testToISO8601() {
		assertEquals("2020-04-07T14:24:27.423Z", timestampToISO8601(1586269467423))
//		assertEquals("2020-04-07T16:24:27.423+02:00", timestampToISO8601(1586269467423))

	}

	@Test
	fun testParseISO8601() {
		assertEquals(1586269467423, tigase.halcyon.core.parseISO8601("2020-04-07T16:24:27.423+02:00"))
		assertEquals(1586269467423, tigase.halcyon.core.parseISO8601("2020-04-07T14:24:27.423Z"))
		assertEquals(1586269467000, tigase.halcyon.core.parseISO8601("2020-04-07T14:24:27Z"))
		assertEquals(1586269467000, tigase.halcyon.core.parseISO8601("2020-04-07T16:24:27+02:00"))
	}

}