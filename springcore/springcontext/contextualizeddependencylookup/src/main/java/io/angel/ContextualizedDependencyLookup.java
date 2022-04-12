package io.angel;

interface Container {
    Object getDependency(String key);
}

interface ManagedComponent {
    void performLookup(Container container);
}

class Dependency {
}

public class ContextualizedDependencyLookup implements ManagedComponent {

    private Dependency dependency;

    @Override 
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }
}