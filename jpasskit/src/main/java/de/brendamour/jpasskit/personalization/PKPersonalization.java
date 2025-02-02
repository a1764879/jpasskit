/*
 * Copyright (C) 2022 Patrice Brend'amour <patrice@brendamour.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.brendamour.jpasskit.personalization;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import de.brendamour.jpasskit.enums.PKPassPersonalizationField;

/**
 * Rewards enrollment lets you create a pass that prompts the user to sign up for a rewards program.
 * These passes are referred to as personalizable passes, because the user provides personal information during signup that is used to update the pass.
 *
 * @see <a href="https://developer.apple.com/library/prerelease/content/documentation/UserExperience/Conceptual/PassKit_PG/PassPersonalization.html">Rewards Enrollment</a>
 *
 * @author patrice
 * @author Igor Stepanov
 */
public class PKPersonalization implements Cloneable, Serializable {

    private static final long serialVersionUID = -7580722464940378982L;

    protected List<PKPassPersonalizationField> requiredPersonalizationFields;

    protected String description;
    protected String termsAndConditions;

    public List<PKPassPersonalizationField> getRequiredPersonalizationFields() {
        return requiredPersonalizationFields;
    }

    public String getDescription() {
        return description;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    @Override
    protected PKPersonalization clone() {
        try {
            return (PKPersonalization) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalStateException("Failed to clone PKPersonalization instance", ex);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static PKPersonalizationBuilder builder() {
        return new PKPersonalizationBuilder();
    }

    public static PKPersonalizationBuilder builder(PKPersonalization barcode) {
        return builder().of(barcode);
    }
}
