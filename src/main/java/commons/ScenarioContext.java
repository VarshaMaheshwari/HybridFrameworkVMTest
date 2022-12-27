package commons;

import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;


    public ScenarioContext(Map<String, Object> scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(String key) {
        return scenarioContext.get(key);
    }

    public Boolean isContains(String key) {
        return scenarioContext.containsKey(key);
    }

}
