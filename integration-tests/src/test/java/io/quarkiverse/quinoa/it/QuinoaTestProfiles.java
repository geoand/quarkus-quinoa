package io.quarkiverse.quinoa.it;

import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class QuinoaTestProfiles {

    public static class EnableAndRunUITests implements QuarkusTestProfile {
        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of(
                    "quarkus.quinoa", "true",
                    "quarkus.quinoa.run-ui-tests", "true");
        }
    }

    public static class Enable implements QuarkusTestProfile {
        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of("quarkus.quinoa", "true");
        }
    }

    public static class YarnTests extends EnableAndRunUITests {
        @Override
        public String getConfigProfile() {
            return "yarn";
        }
    }

    public static class AngularTests extends Enable {
        @Override
        public String getConfigProfile() {
            return "angular";
        }
    }

    public static class LitTests extends Enable {
        @Override
        public String getConfigProfile() {
            return "lit";
        }
    }
}
