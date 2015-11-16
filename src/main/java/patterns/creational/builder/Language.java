package patterns.creational.builder;

import java.util.Set;

/**
 *  @ GOF description :
 *      The builder pattern is a design pattern that allows for the step-by-step creation of complex objects using
 *      the correct sequence of actions. The construction is controlled by a director object that only needs to know
 *      the type of object it is to create.
 *
 *  @ other description :
 *      Builder pattern aims to “Separate the construction of a complex object from its representation so that
 *      the same construction process can create different representations.”
 *
 *  @ Benefits :
 *      design flexibility
 *      parameters to the constructor are reduced
 *      highly readable method calls
 *
 */
public class Language {

    private final Integer id;
    private final String name;
    private final String languageFamily;
    private final Set<String> dialects;
    private final Set<String> countries;

    public Language(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.languageFamily = builder.languageFamily;
        this.dialects = builder.dialects;
        this.countries = builder.countries;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public Set<String> getDialects() {
        return dialects;
    }

    public Set<String> getCountries() {
        return countries;
    }

    public static class Builder {

        private final Integer id;
        private final String name;
        private String languageFamily;
        private Set<String> dialects;
        private Set<String> countries;

        /**
         *  mandatory fields
         */
        public Builder(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setLanguageFamily(String languageFamily) {
            this.languageFamily = languageFamily;
            return this;
        }

        public Builder setDialects(Set<String> dialects) {
            this.dialects = dialects;
            return this;
        }

        public Builder setCountries(Set<String> countries) {
            this.countries = countries;
            return this;
        }

        public Language build() {
            Language language = new Language(this);
            validate(language);
            return language;
        }

        private void validate(Language language) {
            // TODO : some validations can be done here
        }
    }
}
