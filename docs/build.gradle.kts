/*
 * halcyon-core
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

plugins {
	id("kr.motd.sphinx") version "2.10.0" apply true
	id("org.asciidoctor.jvm.convert") version "3.3.2"
}

asciidoctorj {
	modules {
		diagram.use()
	}
}

tasks {
	sphinx {
		println("${projectDir}")
		this.setSourceDirectory("${projectDir}/src/restructured")
		this.setOutputDirectory("${projectDir}/build/docs/sphinx")
		this.setEnvironments(mapOf("ENV_FOO" to "value1"))
		env("ENV_BAZ", "value3")
		tags
	}

	asciidoctor {
		baseDirFollowsSourceDir()
		setSourceDir(file("src/asciidoc"))
		sources(delegateClosureOf<PatternSet> {
			include("index.asciidoc")
		})
		options(mapOf("doctype" to "book", "ruby" to "erubis"))
		attributes(mapOf("source-highlighter" to "coderay", "toc" to "", "idprefix" to "", "idseparator" to "-"))
	}

}