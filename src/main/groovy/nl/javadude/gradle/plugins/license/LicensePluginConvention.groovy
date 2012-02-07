/* License added by: GRADLE-LICENSE-PLUGIN
 *
 * Copyright (C)2011 - Jeroen van Erp <jeroen@javadude.nl>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.javadude.gradle.plugins.license

import org.gradle.api.Project
import nl.javadude.gradle.plugins.license.types.LicenseFormat

class LicensePluginConvention {
	File license
    def licenseTypes = [:]

    def LicensePluginConvention(Project project) {
		license = new File(project.projectDir, "LICENSE")
        registerDefaultFileTypes()
	}

    private def registerDefaultFileTypes() {
        registerLicense('java', licenseFormat('/*', ' *', ' */'))
        registerLicense('scala', licenseFormat('/*', ' *', ' */'))
        registerLicense('groovy', licenseFormat('/*', ' *', ' */'))
        registerLicense('properties', licenseFormat('#'))
    }

    def registerLicense(String ext, LicenseFormat format) {
        licenseTypes[ext] = format
    }

    def licenseFormat(String linePrefix) {
        new LicenseFormat(prefix: linePrefix, line: linePrefix)
    }

    def licenseFormat(String licensePrefix, String linePrefix, String licenseSuffix) {
        new LicenseFormat(prefix: licensePrefix, line: linePrefix, suffix: licenseSuffix)
    }
}





