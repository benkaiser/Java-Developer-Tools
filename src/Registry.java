import java.util.HashMap;

public class Registry extends HashMap<String, Object> {
    // private constructor means only this one instance "singleton" is created
    private static Registry singleton = new Registry();

    // define string constants for the keys
    private static final String MODEL = "Model";

    // private constructor means only one instance can be created (i.e.
    // singleton)
    private Registry() {
        // add contents to the registry
        Model model = new Model();
        put(MODEL, model);
    }

    public static Model getModel() {
        return (Model) singleton.get(MODEL);
    }
}
